package backend.com.seguros.vehiculares.controller;

import backend.com.seguros.vehiculares.dto.VehicleDto;
import backend.com.seguros.vehiculares.serivice.VehiclesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * VehicleController handles requests for vehicle data.
 * It retrieves a list of all vehicles available in the system.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    @Autowired
    private VehiclesServices vehiclesServices;

    /**
     * Retrieves all vehicles from the service.
     *
     * @return a Flux of VehicleDto containing the details of all vehicles
     */
    @GetMapping
    public Flux<VehicleDto> getBrands() {
        return vehiclesServices.getAllVehicles();
    }

}
