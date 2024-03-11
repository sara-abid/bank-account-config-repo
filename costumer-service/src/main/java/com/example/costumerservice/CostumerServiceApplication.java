package com.example.costumerservice;

import com.example.costumerservice.config.GlobalConfig;
import com.example.costumerservice.entities.Customer;
import com.example.costumerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class  CostumerServiceApplication {
	public void main(String[] args) {
		SpringApplication.run(CostumerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			List<Customer> customerList = List.of(
					Customer.builder()
							.firstName("AA")
							.lastName("BB")
							.email("aa@gmail.com")
							.build(),
					Customer.builder()
							.firstName("CC")
							.lastName("DD")
							.email("cc@gmail.com")
							.build()
			);
			customerRepository.saveAll(customerList);
		};
	}
}



