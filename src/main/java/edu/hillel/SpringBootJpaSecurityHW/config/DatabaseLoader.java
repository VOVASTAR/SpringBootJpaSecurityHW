package edu.hillel.SpringBootJpaSecurityHW.config;

import com.github.javafaker.Faker;
import edu.hillel.SpringBootJpaSecurityHW.entity.Product;
import edu.hillel.SpringBootJpaSecurityHW.repo.ProductRepositoryJpa;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseLoader {
    @Bean
    CommandLineRunner initDatabase(ProductRepositoryJpa productRepositoryJpa) {
        return args -> {
//            Faker faker = new Faker();
//            for (int i = 1; i <= 20; i++) {
//                Product product = Product.builder()
//                        .name(faker.food().fruit())
//                        .cost(Math.round(Math.random() * 10000.0) / 100.0)
//                        .build();
//                productRepositoryJpa.save(product);
//            }
        };
    }
}
