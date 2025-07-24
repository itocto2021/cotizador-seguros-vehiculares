package backend.com.seguros.vehiculares.serivice;

import backend.com.seguros.vehiculares.dto.VehicleDto;
import reactor.core.publisher.Flux;
/**
 * VehiclesServices is an interface that defines the contract for vehicle-related services.
 * It provides methods to retrieve vehicle data.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
public interface VehiclesServices {

    /**
     * Retrieves all vehicles as a Flux of VehicleDto.
     *
     * @return a Flux containing all VehicleDto objects
     */
    Flux<VehicleDto> getAllVehicles();
}
