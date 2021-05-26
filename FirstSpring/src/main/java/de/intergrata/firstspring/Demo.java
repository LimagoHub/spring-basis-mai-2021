package de.intergrata.firstspring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Demo {

	
	private final Translator translator;

	@Autowired
	public Demo(final Translator translator) {
		this.translator = translator;
		System.out.println(translator.translator("Ctor Demo"));
	}

	
	@PostConstruct
	public void print() {
		System.out.println("Hier ist demo");
		
	}

	@PostConstruct
	public void init() {
		System.out.println(translator.translator("Post Construct Demo") );
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Pre destroy Demo");
	}

}
