package com.sokkheang.huo.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sokkheang.huo.common.upload.StorageProperties;

@EnableConfigurationProperties(StorageProperties.class)
@EnableScheduling
@SpringBootApplication
public class NgxSpringOauthServerApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(NgxSpringOauthServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(NgxSpringOauthServerApplication.class);
	}
}
