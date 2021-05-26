package de.integrata.langermensch;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import de.integrata.langermensch.repositories.entities.Person;
import de.integrata.langermensch.services.PersonService;
import de.integrata.langermensch.services.PersonServiceException;

@Component
public class ToDeleteForTestOnly {
	
	private final PersonService personService ;

	public ToDeleteForTestOnly(PersonService personService) {
		this.personService = personService;
	}
	
	
	@PostConstruct
	public void run() {
		
		try {
			Person john = Person
					.builder()
					.id(UUID.randomUUID().toString())
					.vorname("Attila")
					.nachname("Doe")
					.build();
			
			personService.speichern(john);
		} catch (PersonServiceException e) {
			e.printStackTrace();
		}
	}

}
