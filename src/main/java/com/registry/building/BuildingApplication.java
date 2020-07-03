package com.registry.building;

import com.registry.building.repository.BuildingRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = BuildingRepository.class)
@EnableSwagger2
public class BuildingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuildingApplication.class, args);
	}


	@Bean
	public Docket swaggerConfiguration() {
		//Return a prepared Docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/buildings/*"))
				.apis(RequestHandlerSelectors.basePackage("com.registry."))
				.build();
	}
}
