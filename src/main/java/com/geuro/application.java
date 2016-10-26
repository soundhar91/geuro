package main.java.com.geuro;

import java.io.File;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
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
public class Application {
	static Logger logger = Logger.getLogger(InputParser.class);
	private static InputParser staticParser;

	@Autowired
	private InputParser parser;

	@PostConstruct
	public void init() {
		Application.staticParser = parser;
	}

	public static void main(String[] args) {
		if (args.length != 1) {
			logger.error("Please pass the only the file name as an argument.");
		}
		
		SpringApplication.run(Application.class, args);
		staticParser.parse(args[0]);
	}

}
