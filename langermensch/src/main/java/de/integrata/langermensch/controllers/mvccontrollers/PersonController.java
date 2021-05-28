package de.integrata.langermensch.controllers.mvccontrollers;

import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import de.integrata.langermensch.repositories.PersonRepository;
import de.integrata.langermensch.repositories.entities.Person;

@Controller
@RequestScope
public class PersonController {
	
	private final PersonRepository repo;
	
	
	
	public PersonController(final PersonRepository repo) {
		this.repo = repo;
	}



	@GetMapping("/personen")
	public String getPersonen(Model model) {
		model.addAttribute("personen", repo.findAll());
		return "personen/index";
	}

	@GetMapping("/personen/{id}/loeschen")
	public String deletePerson(@PathVariable String id) {
		repo.deleteById(id);
		return "redirect:/personen"; // Zurück zum Index
	}

	@GetMapping("/personen/{id}/anzeigen")
	public String anzeigenPerson(@PathVariable String id, Model model) {
		Optional<Person> optional = repo.findById(id);
		model.addAttribute("person", optional.get());
		return "personen/anzeigen";
	}

	@GetMapping("/personen/{id}/bearbeiten")
	public String updatePerson(@PathVariable String id, Model model) {
		Optional<Person> optional = repo.findById(id);
		model.addAttribute("person", optional.get());
		return "personen/bearbeiten";
	}

	
	@PostMapping("/personen/save")
	public String savePerson(@ModelAttribute Person person) {
		repo.save(person);
		return "redirect:/personen";
	}

	@GetMapping("/personen/neu")
	public String neuePerson(Model model) {
		
		model.addAttribute("person", Person.builder().id(UUID.randomUUID().toString()).build());
		return "personen/bearbeiten";
	}


}
