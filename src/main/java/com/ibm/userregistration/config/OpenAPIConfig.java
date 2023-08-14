/**
 * 
 */
package com.ibm.userregistration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * 
 */
@Configuration
public class OpenAPIConfig {
	
	  @Bean
	  public OpenAPI openAPIVal() {
	   
	    Info info = new Info()
	        .title("User Registration API")
	        .version("1.0")
	        .description("This API exposes endpoints to manage user registration");

	    return new OpenAPI().info(info);
	  }

}
