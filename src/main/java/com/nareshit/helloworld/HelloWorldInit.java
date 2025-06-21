package com.nareshit.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Bootstrap Class ==> Stating Point

@SpringBootApplication


/*
 * 
 * A Java Class which is having @SpringBootApplication Annotation ==> Boot Strap Class
 * 
 * Every Project should have only one bootstrap class 
 * 
 * Bootstrap ==> Starting Point
 * 
 * 1) It is going to create an IOC Container ===> A seperate Memory area which manages all the objects efficiently
 *          Efficiency ==> Framework will create object,manage the state of an object and destory the object
 *          
 *          Employee emp=new Employee(); ==> emp=null;
 *          
 *          Employee emp=ioc.getEmployee();
 *          
 *       This IOC automatically manages the lifecycle of all developer classes as well as frameworkclasses
 *  
 *  2) This will create dispatcher servlet ==> 
 *            product functionality 
 *            customer functionliaty
 *            payment functionality
 *            discount functionality
 *            
 *            We will register all our functionalities to dispatcherservlet and this will take care navigation
 *            
 *    3) Autoconfiguration : In Class path if any entries need to be loaded on startup ==> 
 *                           Automatically it will identify and loads them into memory
 *                           
 *                               WebapplicationContext should be created
 *                               Memory Initilization of IOC
 *                               Tomcat Initiliaization
 *                               In Memory Database Initialization 
 */
public class HelloWorldInit {

	public static void main(String[] args) {
		
		SpringApplication.run(HelloWorldInit.class, args);
		
		//This line will create WebapplicationContext 
		
		/*
		 *   All the java programs created by developer should be availble in sepearete memory area
		 *   
		 *   <bean id="emp" class="com.nareshit.Employee" scope="singleton"> ==> Spring ==> nareshit.xml
		 *   
		 *   ApplicationContedt context=new XMLWebApplicationConext("nareshit.xml");
		 *   
		 *   
		 *   WebApplicationContext will be created with the below logic
		 *   
		 *   By default it will scan all the java files in bootstrap package and bootstrap subpackage 
		 *   and move them IOC Container
		 *   
		 *   com.amazon.ecommerce ==> com.amazon.ecommerce.Order ==> Ordering Functionality
		 *   					  ==> com.amazon.ecommerce.Product ==> Product Functionality
		 *   					  ==> com.amazon.ecommerce.Payment ==> Payment Functionality
		 *   					  ==> com.amazon.ecommerce.Cart ==> Cart Functionality		
		 *   					  ==> com.amazon.ecommerce.Discount ==> Discount Functionality
		 *   					  ==> com.amazon.ecommerce.Shipment ==> Shipment Functionality
		 *   
		 *   
		 *   
		 * 
		 */

	}

}
