package de.integrata.langermensch.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.integrata.langermensch.repositories.entities.Person; 

public interface PersonRepository extends CrudRepository<Person, String>{
	
	List<Person> findByVorname(String vorname);
	List<Person> findByNachname(String nachname);
	List<Person> findByVornameAndNachnameOrderByNachnameDesc(String vorname, String nachname);

}
