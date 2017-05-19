package de.helloworld.configuration;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// import de.sixt.core.configuration.database.entityManager.AbstractEntityManagerFactory;

@Configuration
public class FlyWayEntityManagerFactory {

	@Value("${application.database.driver}")
	private String databaseDriver;

	@Value("${application.database.url}")
	private String databaseURL;

	@Value("${application.database.user}")
	private String databaseUser;

	@Value("${application.database.password}")
	private String databasePassword;

	@Bean
	public Flyway flyway() throws SQLException {
		Flyway flyway = new Flyway();

		try {

			 flyway.setDataSource(databaseURL, databaseUser, databasePassword);
//			  flyway.clean();
			 flyway.migrate();
		} catch (Exception e) {
			System.out.println("flyway failed");
			e.printStackTrace();
		}
		return flyway;
	}

}
