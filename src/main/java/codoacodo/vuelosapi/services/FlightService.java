package codoacodo.vuelosapi.services;

import codoacodo.vuelosapi.model.Flight;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    //creo lista
    private List<Flight> flightList = new ArrayList<>();

    //creo vuelos
    Flight flight1 = new Flight(1L,"puerto","cordoba","24-2024","25-2024",1000.3,"mensual");
    Flight flight2 = new Flight(2L,"puerto","cordoba","24-2024","25-2024",1000.3,"mensual");
    Flight flight3 = new Flight(3L,"puerto","cordoba","24-2024","25-2024",1000.3,"mensual");


    public Flight devolverVuelo(){
    return new Flight(1L,"puerto","cordoba","24-2024","25-2024",1000.3,"mensual");
}

    //agrego vuelos a la lista
    public void agregarVuelos(){
        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
    }

    //retorno todos los vuelos
    public List<Flight> traerTodosLosVuelos (){
        agregarVuelos();
        return flightList;

    }
    //no devuelve nada, crea un vuelo
    //necesito que el usuario me mande un vuelo opr parametro para guardarlo
    public void crearVuelo(){
        agregarVuelos();
        flightList.add(new Flight(4L,"puerto","cordoba","24-2024","25-2024",1000.3,"mensual"));

    }

    public void borrarVueloPorID(Long id) {
       Flight vueloABorrar = buscarVueloPorId(id);
        flightList.remove(vueloABorrar);

    }

    public Flight buscarVueloPorId(Long id) {
        agregarVuelos();

        for (int i=0; i<flightList.size(); i++ ){
            if(flightList.get(i).getId() == id){
                return flightList.get(i);
            }
        }
        return null;
    }
}