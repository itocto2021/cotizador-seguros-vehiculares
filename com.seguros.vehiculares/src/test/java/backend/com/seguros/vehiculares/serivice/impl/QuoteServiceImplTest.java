package backend.com.seguros.vehiculares.serivice.impl;

import backend.com.seguros.vehiculares.model.QuoteRequest;
import backend.com.seguros.vehiculares.model.QuoteResponse;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * QuoteServiceImplTest is a test class for the QuoteServiceImpl.
 * It tests the calculateQuote method with various scenarios to ensure correct premium calculations.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
class QuoteServiceImplTest {

    /**
     * Tests the calculateQuote method for a vehicle with year 2015, usage type "particular", driver age 30, and brand "Toyota".
     * It verifies that the base price is 500, adjustments are applied correctly, and the total premium is calculated as expected.
     */
    @Test
    void calculateQuote_bmwCargaMayor2015Mayor50() {
        QuoteRequest request = mock(QuoteRequest.class);
        when(request.getYear()).thenReturn(2018);
        when(request.getUsageType()).thenReturn("carga");
        when(request.getDriverAge()).thenReturn(55);
        when(request.getBrand()).thenReturn("BMW");

        QuoteServiceImpl service = new QuoteServiceImpl();
        Mono<QuoteResponse> resultMono = service.calculateQuote(request);
        QuoteResponse result = resultMono.block();

        assertEquals(500, result.getBasePrice());
        assertTrue(result.getAdjustments().contains("+15% por vehículo > 2015"));
        assertTrue(result.getAdjustments().contains("+10% por uso \"carga\""));
        assertTrue(result.getAdjustments().contains("-5% por conductor > 50 años"));
        assertTrue(result.getAdjustments().contains("+20% por marca BMW"));
        assertEquals(721.05, result.getTotalPremium());
    }

    /**
     * Tests the calculateQuote method for a vehicle with year 2010, usage type "particular", driver age 30, and brand "Audi".
     * It verifies that the base price is 500, adjustments are applied correctly, and the total premium is calculated as expected.
     */
    @Test
    void calculateQuote_audiParticularMenor2015Menor50() {
        QuoteRequest request = mock(QuoteRequest.class);
        when(request.getYear()).thenReturn(2010);
        when(request.getUsageType()).thenReturn("particular");
        when(request.getDriverAge()).thenReturn(30);
        when(request.getBrand()).thenReturn("Audi");

        QuoteServiceImpl service = new QuoteServiceImpl();
        Mono<QuoteResponse> resultMono = service.calculateQuote(request);
        QuoteResponse result = resultMono.block();

        assertEquals(500, result.getBasePrice());
        assertTrue(result.getAdjustments().contains("+10% por marca Audi"));
        assertEquals(550.0, result.getTotalPremium());
    }

    /**
     * Tests the calculateQuote method for a vehicle with year 2010, usage type "particular", driver age 30, and brand "Toyota".
     * It verifies that the base price is 500, no adjustments are applied, and the total premium is calculated as expected.
     */
    @Test
    void calculateQuote_sinAjustes() {
        QuoteRequest request = mock(QuoteRequest.class);
        when(request.getYear()).thenReturn(2010);
        when(request.getUsageType()).thenReturn("particular");
        when(request.getDriverAge()).thenReturn(30);
        when(request.getBrand()).thenReturn("Toyota");

        QuoteServiceImpl service = new QuoteServiceImpl();
        Mono<QuoteResponse> resultMono = service.calculateQuote(request);
        QuoteResponse result = resultMono.block();

        assertEquals(500, result.getBasePrice());
        assertTrue(result.getAdjustments().isEmpty());
        assertEquals(500.0, result.getTotalPremium());
    }
}