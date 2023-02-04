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
	public ResponseEntity<String> getAppName() {

		String appName = "MyApp";
		log.info(appName + " 1234567890123456");
		log.error("This is ERROR log");
		log.debug("This is DEBUG log");
		log.warn("This is WARN log");
		return new ResponseEntity<String>(appName, HttpStatus.OK);
	}

}
