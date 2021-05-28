package de.integrata.langermensch.controllers.mvccontrollers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.integrata.langermensch.repositories.entities.Person;

@Controller
public class GreetingController {

	@GetMapping("/index.html")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) {
		List<Person> johns = Arrays.asList(Person.builder()

				.id(UUID.randomUUID().toString()).vorname("John").nachname("Doe").build(),
				Person.builder()

						.id(UUID.randomUUID().toString()).vorname("John").nachname("Wayne").build(),
				Person.builder()

						.id(UUID.randomUUID().toString()).vorname("John").nachname("Rambo").build(),
				Person.builder()

						.id(UUID.randomUUID().toString()).vorname("John").nachname("Wick").build(),
				Person.builder()

						.id(UUID.randomUUID().toString()).vorname("John").nachname("McClaine").build(),
				Person.builder()

						.id(UUID.randomUUID().toString()).vorname("John Boy").nachname("Walton").build()

		);

//		Optional<Person> optionalPerson = Optional.empty();

		model.addAttribute("name", name);
		model.addAttribute("ort", "Darmstadt");
		model.addAttribute("johns", johns);
		return "public/index";
	}

}
