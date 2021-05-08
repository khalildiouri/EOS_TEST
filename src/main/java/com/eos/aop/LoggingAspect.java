package com.eos.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger logger = LoggerFactory
			.getLogger(LoggingAspect.class);

	@Pointcut("execution(* com.eos.controllers.UserController.*(..))")
	public void userController() {
	}

	/**
	 * executed after all call from UserController with param HttpServletRequest
	 * @param joinPoint
	 * @param request
	 * @param result
	 */
	@Before(value = "userController() && args(..,request)")
	public void logAction(JoinPoint joinPoint, HttpServletRequest request) {

		String params = getParams(joinPoint);
		logger.info("EOS_LOG ========> -Method: " + request.getMethod() + " "
				+ "-Path: " + request.getServletPath() + " -Params: " + params);
	}

	/**
	 * executed after each call from UserController with param HttpServletRequest
	 * @param joinPoint
	 * @param request
	 * @param result
	 */
	@AfterReturning(pointcut = "userController()  && args(..,request)", returning = "result")
	public void logAfter(JoinPoint joinPoint, HttpServletRequest request,
			Object result) {
		String returnValue = this.getValue(result);
		logger.info("EOS_LOG <======== -Method: " + request.getMethod() + " "
				+ "-Path: " + request.getServletPath() + " -Result: "
				+ returnValue);
	}

	/**
	 * the goal of this method is to calculate processing time of each call from UserController
	 * @param joinPoint
	 * @param request
	 * @param result
	 */
	@Around(value = "userController() && args(..,request)")
	public Object logAround(ProceedingJoinPoint joinPoint,
			HttpServletRequest request) throws Throwable {

		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			logger.info("EOS_LOG -Method: " + request.getMethod() + " "
					+ "-Path: " + request.getServletPath()
					+ " time processing: " + elapsedTime + "ms ");

			return result;
		} catch (IllegalArgumentException e) {
			logger.info("Illegal argument "
					+ Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}

	private String getValue(Object result) {
		String returnValue = null;
		if (null != result) {
			if (result.toString().endsWith(
					"@" + Integer.toHexString(result.hashCode()))) {
				returnValue = ReflectionToStringBuilder.toString(result);
			} else {
				returnValue = result.toString();
			}
		}
		return returnValue;
	}

	private String getParams(JoinPoint joinPoint) {
		CodeSignature signature = (CodeSignature) joinPoint.getSignature();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < joinPoint.getArgs().length; i++) {
			String parameterName = signature.getParameterNames()[i];
			builder.append(parameterName);
			builder.append(": ");
			builder.append(joinPoint.getArgs()[i].toString());
			builder.append(", ");
		}
		return builder.toString();
	}

}
