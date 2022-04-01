package com.my.toyprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.CacheControl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@EnableJpaAuditing
@SpringBootApplication
public class ToyprjApplication implements WebMvcConfigurer {


	public static void main(String[] args) {
		SpringApplication.run(ToyprjApplication.class, args);
	}

}
