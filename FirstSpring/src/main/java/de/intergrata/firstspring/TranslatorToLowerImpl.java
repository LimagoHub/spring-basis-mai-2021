package de.intergrata.firstspring;

public class TranslatorToLowerImpl implements Translator {
	
	@Override
	public String translator(String message) {
		return message.toLowerCase();
	}

}
