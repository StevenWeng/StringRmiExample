package com.irsa.example.rmi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.irsa.example.rmi.RequestService;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("client-beans.xml");
		RequestService requestService = (RequestService) ctx.getBean("requestServiceProxy");
		Double bmi = requestService.getBmi(177.7, 74.5);
		System.out.println(bmi);
	}

}
