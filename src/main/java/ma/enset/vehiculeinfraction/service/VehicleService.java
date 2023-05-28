package ma.enset.vehiculeinfraction.service;

import ma.enset.vehiculeinfraction.dto.VehicleRequestDTO;
import ma.enset.vehiculeinfraction.dto.VehicleResponseDTO;

public interface VehicleService {

     VehicleResponseDTO addVehicle(VehicleRequestDTO vehicleRequestDTO );


     VehicleResponseDTO update(String id, VehicleRequestDTO vehicleRequestDTO);
}
