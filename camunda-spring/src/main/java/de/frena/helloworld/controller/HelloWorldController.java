package de.frena.helloworld.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.frena.helloworld.dto.HelloWorldDto;
import de.frena.helloworld.main.Starter;

@Controller
@RequestMapping(value = HelloWorldController.PATH)
public class HelloWorldController {

  public static final String PATH = "/helloWorld";
  public static final String JSON = "/postJson";
  public static final String GET = "/get";
  public static final String START = "/startProcess";


  @Autowired
  private Starter starter;

  @ResponseBody
  @RequestMapping(value = JSON, method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public String helloWorld(@RequestBody HelloWorldDto helloWorldDto) {

    return helloWorldDto.toString();
  }

  @ResponseBody
  @RequestMapping(value = START, method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  public String startProcess(@RequestBody HelloWorldDto helloWorldDto) {
    starter.start(helloWorldDto.getName());

    return "process started";
  }

  @ResponseBody
  @RequestMapping(value = GET, method = RequestMethod.GET)
  public String getHelloWorld() {

    return "GET HELLO";
  }

  public HelloWorldController() {}
}
