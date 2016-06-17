package de.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.helloworld.dto.HelloWorldDto;
import de.helloworld.service.Completer;
import de.helloworld.service.Starter;

@Controller
@RequestMapping(value = HelloWorldController.PATH)
public class HelloWorldController {

	public static final String PATH = "/helloWorld";
	public static final String JSON = "/postJson";
	public static final String GET = "/get";
	public static final String START = "/startProcess";
	public static final String COMPLETE = "/completeUserTask";

	@Autowired
	private Starter starter;

	@Autowired
	private Completer completer;

	@ResponseBody
	@RequestMapping(value = JSON, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String helloWorld(@RequestBody HelloWorldDto helloWorldDto) {

		return helloWorldDto.toString();
	}

	@ResponseBody
	@RequestMapping(value = START, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String startProcess(@RequestBody HelloWorldDto helloWorldDto) {

		String businessKey = starter.start(helloWorldDto);

		return "process started with business key " + businessKey;
	}

	@ResponseBody
	@RequestMapping(value = COMPLETE, method = RequestMethod.GET)
	public String completeUserTask(@RequestParam String taskDefKey, @RequestParam String businessKey) {
		completer.complete(taskDefKey, businessKey);

		return "task completed with business key " + businessKey;
	}

	@ResponseBody
	@RequestMapping(value = GET, method = RequestMethod.GET)
	public String getHelloWorld() {

		return "GET HELLO";
	}

	public HelloWorldController() {
	}
}
