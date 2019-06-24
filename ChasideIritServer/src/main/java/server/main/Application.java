package server.main;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import server.main.exception.ServerSystemException;



@SpringBootApplication
public class Application {

	public static void main(String[] args) throws ServerSystemException {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

	
	}

}

