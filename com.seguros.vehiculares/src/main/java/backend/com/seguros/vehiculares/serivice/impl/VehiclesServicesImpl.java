package backend.com.seguros.vehiculares.serivice.impl;

import backend.com.seguros.vehiculares.dto.VehicleDto;
import backend.com.seguros.vehiculares.mapper.VehicleMapper;
import backend.com.seguros.vehiculares.repository.VehicleRepository;
import backend.com.seguros.vehiculares.serivice.VehiclesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

/**
 * VehiclesServicesImpl is a service implementation that provides methods to manage vehicle data.
 * It uses VehicleRepository to interact with the database and VehicleMapper to convert between
 * Vehicle entities and VehicleDto objects.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@Service
public class VehiclesServicesImpl implements VehiclesServices {

    @Autowired
    private VehicleRepository vehicleRepository;

    /**
     * Retrieves all vehicles from the repository, converts them to DTOs, and returns them as a Flux.
     * The results are distinct to avoid duplicates.
     *
     * @return a Flux of VehicleDto containing all distinct vehicles
     */
    @Override
    @Cacheable(value = "vehicles", key = "'allVehicles'", unless = "#result == null", cacheManager = "redisCacheManager")
    public Flux<VehicleDto> getAllVehicles() {
        return Flux.fromIterable(vehicleRepository.findAll())
                .map(VehicleMapper::toDto)
                .distinct();
    }
}
