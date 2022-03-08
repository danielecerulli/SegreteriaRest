package it.epicode.be.segreteriarest.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.be.segreteriarest.model.ArchivioDati;
import it.epicode.be.segreteriarest.model.Studente;



@Configuration
public class DataConfig {

	@Bean
	public ArchivioDati archivioDati() {
		return new ArchivioDati();
	}
	
	@Bean
	@Scope("prototype")
	public Studente studente() {
		return new Studente();
	}
}
