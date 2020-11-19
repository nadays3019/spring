package org.kg.myapp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeTracer {

	/*
	 * bean(helloController) 
	 * within(org.kg.myapp.HelloController)
	 * execution(* org..HelloController.*(..))
	 */
	@Around(value="execution(* org..HelloController.*(..))")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end-start));
		return result;
	}
}
