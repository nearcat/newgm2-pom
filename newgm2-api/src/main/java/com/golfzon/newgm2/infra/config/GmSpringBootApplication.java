package com.golfzon.newgm2.infra.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * API Spring Boot Application
 * com.golfzon.newgm2.infra.config GmSpringBootApplication.java
 * @author	sjisbmoc
 * @since	
 * @version	1.0
 * @see <pre>
 * == 계정이력(Modification Infomation) ==
 * 
 * 수정일			수정자		수정내용
 * ----------------------------------------
 * 2021. 4. 5.	sjisbmoc	최초생성
 * 
 * </pre>
 */
@SpringBootApplication
@EnableAsync
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class GmSpringBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(GmSpringBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(GmSpringBootApplication.class, args);
	}

}










