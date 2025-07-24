package backend.com.seguros.vehiculares.serivice;

import backend.com.seguros.vehiculares.model.QuoteRequest;
import backend.com.seguros.vehiculares.model.QuoteResponse;
import reactor.core.publisher.Mono;

/**
 * QuoteService is an interface that defines the contract for calculating insurance quotes.
 * It provides a method to calculate a quote based on a QuoteRequest object.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
public interface QuoteService {

    /**
     * Calculates an insurance quote based on the provided QuoteRequest.
     *
     * @param request the QuoteRequest containing details for the quote calculation
     * @return a Mono containing the QuoteResponse with the calculated quote details
     */
    public Mono<QuoteResponse> calculateQuote(QuoteRequest request);
}
