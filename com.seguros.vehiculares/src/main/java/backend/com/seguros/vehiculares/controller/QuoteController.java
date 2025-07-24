package backend.com.seguros.vehiculares.controller;

import backend.com.seguros.vehiculares.model.QuoteRequest;
import backend.com.seguros.vehiculares.model.QuoteResponse;
import backend.com.seguros.vehiculares.serivice.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * QuoteController handles requests for vehicle insurance quotes.
 * It processes the QuoteRequest and returns a QuoteResponse with the calculated premium.
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/quotes")
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    /**
     * Processes a QuoteRequest and returns a QuoteResponse with the calculated insurance premium.
     *
     * @param request the QuoteRequest containing vehicle and driver details
     * @return a Mono containing the QuoteResponse with the calculated premium and adjustments
     */
    @PostMapping
    public Mono<QuoteResponse> quote(@RequestBody QuoteRequest request) {
        return quoteService.calculateQuote(request);
    }
}
