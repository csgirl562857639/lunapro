package com.lumia.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext( "application-context.xml" );
		context.getBean( "" );
	}
}
