package codoacodo.vuelosapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Flight {
    @Getter
    @Id
    private Long id;
    private String origin;
    private String destiny;
    private String departureTime;
    private String arrivingTime;
    private Double price;
    private String frequency;


    private Company company;


    public Flight(String origin, String destiny, String departureTime, String arrivingTime, Double price, String frequency) {
        this.origin = origin;
        this.destiny = destiny;
        this.departureTime = departureTime;
        this.arrivingTime = arrivingTime;
        this.price = price;
        this.frequency = frequency;
    }
}
