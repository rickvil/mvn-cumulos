package com.softlogia.framework.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * @author Pablo Marquez
 *
 */
public class SpringUtilLocal {
	public static final ApplicationContext contexto = new ClassPathXmlApplicationContext("META-INF/spring/commonModelContext.xml"); 
}
