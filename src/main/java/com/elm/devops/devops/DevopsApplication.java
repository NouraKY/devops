package com.elm.devops.devops;

import com.elm.devops.devops.config.ConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;

//@ConfigurationPropertiesScan("com.elm.devops.devops.config")
//@EnableConfigurationProperties(ConfigProperties.class)


@SpringBootApplication(scanBasePackages = "com.elm.devops.devops",
		exclude = {DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})

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


}
