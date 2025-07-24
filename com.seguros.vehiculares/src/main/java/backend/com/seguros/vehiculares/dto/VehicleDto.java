package backend.com.seguros.vehiculares.dto;

import lombok.Data;

/**
 * VehicleDto is a Data Transfer Object (DTO) that represents a vehicle.
 * It contains fields for the vehicle's ID, brand, model, and year.
 * This class is used to transfer vehicle data between different layers of the application.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@Data
public class VehicleDto {
    private Long id;
    private String brand;
    private String model;
    private int year;
}