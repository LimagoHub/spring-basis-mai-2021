package de.integrata.langermensch.controllers.restcontroller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import de.integrata.langermensch.repositories.PersonRepository;
import de.integrata.langermensch.repositories.entities.Person;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;


@RestController
@RequestMapping("/v1/personen")
public class PersonRestController {
	
	private final PersonRepository repo;

	public PersonRestController(final PersonRepository repo) {
		this.repo = repo;
	}
	
	// Parameter via URL übergeben (nur einfache Typen wie String, int etc. Keine Objekte
	
	@GetMapping(path="/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Person> getPerson(@PathVariable String id) {
		return ResponseEntity.of(repo.findById(id));
	}
	
	
	// Parameter via URL mit "?"-Operator als Key-Value Pairs übergeben (nur einfache Typen wie String, int etc. Keine Objekte
	// z.B. http://localhost:8080/v1/personen?vorname=fritz&nachname=schmitt
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Person>> getAllPerson(@RequestParam(required = false) String vorname, @RequestParam(required = false) String nachname) {
		return ResponseEntity.ok(repo.findAll());
	}
	
	
	@DeleteMapping(path="/{id}")
	@ApiResponse(responseCode = "404", description = "person not found")
	@ApiResponse(responseCode = "200", description = "person deleted")
	public ResponseEntity<Void> deletePerson(@PathVariable String id) {
		
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	// Parameterobjekte  via Body als JSON, XML, .... übergeben
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponse(responseCode = "201", description = "person inserted")
	@ApiResponse(responseCode = "200", description = "person updated")
	public ResponseEntity<Void> speichereOderEinfuegenPerson(@Parameter(description = "Person to save", required = true)@Valid  @RequestBody Person person) {
		boolean exists = repo.existsById(person.getId())	;
		repo.save(person);
		if(exists)
			return ResponseEntity.status(HttpStatus.OK).build();
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	

	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponse(responseCode = "201", description = "person inserted")
	public ResponseEntity<Void> Save(@RequestBody Person person,  UriComponentsBuilder b) {
		person.setId(UUID.randomUUID().toString());
		repo.save(person);
		
		UriComponents uriComponents = b.path("v1/personen/{id}").buildAndExpand(person.getId());
		return ResponseEntity.created(uriComponents.toUri()).build();
	}
	
	
	// Rotes Post weil eigentlich get
	@PostMapping(path = "/toUpper",consumes = MediaType.APPLICATION_JSON_VALUE, produces  = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Person> toUpper(@RequestBody Person person) {
		person.setVorname(person.getVorname().toUpperCase());
		person.setNachname(person.getNachname().toUpperCase());
		return ResponseEntity.ok(person);
	}
	


}


//<dependency>
//<groupId>org.springdoc</groupId>
//<artifactId>springdoc-openapi-ui</artifactId>
//<version>1.5.9</version>
//</dependency>


//Verb		Safe	Idempotent		
//GET		ja		ja		Daten holen
//DELETE	nein	ja		löscht daten
//PUT		nein	ja		save oder update
//POST		nein	nein	save oder update
//				
//POST		ja	ja		daten mittels Parameterobjekt holen
