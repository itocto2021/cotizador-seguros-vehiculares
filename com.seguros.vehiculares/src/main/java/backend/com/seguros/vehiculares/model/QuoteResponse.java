package backend.com.seguros.vehiculares.model;

import lombok.Data;

import java.util.List;

/**
 * QuoteResponse represents the response for a vehicle insurance quote.
 * It contains the base price, adjustments applied, and the total premium.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@Data
public class QuoteResponse {
    private double basePrice;
    private List<String> adjustments;
    private double totalPremium;
}
