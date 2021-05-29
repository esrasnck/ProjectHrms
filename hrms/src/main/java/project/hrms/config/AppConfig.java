package project.hrms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {   // service tool mantığı
	
	@Bean
	public ModelMapper modelMapper() {
			
		return new ModelMapper();
	}

}
