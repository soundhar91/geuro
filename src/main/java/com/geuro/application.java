package main.java.com.geuro;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.geuro.impl.*;
import main.java.com.geuro.parser.InputParser;
import main.java.com.geuro.service.CityMapService;

@SpringBootApplication
@ComponentScan("main.java.com")
public class application {
	private static InputParser staticParser;
	
	@Autowired
	private InputParser parser;
	
	@PostConstruct
	public void init(){
		application.staticParser = parser;
	}
	public static void main(String[] args) {
		SpringApplication.run(application.class, args);
		File f = new File(args[0]);
		staticParser.parse(f);
	}

}
