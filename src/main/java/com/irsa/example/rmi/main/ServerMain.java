package com.irsa.example.rmi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("server-beans.xml");
		RmiServiceExporter requestServiceExporter = (RmiServiceExporter) ctx.getBean("requestServiceExporter");
		System.out.println(requestServiceExporter.getServiceInterface());
	}

}
