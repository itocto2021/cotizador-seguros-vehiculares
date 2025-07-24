package backend.com.seguros.vehiculares.mapper;

import backend.com.seguros.vehiculares.dto.VehicleDto;
import backend.com.seguros.vehiculares.model.Vehicle;

/**
 * VehicleMapper is a utility class that converts Vehicle entities to VehicleDto objects.
 * It provides a static method to perform the conversion.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
public class VehicleMapper {

    /**
     * Converts a Vehicle entity to a VehicleDto object.
     *
     * @param vehicle the Vehicle entity to convert
     * @return a VehicleDto object containing the vehicle's data
     */
    public static VehicleDto toDto(Vehicle vehicle) {
        VehicleDto dto = new VehicleDto();
        dto.setId(vehicle.getId());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setYear(vehicle.getYear());
        return dto;
    }

}

