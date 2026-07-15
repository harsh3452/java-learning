package com.harsh;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        //we don't have object yet only the container if the .xml file is empty
        Dev dev = (Dev) context.getBean("dev"); // can give the id here instead of Dev.class, but we need to caste it
        dev.build();
        System.out.println(dev.getAge()); // age is being injected by spring.xml
    }
}
