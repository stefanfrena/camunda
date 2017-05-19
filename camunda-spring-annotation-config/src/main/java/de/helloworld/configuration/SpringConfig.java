package de.helloworld.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {SpringConfig.BASE_PACKAGE})
public class SpringConfig {

  public static final String BASE_PACKAGE = "de.helloworld";

}
