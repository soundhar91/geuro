package main.java.com.geuro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import main.java.com.geuro.parser.InputParser;
import main.java.com.geuro.service.CityMapService;

@SpringBootApplication
public class application {
	public static void main(String[] args) {
		SpringApplication.run(application.class, args);
		InputParser parser = new InputParser(args[0]); //filename check
		parser.parse();
	}

}
