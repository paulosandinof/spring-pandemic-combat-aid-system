package com.sandino.pandemiccombataidsystem;

import com.sandino.pandemiccombataidsystem.repositories.ResourceTypeRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PandemicCombatAidSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PandemicCombatAidSystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ResourceTypeRepository resourceTypeRepository) {
		return args -> {

			// ResourceType resource1 = new ResourceType("0ca7f082-1eee-48d1-aa11-8594156468e1", "Médico", 3);
			// ResourceType resource2 = new ResourceType("30ee7abf-0106-4f32-8cc2-550b94bc99f9", "Enfermeiro", 3);
			// ResourceType resource3 = new ResourceType("61543f47-75a9-4e39-8d04-fa35b75835cf", "Respirador", 5);
			// ResourceType resource4 = new ResourceType("f67abdb2-e291-4b79-99f3-3d191cac5fc1", "Tomógrafo", 12);
			// ResourceType resource5 = new ResourceType("0a0a6603-c83b-45a4-9d38-3cff1a9bff5e", "Ambulância", 10);

			// resourceTypeRepository.save(resource1);
			// resourceTypeRepository.save(resource2);
			// resourceTypeRepository.save(resource3);
			// resourceTypeRepository.save(resource4);
			// resourceTypeRepository.save(resource5);
		};
	}
}
