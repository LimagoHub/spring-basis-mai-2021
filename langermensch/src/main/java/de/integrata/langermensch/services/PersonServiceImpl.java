package de.integrata.langermensch.services;

import org.springframework.stereotype.Service;

import de.integrata.langermensch.repositories.PersonRepository;
import de.integrata.langermensch.repositories.entities.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	public PersonServiceImpl(final PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	@Override
	public void speichern(Person person) throws PersonServiceException {
		try {
			speichernImpl(person);
		} catch (RuntimeException e) {
			throw new PersonServiceException(e);
		}
	
	}

	private void speichernImpl(Person person) throws PersonServiceException {
		checkPerson(person);
		
		personRepository.save(person);
	}

	private void checkPerson(Person person) throws PersonServiceException {
		validatePerson(person);
		
		businessCheck(person);
	}

	private void businessCheck(Person person) throws PersonServiceException {
		if(person.getVorname().equals("Attila"))
			throw new PersonServiceException("Antipath");
	}

	private void validatePerson(Person person) throws PersonServiceException {
		if(person == null)
			throw new PersonServiceException("Person darf nicht null sein.");
		
		if(person.getVorname() == null || person.getVorname().length() < 2)
			throw new PersonServiceException("Vorname muss min. 2 Zeichen enthalten.");

		if(person.getNachname() == null || person.getNachname().length() < 2)
			throw new PersonServiceException("Nachname muss min. 2 Zeichen enthalten.");
	}
	
}
