package backend.com.seguros.vehiculares.serivice.impl;

import backend.com.seguros.vehiculares.model.QuoteRequest;
import backend.com.seguros.vehiculares.model.QuoteResponse;
import backend.com.seguros.vehiculares.serivice.QuoteService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * QuoteServiceImpl is a service class that implements the QuoteService interface.
 * It provides methods to calculate insurance quotes based on various parameters.
 * The results are cached to improve performance.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    /**
     * Calculates the insurance quote based on the provided QuoteRequest.
     * The calculation considers the vehicle's year, usage type, driver age, and brand.
     * The result is cached to improve performance.
     *
     * @param request the QuoteRequest containing the parameters for the quote calculation
     * @return a Mono containing the QuoteResponse with the calculated quote details
     */
    @Override
    @Cacheable(value = "quotes", key = "#request.toString()", unless = "#result == null", cacheManager = "redisCacheManager")
    public Mono<QuoteResponse> calculateQuote(QuoteRequest request) {
        double base = 500;
        List<String> adjustments = new ArrayList<>();
        double total = base;

        if (request.getYear() > 2015) {
            adjustments.add("+15% por vehículo > 2015");
            total *= 1.15;
        }
        if ("carga".equalsIgnoreCase(request.getUsageType())) {
            adjustments.add("+10% por uso \"carga\"");
            total *= 1.10;
        }
        if (request.getDriverAge() > 50) {
            adjustments.add("-5% por conductor > 50 años");
            total *= 0.95;
        }
        if ("BMW".equalsIgnoreCase(request.getBrand())) {
            adjustments.add("+20% por marca BMW");
            total *= 1.20;
        } else if ("Audi".equalsIgnoreCase(request.getBrand())) {
            adjustments.add("+10% por marca Audi");
            total *= 1.10;
        }
        QuoteResponse result = new QuoteResponse();
        result.setBasePrice(base);
        result.setAdjustments(adjustments);
        result.setTotalPremium(Math.round(total * 100.0) / 100.0);
        return Mono.just(result);
    }
}
