package org.supemir.tp3.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@RequiredArgsConstructor
@Configuration
public class CustomerConfig {
    private final CustomerRepository customerRepository;

    @Bean
    CommandLineRunner init_customer(){
        return args -> {
          customerRepository.save(
                  new Customer(
                          null,
                          "chebihi",
                          "f.chebihi@gmail.com")
          );
          
        };
    }

}
