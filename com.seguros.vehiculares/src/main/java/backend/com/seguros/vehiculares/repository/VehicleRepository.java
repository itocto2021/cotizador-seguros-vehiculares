package backend.com.seguros.vehiculares.repository;

import backend.com.seguros.vehiculares.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * VehicleRepository is a Spring Data JPA repository for managing Vehicle entities.
 * It extends JpaRepository to provide CRUD operations and query methods for Vehicle entities.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
