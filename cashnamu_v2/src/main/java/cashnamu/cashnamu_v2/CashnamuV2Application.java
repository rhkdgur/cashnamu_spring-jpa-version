package cashnamu.cashnamu_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CashnamuV2Application {

	public static void main(String[] args) {
		SpringApplication.run(CashnamuV2Application.class, args);
	}

}
