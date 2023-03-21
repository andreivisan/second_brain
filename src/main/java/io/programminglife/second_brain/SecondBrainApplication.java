package io.programminglife.second_brain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SecondBrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondBrainApplication.class, args);
	}

}
