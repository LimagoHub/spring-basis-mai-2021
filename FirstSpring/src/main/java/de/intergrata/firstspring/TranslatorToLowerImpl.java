package de.intergrata.firstspring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TranslatorToLowerImpl implements Translator {
	
	@Override
	public String translator(String message) {
		return message.toLowerCase();
	}

}
