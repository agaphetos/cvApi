package org.agaphetos.cv.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("org.agaphetos")
@EntityScan("org.agaphetos.cv.entity")
@EnableJpaRepositories("org.agaphetos.cv.repository")
public class CvApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CvApiApplication.class, args);
	}
}
