package com.rithik.genai_knowledge_assistant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GenaiKnowledgeAssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenaiKnowledgeAssistantApplication.class, args);
	}

	@Bean
	CommandLineRunner run(GeminiService service) {
		return args -> System.out.println(service.ask("Say hello in one short line"));
	}
}