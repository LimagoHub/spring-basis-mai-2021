package de.integrata.langermensch.application;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.integrata.langermensch.repositories.entities.Person;
import de.integrata.langermensch.services.PersonService;
import de.integrata.langermensch.services.PersonServiceException;

@Component
@Transactional
public class PersonServiceHandler {
	
	private final PersonService personService ;

	public PersonServiceHandler(PersonService personService) {
		this.personService = personService;
	}
	
	
	public void handleSpeichern(Person p) {
		
		try {
			
			personService.speichern(p);
			// Hat geklappt event
		} catch (PersonServiceException e) {
			e.printStackTrace();
			// OgottogottEvent feuern
		}
	}

	
	public void handleMassenspeichern(List<Person> p) {
		
		try {
			
			personService.massenSpeichern(p);
			// Hat geklappt event
		} catch (PersonServiceException e) {
			e.printStackTrace();
			// OgottogottEvent feuern
		}
	}

}
