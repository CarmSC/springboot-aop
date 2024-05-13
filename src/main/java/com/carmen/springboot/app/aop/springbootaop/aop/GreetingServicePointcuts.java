package com.carmen.springboot.app.aop.springbootaop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointcuts {

      @Pointcut("execution(* com.carmen.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
      private void greetingLoggerPointCut() {
      }

      @Pointcut("execution(* com.carmen.springboot.app.aop.springbootaop.services.GreetingService.*(..))")
      private void greetingOtherPointCut() {
      }

}
