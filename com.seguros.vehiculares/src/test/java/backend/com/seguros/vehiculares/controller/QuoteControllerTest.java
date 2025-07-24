package backend.com.seguros.vehiculares.controller;

import backend.com.seguros.vehiculares.model.QuoteRequest;
import backend.com.seguros.vehiculares.model.QuoteResponse;
import backend.com.seguros.vehiculares.serivice.QuoteService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * QuoteControllerTest is a test class for the QuoteController.
 * It tests the quote method to ensure it returns the expected QuoteResponse.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
class QuoteControllerTest {

    @Mock
    private QuoteService quoteService;

    @InjectMocks
    private QuoteController quoteController;

    public QuoteControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the quote method of QuoteController.
     * It verifies that the method returns a QuoteResponse when a valid QuoteRequest is provided.
     */
    @Test
    void quote_returnsQuoteResponse() {
        QuoteRequest request = new QuoteRequest();
        QuoteResponse response = new QuoteResponse();
        when(quoteService.calculateQuote(request)).thenReturn(Mono.just(response));

        Mono<QuoteResponse> resultMono = quoteController.quote(request);
        QuoteResponse result = resultMono.block();

        assertNotNull(result);
        assertEquals(response, result);
        verify(quoteService, times(1)).calculateQuote(request);
    }
}