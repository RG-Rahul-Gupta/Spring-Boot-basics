package com.customer.management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile("!dev")
@PropertySource(value = {"classpath:application.dev-properties"})
public class SwaggerConfig {
	
	@Bean
	public Docket libraryApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                                           .groupName("Customer-Management-API")
                                                      .select().apis(RequestHandlerSelectors
                                                      .basePackage("com.customer.management")).build();
		
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("Customer-Management-API")
				                   .description("Customer-Management-API for Customer Relation Management")
				                   .termsOfServiceUrl("www.CustomerManagement.co.in")
				                   .contact(new Contact("Customer-Management-API","customermanagement@helpdesk", "+91-7249918661"))
				                   .license("CRM-Licensing-Authority")
				                   .licenseUrl("CRM.co.in")
				                   .version("1.0")
				                   .build();
		
	}

}
