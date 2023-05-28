package ma.enset.vehiculeinfraction.web;

import ma.enset.vehiculeinfraction.entities.Vehicle;
import ma.enset.vehiculeinfraction.Repositories.VehicleRepository;
import ma.enset.vehiculeinfraction.dto.VehicleRequestDTO;
import ma.enset.vehiculeinfraction.dto.VehicleResponseDTO;
import ma.enset.vehiculeinfraction.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VehiculeGraphQlController {
    @Autowired
    private VehicleRepository vehiculeRepository;
    private VehicleService vehiculeService;
    @Autowired

    @QueryMapping
    public List<Vehicle> vehiculesList(){

        return vehiculeRepository.findAll();
    }

    @QueryMapping
    public Vehicle vehiculeById(@Argument String id){

        return vehiculeRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Vehicule %s not found",id)));
    }
    @MutationMapping
    public VehicleResponseDTO addVehicule(@Argument VehicleRequestDTO vehicule){
        return vehiculeService.addVehicle(vehicule);
    }
    @MutationMapping
    public VehicleResponseDTO updateVehicule(@Argument String id, @Argument VehicleRequestDTO vehicule){
        return vehiculeService.update(id,vehicule);
    }
    @MutationMapping
    public void deleteVehicule(@Argument String id){
        vehiculeRepository.deleteById(id);

    }
}

