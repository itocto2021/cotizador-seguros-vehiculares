package backend.com.seguros.vehiculares.controller;

import backend.com.seguros.vehiculares.dto.VehicleDto;
import backend.com.seguros.vehiculares.serivice.VehiclesServices;
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
 * VehicleControllerTest is a test class for the VehicleController.
 * It tests the getBrands method to ensure it returns the expected list of VehicleDto.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
class VehicleControllerTest {

    @Mock
    private VehiclesServices vehiclesServices;

    @InjectMocks
    private VehicleController vehicleController;

    public VehicleControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the getBrands method of VehicleController.
     * It verifies that the method returns a Flux of VehicleDto containing the expected brands.
     */
    @Test
    void getBrands_returnsVehicleDtos() {
        VehicleDto dto1 = new VehicleDto();
        dto1.setBrand("Toyota");
        VehicleDto dto2 = new VehicleDto();
        dto2.setBrand("Honda");
        List<VehicleDto> dtos = Arrays.asList(dto1, dto2);

        when(vehiclesServices.getAllVehicles()).thenReturn(Flux.fromIterable(dtos));

        Flux<VehicleDto> resultFlux = vehicleController.getBrands();
        List<VehicleDto> result = resultFlux.collectList().block();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Toyota", result.get(0).getBrand());
        assertEquals("Honda", result.get(1).getBrand());
        verify(vehiclesServices, times(1)).getAllVehicles();
    }
}