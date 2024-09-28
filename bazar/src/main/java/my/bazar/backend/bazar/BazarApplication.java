package my.bazar.backend.bazar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BazarApplication {

	public static void main(String[] args) {
		SpringApplication.run(BazarApplication.class, args);
	}

	@Bean
	public OpenAPI springDocOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Bazaar API")
				.description("API de un Bazaar")
				.version("0.0.1-DEV"))
				.addServersItem(new Server().url("http://localhost:8080").description("Local"))
				.addServersItem(new Server().url("http://ec2-18-117-218-252.us-east-2.compute.amazonaws.com:8080").description("AWS"))				
			}
	
}
