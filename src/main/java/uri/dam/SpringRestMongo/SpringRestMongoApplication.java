package uri.dam.SpringRestMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class SpringRestMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestMongoApplication.class, args);
	}

}
