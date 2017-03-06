package com.fisiorctool.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if(exception instanceof BadCredentialsException){
			request.setAttribute("error", "Usuario o contraseña incorrectos");
		} else {
			request.setAttribute("error", exception.getMessage());
		}
		
		setDefaultFailureUrl("/login_error");
		setUseForward(true);
		super.onAuthenticationFailure(request, response, exception);
	}
	
}
