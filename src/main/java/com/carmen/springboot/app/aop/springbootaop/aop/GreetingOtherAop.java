package com.carmen.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingOtherAop {

      private Logger logger = LoggerFactory.getLogger(this.getClass());

      @Before("GreetingServicePointcuts.greetingOtherPointCut()")

      private void loggerBefore(JoinPoint joinPoint) {

            String method = joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs());
            logger.info(" Antes  GreetingOtherAop: " + method + " invocado con los parametros  " + args);

      }

      @After("GreetingServicePointcuts.greetingOtherPointCut()")
      private void loggerAfter(JoinPoint joinPoint) {

            String method = joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs());
            logger.info(" Despues GreetingOtherAop: " + method + " con los parametros  " + args);

      }

}
