package com.devlec.ApplicazioneRestSpringEsame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
class ApplicazioneRestSpringEsameApplicationTests {
	private static final Logger logger = LoggerFactory
			.getLogger(ApplicazioneRestSpringEsameApplicationTests.class);
	public String Saluto;
	public static void main(String[] args) {SpringApplication.run(ApplicazioneRestSpringEsameApplicationTests.class, args);}
	@Bean
	public CommandLineRunner commandLineRunner (ApplicationContext ctx) {
		return args -> {
			logger.debug(Saluto);
			SimpleDateFormat simpleDateFormat =
					new SimpleDateFormat("dd-MM-yyyy");
			Date a = simpleDateFormat.parse("23-04-2021");
			logger.info(a.toString());
			Date oggi = new Date();
			String oggiStringa = simpleDateFormat.format(oggi);
			logger.info("Oggi e' "+oggiStringa);
		};
	}
}
