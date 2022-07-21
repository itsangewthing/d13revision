package sg.edu.nus.iss.d13revision;


import java.util.Collections;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class D13revisionApplication {

	public static void main(String[] args) {
		// SpringApplication.run(D13revisionApplication.class, args);
		SpringApplication app = new SpringApplication(D13revisionApplication.class);

		String port = "8085";
		ApplicationArguments cli0pts = new DefaultApplicationArguments(args);
		
		if (cli0pts.containsOption("port")){
			port = cli0pts.getOptionValues("port").get(0);
		}
		
		app.setDefaultProperties(
			Collections.singletonMap("server.port", port));

			app.run(args);
	}

	@Bean
	public CommonsRequestLoggingFilter log(){
		CommonsRequestLoggingFilter logger = new CommonsRequestLoggingFilter();
		//to track debugging issues
		logger.setIncludeClientInfo(true);
		logger.setIncludeQueryString(true);
		return logger;

	}

}
