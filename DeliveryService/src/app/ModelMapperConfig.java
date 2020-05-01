package app;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//<dependency>
//	<groupId>org.modelmapper</groupId>
//	<artifactId>modelmapper</artifactId>
//	<version>2.3.5</version>
//</dependency>

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
