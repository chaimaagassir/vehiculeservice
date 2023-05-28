package ma.enset.vehiculeinfraction.mappers;

import ma.enset.vehiculeinfraction.dto.VehicleRequestDTO;
import ma.enset.vehiculeinfraction.dto.VehicleResponseDTO;
import ma.enset.vehiculeinfraction.entities.Vehicle;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class VehicleMapper {

    public Vehicle newVehicle(VehicleRequestDTO vehicleRequestDTO){
        Vehicle vehicle=new Vehicle();
        BeanUtils.copyProperties(vehicleRequestDTO,vehicle);
        vehicle.setId(UUID.randomUUID().toString());
        return vehicle;
    }
    public VehicleResponseDTO fromBankAccount(Vehicle vehicle){
        VehicleResponseDTO vehicleResponseDTO=new VehicleResponseDTO();
        BeanUtils.copyProperties(vehicle,vehicleResponseDTO);
        return vehicleResponseDTO;
    }

}
