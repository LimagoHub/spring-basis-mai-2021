package de.intergrata.firstspring;

public class Demo {

	private final Translator translator;

	public Demo(final Translator translator) {
		this.translator = translator;
		System.out.println(translator.translator("Ctor"));
	}

	public void print() {
		System.out.println(translator.translator("Hier ist demo"));
	}

	public void init() {
		System.out.println(translator.translator("Post Construct"));
	}

	public void destroy() {
		System.out.println(translator.translator("Pre destroy"));
	}

}
