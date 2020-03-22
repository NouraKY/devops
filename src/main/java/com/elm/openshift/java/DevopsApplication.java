package com.elm.openshift.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

//@ConfigurationPropertiesScan("com.elm.devops.devops.config")
//@EnableConfigurationProperties(ConfigProperties.class)
@SpringBootApplication(scanBasePackages = "com.elm.openshift.java",
		exclude = {/*DataSourceAutoConfiguration.class,*//* XADataSourceAutoConfiguration.class*/})

public class DevopsApplication {
	private static final Logger log = LoggerFactory.getLogger(DevopsApplication.class);

	private final Environment env;

	public DevopsApplication(Environment env) {
		this.env = env;
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DevopsApplication.class);
	//	SpringApplication.run(DevopsApplication.class, args);
		Environment env = app.run(args).getEnvironment();
		logApplicationStartup(env);
	}

	private static void logApplicationStartup(Environment env) {
		String protocol = "http";

		String hostAddress = "localhost";
		try {
			hostAddress = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.warn("The host name could not be determined, using `localhost` as fallback");
		}
		log.info("application running on port :{}" , env.getProperty("application.port"));


	}
/*
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		return sessionFactory;
	}
*/

/*	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		return sessionFactory;
	}*/



}
