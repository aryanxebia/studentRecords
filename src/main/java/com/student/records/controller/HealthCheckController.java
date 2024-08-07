package com.student.records.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HealthCheckController {
	
	@GetMapping("health-check")
	ResponseEntity<String> healthCheck(){
		return ResponseEntity.status(HttpStatus.OK).body("Student Records microservice controller working");
	}
}
