package de.application;

import de.client.CalcClient;
import de.common.LoggerProxy;
import de.math.Calculator;
import de.math.CalculatorImpl;
import de.math.CalculatorLogger;
import de.math.CalculatorSecure;

public class Application {

	public static void main(String[] args) {

		Calculator calculator = new CalculatorImpl(); // calculator -> 1000
		//calculator = new CalculatorLogger(calculator); // calculator -> 2000
		calculator = (Calculator) LoggerProxy.newInstance(calculator);
		
		calculator = new CalculatorSecure(calculator); // calculator -> 3000
		CalcClient client = new CalcClient(calculator);
		
		client.run();

	}

}
