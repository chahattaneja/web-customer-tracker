package com.ct.springdemo.aspect;

import java.util.logging.Logger;

import javax.servlet.jsp.jstl.sql.Result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	Logger logger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.ct.springdemo.controller.*.*(..))")
	public void forControllers() {}
	
	@Pointcut("execution(* com.ct.springdemo.service.*.*(..))")
	public void forServices() {}
	
	@Pointcut("execution(* com.ct.springdemo.dao.*.*(..))")
	public void forDaos() {}
	
	@Pointcut("forDaos() || forServices() || forControllers()")
	public void forAppFlow() { };
	
	@Before("forAppFlow()")
	public void before(JoinPoint joinPoint) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("calling method :" + method);
		
		for(Object arg : joinPoint.getArgs())
			logger.info(arg.toString());
	}
	
	@AfterReturning(
			pointcut="forAppFlow()",
			returning= "result"
			)
	public void afterAdvice(JoinPoint joinPoint, Object result) {
		String method = joinPoint.getSignature().toShortString();
		logger.info("calling method :" + method);
		
		logger.info(result.toString());
	}
}
