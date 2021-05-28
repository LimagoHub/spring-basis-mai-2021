package de.integrata.langermensch.aspekte;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

	
//	@Before(value = "execution(* de.integrata.langermensch.controllers.restcontroller.PersonRestController.*(..))")
//	public void logBeforeAdvice(JoinPoint joinPoint) {
//		log.warn("Methode {} wurde aufgerufen", joinPoint.getSignature().getName());
//	}
	
	@Around(value = "execution(* de.integrata.langermensch.controllers.restcontroller.PersonRestController.*(..))")
	public Object logAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object retval = null;
		try {
			log.warn("Ich passe auf!");
			retval = joinPoint.proceed();
			log.warn("yyy" + retval);
		} catch (Throwable e) {
			log.error(e.toString(), e);
			throw e;
		}finally {
			log.warn("xxx" + retval);
		}
		
		return retval;
	}
}
