package de.integrata.langermensch.controllers.mvccontrollers;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.integrata.langermensch.repositories.entities.Person;

@Controller
public class GreetingController {

	@GetMapping("/index.html")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name,Model model) {
		Person john = Person.builder()
				
				.id(UUID.randomUUID().toString())
				.vorname("John")
				.nachname("Doe")
				.build();
		
		model.addAttribute("name", name);
		model.addAttribute("ort", "Darmstadt");
		model.addAttribute("john", john);
		return "public/index";
	}

	

}
