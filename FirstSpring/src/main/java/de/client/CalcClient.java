package de.client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import de.math.Calculator;


@Component
public class CalcClient {
	
	
	private final Calculator calculator;
	
	
	//@Autowired
	public CalcClient(@Qualifier("logger") final Calculator calculator) {
		this.calculator = calculator;
		System.out.println("Ctor");
	}



	@PostConstruct // init-method
	public void run() {

		System.out.println(calculator.add(3, 4));

	}

}
