package backend.com.seguros.vehiculares.serivice.impl;

import backend.com.seguros.vehiculares.dto.VehicleDto;
import backend.com.seguros.vehiculares.model.Vehicle;
import backend.com.seguros.vehiculares.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * VehiclesServicesImplTest is a test class for the VehiclesServicesImpl service.
 * It tests the getAllVehicles method to ensure it correctly retrieves and maps vehicle data.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
class VehiclesServicesImplTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehiclesServicesImpl vehiclesServices;

    public VehiclesServicesImplTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test to ensure that getAllVehicles returns an empty Flux when no vehicles are found.
     */
    @Test
    void getAllVehicles_returnsMappedDtos() {
        Vehicle v1 = new Vehicle(1L, "Toyota", "Corolla", 2015);
        Vehicle v2 = new Vehicle(2L, "Honda", "Civic", 2018);
        List<Vehicle> vehicles = Arrays.asList(v1, v2);

        when(vehicleRepository.findAll()).thenReturn(vehicles);

        Flux<VehicleDto> resultFlux = vehiclesServices.getAllVehicles();
        List<VehicleDto> result = resultFlux.collectList().block();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Toyota", result.get(0).getBrand());
        assertEquals("Honda", result.get(1).getBrand());
    }
}