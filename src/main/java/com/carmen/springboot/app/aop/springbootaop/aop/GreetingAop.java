package com.carmen.springboot.app.aop.springbootaop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

      @AfterReturning("execution(* com.carmen.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
      private void loggerAfterReturning(JoinPoint joinPoint){

           String method = joinPoint.getSignature().getName();
           String args = Arrays.toString(joinPoint.getArgs()); //Convertir un array en string
           logger.info(" Despues de retornar: " + method + " con los argumentos  " + args);

     }
     @AfterThrowing("execution(* com.carmen.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
     private void loggerAfterThrowing(JoinPoint joinPoint){

          String method = joinPoint.getSignature().getName();
          String args = Arrays.toString(joinPoint.getArgs()); //Convertir un array en string
          logger.info(" Despues de lanzar la excepcion : " + method + " con los argumentos  " + args);

      }

      @Around("execution(* com.carmen.springboot.app.aop.springbootaop.services.*.*(..))")
      public Object loggerAround(ProceedingJoinPoint  joinPoint) throws Throwable{
            String method = joinPoint.getSignature().getName();
            String args = Arrays.toString(joinPoint.getArgs());

            Object result = null;

            try {
                  logger.info("El metodo: " + method + "() con los parametros" + args);
                  result = joinPoint.proceed();
                  logger.info("El metodo: " + method + "() Retorna el resultado:" + result);
                  return result;
                  
            } catch (Throwable e) {
                  logger.error("Error en la llamada del metodo : " + method + "()");
                  throw e;
            }

            //return result;
      }


}
