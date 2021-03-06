package com.fisiorctool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.fisiorctool.configuration.JpaConfiguration;
import com.fisiorctool.configuration.SecurityConfiguration;
import com.fisiorctool.configuration.WebMvcConfiguration;;

@Import({JpaConfiguration.class, SecurityConfiguration.class, WebMvcConfiguration.class})
@SpringBootApplication(scanBasePackages = { "com.fisiorctool" })
public class FisioRCToolApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FisioRCToolApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FisioRCToolApplication.class);
    }

}
