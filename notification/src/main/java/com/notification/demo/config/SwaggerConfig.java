package com.notification.demo.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket apiDocs() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();

	}

	/**
	 * This method is used to for describing the details in swagger ui
	 * 
	 * @return
	 */
	private ApiInfo getInfo() {
		return new ApiInfo("Notification", "This project is developed by Raja", "1.0", "Terms of services",
				new Contact("Raja", "https://github/RajaYadav00", "rajaram.yadav@indusnet.co.in"), "License of api",
				"api License URL", Collections.emptyList());
	}
}
