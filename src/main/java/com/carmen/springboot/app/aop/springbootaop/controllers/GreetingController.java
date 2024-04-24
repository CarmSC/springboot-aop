package com.carmen.springboot.app.aop.springbootaop.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class GreetingController {

      @GetMapping("/greeting")
      public ResponseEntity<?> greeting () {
          return ResponseEntity.ok(Collections.singletonMap("greeting", null));
      }
}
