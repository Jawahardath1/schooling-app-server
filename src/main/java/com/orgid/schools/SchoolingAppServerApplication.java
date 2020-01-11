package com.orgid.schools;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

/**
 * @author Jawahar Dath Thangirala
 * Sep 9, 2019
 */
@SpringBootApplication
@EntityScan(basePackageClasses = { 
		SchoolingAppServerApplication.class,
		Jsr310JpaConverters.class 
})
public class SchoolingAppServerApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SchoolingAppServerApplication.class, args);
	}

}
