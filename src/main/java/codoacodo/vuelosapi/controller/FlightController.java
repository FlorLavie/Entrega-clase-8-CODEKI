package codoacodo.vuelosapi.controller;

import codoacodo.vuelosapi.model.Flight;
import codoacodo.vuelosapi.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
public class FlightController {
    @Autowired
    FlightService flightService;
    @GetMapping
    public Flight getFlight (){
        return flightService.devolverVuelo();
    }

    @GetMapping("/todos")
    public List<Flight> getAllFlights () {
        return flightService.traerTodosLosVuelos();
    }

    //no devuelve nada
    @PostMapping("/agregar")
    public void createFlight(){
        flightService.crearVuelo();
    }

    @GetMapping("/id")
    public Flight findFlightById(){
        Long id = 1L;
        Flight vueloEncontrado = flightService.buscarVueloPorId(id);
        return vueloEncontrado;
    }

    @DeleteMapping("/eliminar")
    public void deleteFlight(){
        long id = 1L;
        flightService.borrarVueloPorID(id);
    }


}
