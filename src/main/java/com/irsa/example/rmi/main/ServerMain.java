package com.irsa.example.rmi.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.irsa.example.rmi.CallbackService;
import com.irsa.example.rmi.impl.CallbackServiceImpl;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("server-beans.xml");
		CallbackServiceImpl callbackService = (CallbackServiceImpl) ctx.getBean("callbackService");
		callbackService.start();
	}

}
