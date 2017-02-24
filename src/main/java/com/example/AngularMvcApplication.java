package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.example.configuration.JpaConfiguration;
import com.example.configuration.SecurityConfiguration;
import com.example.configuration.WebMvcConfiguration;;

@Import({JpaConfiguration.class, SecurityConfiguration.class, WebMvcConfiguration.class})
@SpringBootApplication(scanBasePackages = { "com.example" })
public class AngularMvcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AngularMvcApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AngularMvcApplication.class);
    }

}
