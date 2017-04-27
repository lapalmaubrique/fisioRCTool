package com.fisiorctool.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.fisiorctool.exceptions.UserExistException;
import com.fisiorctool.model.User;
import com.fisiorctool.model.UserRole;
import com.fisiorctool.model.UserToken;
import com.fisiorctool.repositories.IUserRepository;

@Service
@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class UserServiceImpl implements UserService {

	private static final String ROLE_USER = "ROLE_USER";

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private UserTokenService userTokenService;

	@Autowired
	private Environment environment;

	@Transactional
	@Override
	public User register(User user, HttpServletRequest request) throws UserExistException{
		User userBD = this.findByEmail(user.getEmail());
		if(userBD == null){
			String securedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
			user.setPassword(securedPassword);
			user.setEnabled(false);
			user.setRegistrationDate(new Date());
			user = userRepository.save(user);

			UserRole userRole = new UserRole(user, ROLE_USER);
			userRoleService.save(userRole);

			sendEmailActivateUser(user, request);
		} else {
			throw new UserExistException("El email ya existe");
		}
		return user;
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void activeUser(String token) {
		UserToken userToken = new UserToken(token);
		userToken = userTokenService.findByToken(userToken);
		
		if(userToken != null){
			userTokenService.delete(userToken.getId());
			
			User user = userRepository.findOne(userToken.getUserId());
			user.setEnabled(true);
			userRepository.save(user);
		}
	}

	/**
	 * METODOS PRIVADOS
	 */
	private void sendEmailActivateUser(User user, HttpServletRequest request) {
		Properties props = new Properties();
		props.put("mail.smtp.auth", environment.getRequiredProperty("mail.smtp.auth"));
		props.put("mail.smtp.host", environment.getRequiredProperty("mail.smtp.host"));
		props.put("mail.smtp.port", environment.getRequiredProperty("mail.smtp.port"));
		props.put("mail.smtp.socketFactory.port", environment.getRequiredProperty("mail.smtp.socketFactory.port"));
		props.put("mail.smtp.socketFactory.class", environment.getRequiredProperty("mail.smtp.socketFactory.class"));

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(environment.getRequiredProperty("mail.username"), 
							environment.getRequiredProperty("mail.password"));
				}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(environment.getRequiredProperty("mail.username")));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
			message.setSubject("Información de registro");
			StringBuilder content = new StringBuilder();
			content.append("Querido "+user.getFullName()+ ", bienvenido a la plataforma FisioRCTool, pulse el siguiente enlace para finalizar el registro.<br/><br/>"); 
			
			String random = java.util.UUID.randomUUID().toString();
			String uri = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/activeUser?token="+random;
			content.append("<a href='"+uri+"'>"+uri+"</a>");
			content.append("<br/><br/>Gracias.");
			message.setContent(content.toString(), "text/html");
			Transport.send(message);
			
			UserToken userToken = new UserToken(random, user.getId());
			userTokenService.save(userToken);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
