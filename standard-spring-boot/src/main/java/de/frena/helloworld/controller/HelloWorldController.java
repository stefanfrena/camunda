package de.frena.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	public static final String HELLO = "/hello";

	/**
	 * 	http://localhost:8081/hello
	 */
	
	@ResponseBody
	@RequestMapping(value = HELLO, method = RequestMethod.GET)
	public String addSubstitute(
	) throws InterruptedException {
		return "hello spring boot";
	}
}
