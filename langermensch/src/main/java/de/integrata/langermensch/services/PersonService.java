package de.integrata.langermensch.services;

import de.integrata.langermensch.repositories.entities.Person;

public interface PersonService {

	void speichern(Person person) throws PersonServiceException;

}