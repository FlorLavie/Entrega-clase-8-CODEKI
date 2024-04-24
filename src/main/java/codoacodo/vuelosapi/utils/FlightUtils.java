package codoacodo.vuelosapi.utils;


import codoacodo.vuelosapi.model.Dolar;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.model.FlightDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightUtils {

    public List<Flight> detectOffers(List<Flight> flights,double offerPrice){
        return flights.stream()
                .filter(flight -> flight.getPrice()< offerPrice )
                .collect(Collectors.toList());
}
    public FlightDto flightMapper(Flight flight, double price){
        return new FlightDto(flight.getId(),flight.getOrigin(), flight.getDestiny(), flight.getDepartureTime(),
                flight.getArrivingTime(), flight.getPrice() * price, flight.getFrequency(), flight.getCompany());
    }
    public Dolar fetchDolar(){
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(apiUrl, Dolar.class);
    }
}