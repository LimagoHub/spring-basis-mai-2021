package de.integrata.langermensch.application;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.integrata.langermensch.repositories.PersonRepository;
import de.integrata.langermensch.services.PersonService;
import de.integrata.langermensch.services.PersonServiceImpl;

@Configuration
public class PersonConfig {
	
	
	
	@Bean
	@Qualifier("antipathen")
	public List<String> unsympath() {
		return Arrays.asList("Attila", "Peter","Paul","Mary");
	}

	@Bean
	@Qualifier("fruechte")
	public List<String> fruits() {
		return Arrays.asList("Apple", "Banana","Raspberry","cherry");
	}
	
	@Bean
	public PersonService createPersonenService( PersonRepository personRepository, @Qualifier("antipath") List<String> antipathen) {
		return new PersonServiceImpl(personRepository,antipathen);
	}
	
	
}
