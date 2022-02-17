package com.example.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ChallengeApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ChallengeApplication.class, args);
	}


	/*@Bean
	CommandLineRunner commandLineRunner (DeviceService deviceService){
		return args -> {
			ObjectMapper mapper = new ObjectMapper();

			List<Device> deviceList = mapper.readValue(new File("src/main/resources/devices.json"), new TypeReference<List<Device>>() {});

			deviceService.saveAll(deviceList);

		};
	}*/
}
