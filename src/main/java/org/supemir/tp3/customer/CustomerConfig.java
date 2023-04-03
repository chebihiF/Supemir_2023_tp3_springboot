package org.supemir.tp3.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@Configuration
public class CustomerConfig {
    private final CustomerRepository customerRepository;

    @Bean
    CommandLineRunner init_customer(){
        return args -> {
            Random random = new Random();
            List<String> names = List.of("ahmed","manal","mohamed","sanaa","ahmado","mamado","ali","khadija","salim");
            for(int i=0;i<100;i++){
                int index = random.nextInt(names.size());
                customerRepository.save(
                        new Customer(0L,
                                names.get(index),
                                names.get(index)+"@gmail.com")
                );
            }
        };
    }

}
