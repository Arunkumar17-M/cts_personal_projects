package com.demo.project;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs //Enable Spring Web Services
@Configuration //spring Configuration
public class WebServiceConfig {

	//MessageDispatcherServlet
	//AppliationContext
	//url -> /ws/*
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	
	@Bean(name = "courses")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema coureseSchema) {
		
		DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
		definition.setPortTypeName("CoursePort");
		definition.setTargetNamespace("http://example.com/courses");
		definition.setLocationUri("/ws");
		definition.setSchema(coureseSchema);
		
		return definition;
	}
	
//	@Bean
//	public Jaxb2Marshaller marshaller(){
//	    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//	    // this package must match the package in the <generatePackage> specified in
//	    // pom.xml
//	    marshaller.setContextPath("course-details.wsdl");
//	    return marshaller;
//	}
	
	@Bean
	public XsdSchema coureseSchema() {
		return new SimpleXsdSchema(new ClassPathResource("course-details.xsd"));
	}
	
	@Bean
	public RestTemplate restbean() {
		return new RestTemplate();
	}
}
