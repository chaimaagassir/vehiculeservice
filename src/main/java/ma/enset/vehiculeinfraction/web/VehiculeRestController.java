package ma.enset.vehiculeinfraction.web;

import ma.enset.vehiculeinfraction.entities.Vehicle;
import ma.enset.vehiculeinfraction.Repositories.VehicleRepository;
import ma.enset.vehiculeinfraction.dto.VehicleRequestDTO;
import ma.enset.vehiculeinfraction.dto.VehicleResponseDTO;
import ma.enset.vehiculeinfraction.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehiculeRestController {
    @Autowired
    private VehicleRepository vehiculeRepository;
    private VehicleService vehiculeService;
    public VehiculeRestController(VehicleRepository vehiculeRepository) {
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping("/vehicules")
    public List<Vehicle> vehiculeList(){
        return vehiculeRepository.findAll();
    }

    @GetMapping("/vehicules/{id}")
    public Vehicle vehicule(@PathVariable String id){
        return vehiculeRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Vehicule %s not found",id)));
    }
    @PostMapping("/vehicules")
    public VehicleResponseDTO save(@RequestBody VehicleRequestDTO requestDTO){
        return vehiculeService.addVehicle(requestDTO);
    }

    @PutMapping("/vehicules/{id}")
    public Vehicle update(@PathVariable String id, @RequestBody Vehicle vehicule){
        Vehicle vehicule1=vehiculeRepository.findById(id).orElseThrow();
        if (vehicule.getBrand()!=null) vehicule1.setBrand(vehicule.getBrand());
        if (vehicule.getType()!=null) vehicule1.setType(vehicule.getType());
        if (vehicule.getLicencePlateNumber()!=null) vehicule1.setLicencePlateNumber(vehicule.getLicencePlateNumber());
        if (vehicule.getModel()!=null) vehicule1.setModel(vehicule.getModel());
        return vehiculeRepository.save(vehicule1);
    }

    @DeleteMapping("/vehicules/{id}")
    public  void deleteVehicule(@PathVariable String id){
         vehiculeRepository.deleteById(id);
    }

}
