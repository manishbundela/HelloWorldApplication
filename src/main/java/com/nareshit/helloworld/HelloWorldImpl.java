package com.nareshit.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //in Real Classes
public class HelloWorldImpl {
	
	@RequestMapping(value="/") //in Real Classes
	public String getHelloWorld() {
		return "Welcome to Spring Boot 8 to 9 AM Batch from Naresh IT";
	}
	
	
	//HelloWorldImpl obj=new HelloWorldImpl();
	//obj.getHelloWorld();

}
