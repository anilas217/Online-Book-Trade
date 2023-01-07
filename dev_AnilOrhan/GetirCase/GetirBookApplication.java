package dev_AnilOrhan.GetirCase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class GetirBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetirBookApplication.class, args);
       System.out.println("hello");
	}

}
