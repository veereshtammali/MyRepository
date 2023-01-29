package com.log4j.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
class HelloController {
	
	@GetMapping("/getAppName")
	public ResponseEntity<String>  getAppName() {
		
		String appName = "MyApp";
		log.info(appName);
		log.error("ERROR---");
		log.debug("DEBUG");
		log.warn("WARN");
		 return new ResponseEntity<String>(appName, HttpStatus.OK);
	}

}
