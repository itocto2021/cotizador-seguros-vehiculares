package backend.com.seguros.vehiculares.model;

import lombok.Data;

/**
 * QuoteRequest represents the request for a vehicle insurance quote.
 * It contains details about the vehicle and the driver.
 *
 * @author Ilder Tocto
 * @version 1.0
 * @since 22/07/2025
 */
@Data
public class QuoteRequest {
    private String brand;
    private String model;
    private int year;
    private String usageType; // personal, trabajo, carga
    private int driverAge;
}
