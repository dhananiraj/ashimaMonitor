package com.ashimaFabMonitor;

import com.ashimaFabMonitor.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AshimaFabMonitorApplication {

	@Autowired
	static RestService restService;

	public static void main(String[] args) {

		SpringApplication.run(AshimaFabMonitorApplication.class, args);
//		System.out.println(restService.getPostsPlainJSON());

	}

}
