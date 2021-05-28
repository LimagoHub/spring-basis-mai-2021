package de.integrata.langermensch.aspekte;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggerAspect {
	
	
	@Before("PointCuts.calculatorMethodes()")
	public void logBeforeAdvice(JoinPoint joinPoint) {
		log.warn("Methode {} wurde aufgerufen", joinPoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut="PointCuts.calculatorMethodes()",returning = "retObject")
	public void logAfterAdvice(JoinPoint joinPoint, Object retObject) {
		log.warn("Methode  wurde beendet");
	}
	
	@AfterThrowing(pointcut="PointCuts.calculatorMethodes()",throwing = "ex")
	public void logAfterAdvice(JoinPoint joinPoint, Throwable ex) {
		log.error(ex.getMessage(), ex);
	}
	
	
//	@Around(value = "execution(* de.integrata.langermensch.controllers.restcontroller.PersonRestController.*(..))")
//	public Object logAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//		Object retval = null;
//		try {
//			log.warn("Ich passe auf!");
//			retval = joinPoint.proceed();
//			log.warn("yyy" + retval);
//		} catch (Throwable e) {
//			log.error(e.toString(), e);
//			throw e;
//		}finally {
//			log.warn("xxx" + retval);
//		}
//		
//		return retval;
//	}
}
