package backend.com.seguros.vehiculares.config;

import backend.com.seguros.vehiculares.model.Vehicle;
import backend.com.seguros.vehiculares.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * DataInitializer is a configuration class that initializes the database with sample vehicle data.
 * It implements CommandLineRunner to execute code after the application context is loaded.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@Configuration
public class DataInitializer {

    /**
     * Initializes the database with sample vehicle data.
     * This method is executed after the application context is loaded.
     *
     * @param repository the VehicleRepository to save the sample vehicles
     * @return a CommandLineRunner that saves sample vehicles to the database
     */
    @Bean
    CommandLineRunner initDatabase(VehicleRepository repository) {
        return args -> {
            repository.save(new Vehicle(1L, "Toyota", "Corolla", 2020));
            repository.save(new Vehicle(2L, "Honda", "Civic", 2019));
            repository.save(new Vehicle(3L, "Ford", "Focus", 2018));
            repository.save(new Vehicle(4L, "Chevrolet", "Cruze", 2021));
            repository.save(new Vehicle(5L, "Nissan", "Sentra", 2022));
            repository.save(new Vehicle(6L, "Audi", "A4", 2021));
            repository.save(new Vehicle(7L, "BMW", "320i", 2022));
        };
    }
}