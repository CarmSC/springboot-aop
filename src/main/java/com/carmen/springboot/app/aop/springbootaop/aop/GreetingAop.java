package com.carmen.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAop {

      private Logger logger = LoggerFactory.getLogger(this.getClass());

      @Before("execution(* com.carmen.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))") //punto de corte se aplica antes del metodo
      //@Before("execution(String com.carmen.springboot.app.aop.springbootaop.services.GreetingService.sayHello(..))") //punto de corte se aplica antes del metodo
      private void loggerBefore(JoinPoint joinPoint){

            String method = joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs()); //Convertir un array en string
            logger.info(" Antes: " + method + " con los argumentos  " + args);

      }

      @After("execution(* com.carmen.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
       private void loggerAfter(JoinPoint joinPoint){

            String method = joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs()); //Convertir un array en string
            logger.info(" Despues: " + method + " con los argumentos  " + args);

      }

}
