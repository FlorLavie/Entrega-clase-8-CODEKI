package codoacodo.vuelosapi.model;

import lombok.Data;

@Data
public class FlightDto {


    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivingTime;
    private double convertedPrice;
    private String frequency;


    public FlightDto(Long id, String origin, String destiny, String departureTime, String arrivingTime, double v, String frequency, Company company) {
    }
}
