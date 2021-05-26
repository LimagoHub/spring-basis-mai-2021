package de.integrata.langermensch.services;

import java.util.List;

import de.integrata.langermensch.repositories.PersonRepository;
import de.integrata.langermensch.repositories.entities.Person;



public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;
	private final List<String> antipathen;

	public PersonServiceImpl(final PersonRepository personRepository,  final List<String> antipathen) {
		this.personRepository = personRepository;
		this.antipathen = antipathen;
	}
	
	@Override
	
	public void speichern(Person person) throws PersonServiceException {
		try {
			speichernImpl(person);
		} catch (RuntimeException e) {
			throw new PersonServiceException(e);
		}
	
	}

	@Override
	public void massenSpeichern(List<Person> personen) throws PersonServiceException {
		for (Person person : personen) {
			speichern(person);
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
		if(antipathen.contains(person.getVorname()))
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
