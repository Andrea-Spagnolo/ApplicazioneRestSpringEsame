package com.devlec.ApplicazioneRestSpringEsame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class ApplicazioneRestSpringEsameApplication {
	//creazione attributo log
	private static final Logger logger = LoggerFactory
			.getLogger(ApplicazioneRestSpringEsameApplication.class);
	//utilizzo di una chiave delle priprieta di Spring
	@Value("${com.devlec.ApplicazioneRestSpringEsame.saluti}")
	public String salutoIniziale;
	//MAIN inizia qui
	public static void main(String[] args) {
		SpringApplication.run(ApplicazioneRestSpringEsameApplication.class, args);
	}
	//il primo bean
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {

		return args -> {
		logger.debug(salutoIniziale);
		String[] beans = ctx.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String bean : beans) {
			logger.debug(bean);
		}
		for(int i=0; i<beans.length; i++){
			logger.warn(beans[i]);
		}
		for(int i=0; i<10; i++){
			logger.error(beans[i]);
		}
		//codice manipolazione date
		SimpleDateFormat simpleDateFormat =
				new SimpleDateFormat( "dd-MM-yyyy");
		Date a = simpleDateFormat.parse(  "23-04-2021");
		logger.info(a.toString());
		Date oggi = new Date();
		String oggiStringa = simpleDateFormat.format(oggi);
		logger.info("Ciao oggi e' "+oggiStringa);
		SimpleDateFormat anno = new SimpleDateFormat(  "yyyy");
		logger.info("Siamo nell'anno: "+anno.format(new Date()));
	};
}
}
