package project.hrms.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class AppConfig {   // service tool mantığı
	
	
	@Bean
	public ModelMapper modelMapper() {
			
		return new ModelMapper();
	}
	
	
	@Bean // instance oluşturuyor.
	public Cloudinary cloudinary() {
		
	return	new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "wissen",
				"api_key", "793285435792967",
				"api_secret", "fMrGwN65vZoTvCJJni0r7yGJ8sE"
				));
	}

}

