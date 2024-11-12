package com.team1.veterinary;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VeterinaryApplication {

	public static void main(String[] args) {
		/*otenv dotenv = Dotenv.load();
		System.setProperty("env.PORT", dotenv.get("PORT"));
		System.setProperty("env.USERNAME", dotenv.get("USERNAME"));
		System.setProperty("env.PASSWORD", dotenv.get("PASSWORD"));*/
		SpringApplication.run(VeterinaryApplication.class, args);
	}

}
