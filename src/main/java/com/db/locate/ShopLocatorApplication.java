package com.db.locate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages={"com.db.locate"})
@EnableAutoConfiguration
public class ShopLocatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopLocatorApplication.class, args);
	}
}
