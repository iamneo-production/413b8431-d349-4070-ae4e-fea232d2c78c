package com.examly.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableScheduling
public class EmailApplication {
//	implements CommandLineRunner
//	@Autowired
	public static void main(String args[]) {
		SpringApplication.run(EmailApplication.class, args);
	}


}
