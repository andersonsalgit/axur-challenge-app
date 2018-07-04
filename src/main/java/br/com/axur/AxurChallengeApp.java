package br.com.axur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AxurChallengeApp {

	public static void main(String[] args) {
		SpringApplication.run(AxurChallengeApp.class, args);
	}
}
