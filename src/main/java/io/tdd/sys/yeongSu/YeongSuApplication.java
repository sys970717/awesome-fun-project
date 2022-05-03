package io.tdd.sys.yeongSu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class YeongSuApplication {
	@Value("${spring.profiles.active}")
	private String profile;

	public static void main(String[] args) {
		SpringApplication.run(YeongSuApplication.class, args);
	}

	@PostConstruct
	private void start() {
		System.out.println("profile = "+profile);
	}
}
