package de.frena.holidayreplacement;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class HolidayApplication {

	public static void main(String[] args) {

		final SpringApplication app = new SpringApplication(HolidayApplication.class);
		final String profilesParameter = System.getProperty("spring.profiles.active");
		if (StringUtils.isEmpty(profilesParameter)) {
			app.setAdditionalProfiles("local");
			System.setProperty("spring.profiles.active", "local");
		}
		app.run(args);
	}

	@EventListener
	public void notify(final PostDeployEvent event) {
		// userGenerator.createUsers();
	}

}
