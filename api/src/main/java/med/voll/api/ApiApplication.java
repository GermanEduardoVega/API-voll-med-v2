package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	// The main method serves as the entry point of the Spring Boot application
	public static void main(String[] args) {
		// SpringApplication.run initializes and launches the Spring Boot application
		SpringApplication.run(ApiApplication.class, args);
		// Output a message to the console indicating the application is running
		System.out.println("Estoy funcionando v2");
	}
}
