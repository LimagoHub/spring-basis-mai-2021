package de.intergrata.firstspring;

public class TranslatorToUpperImpl implements Translator {
	
	@Override
	public String translator(String message) {
		return message.toUpperCase();
	}

}
