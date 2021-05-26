package de.integrata.langermensch.services;

import java.util.List;

import de.integrata.langermensch.repositories.entities.Person;

public interface PersonService {

	void speichern(Person person) throws PersonServiceException;
	void massenSpeichern(List<Person> personen) throws PersonServiceException;
}