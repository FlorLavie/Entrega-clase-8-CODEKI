package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.configuration.FlightConfiguration;
import codoacodo.vuelosapi.model.Dolar;
import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.model.FlightDto;
import codoacodo.vuelosapi.repository.FlightRepository;
import codoacodo.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {




    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightUtils flightUtils;

    @Autowired
    FlightConfiguration flightConfiguration;

    public List<FlightDto> findAll() {
        List<Flight> flightList = flightRepository.findAll();
        return flightList.stream()
                .map(flight -> flightUtils.flightMapper(flight,getDolar()))
                .collect(Collectors.toList());
    }

    public void createFlight(Flight flight) {
        flightRepository.save(flight);
    }

    public Flight findFlightId (Long id){
        return flightRepository.findById(id).orElse(new Flight());
    }

    public void deleteFlightId (Long id){

    }

    public Flight updateFlight(Flight flight){
        flightRepository.save(flight);
        return flightRepository.findById(flight.getId()).orElse(null);
    }

    public List<Flight> getOffers(int offerPrice) {
        List<Flight> flights = flightRepository.findAll();
        return flightUtils.detectOffers(flights,offerPrice);
    }

    private double getDolar() {
        Dolar dolar = flightUtils.fetchDolar();
        return dolar.getPromedio();
    }
}
