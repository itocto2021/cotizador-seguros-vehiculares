package backend.com.seguros.vehiculares.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

/**
 * Vehicle represents a vehicle entity in the system.
 * It contains details such as brand, model, year, and an identifier.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    private Long id;
    private String brand;
    private String model;
    private int year;
}
