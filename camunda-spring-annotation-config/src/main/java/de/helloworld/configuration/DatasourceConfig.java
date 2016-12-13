package de.helloworld.configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatasourceConfig {
	/**
	 * Add jdbc connector to lib folder of tomcat. 
	 * not war.
	 * 
	 */
	private static final Logger LOG = LoggerFactory.getLogger(DatasourceConfig.class);

	@Value("${application.database.driver}")
	private String databaseDriver;

	@Value("${application.database.url}")
	private String databaseURL;

	@Value("${application.database.user}")
	private String databaseUser;

	@Value("${application.database.password}")
	private String databasePassword;

	@Bean(name = { "applicationDataSource", "dataSource" })
	public javax.sql.DataSource applicationDataSource() {
		System.out.println("initializing datasource " + databaseURL);
		
		DataSource dataSource = new DataSource();
		dataSource.setMaxActive(10);
		dataSource.setMaxIdle(3);
		dataSource.setMinIdle(1);
		dataSource.setInitialSize(1);
		dataSource.setMinEvictableIdleTimeMillis(10000);
		dataSource.setUrl(databaseURL);
		dataSource.setUsername(databaseUser);
		dataSource.setPassword(databasePassword);
		dataSource.setDriverClassName(databaseDriver);

		dataSource.setValidationQuery("select 1 from dual");
		dataSource.setValidationInterval(30000);
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);

		LOG.info("database connection setting: {}", dataSource.toString());
		
		return dataSource;

	}

}
