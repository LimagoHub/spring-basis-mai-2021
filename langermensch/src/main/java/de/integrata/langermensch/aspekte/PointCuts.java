package de.integrata.langermensch.aspekte;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {
	
	@Pointcut(value = "execution(* de.integrata.langermensch.controllers.restcontroller.PersonRestController.*(..))")
	public void calculatorMethodes(){}

}
