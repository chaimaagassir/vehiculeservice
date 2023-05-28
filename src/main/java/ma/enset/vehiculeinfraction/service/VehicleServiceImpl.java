package ma.enset.vehiculeinfraction.service;

import ma.enset.vehiculeinfraction.entities.Vehicle;
import ma.enset.vehiculeinfraction.Repositories.VehicleRepository;
import ma.enset.vehiculeinfraction.dto.VehicleRequestDTO;
import ma.enset.vehiculeinfraction.dto.VehicleResponseDTO;
import ma.enset.vehiculeinfraction.mappers.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service @Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleMapper vehicleMapper;
    @Override
    public VehicleResponseDTO addVehicle(VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle= vehicleMapper.newVehicle(vehicleRequestDTO);
        Vehicle saveVehicle=vehicleRepository.save(vehicle);
        VehicleResponseDTO vehicleResponseDTO= vehicleMapper.fromBankAccount(saveVehicle);
        return vehicleResponseDTO;
    }

    @Override
    public VehicleResponseDTO update(String id, VehicleRequestDTO vehicleRequestDTO) {
        Vehicle vehicle= vehicleMapper.newVehicle(vehicleRequestDTO);
        vehicle.setId(id);
        Vehicle saveVehicle=vehicleRepository.save(vehicle);
        VehicleResponseDTO vehicleResponseDTO= vehicleMapper.fromBankAccount(saveVehicle);
        return vehicleResponseDTO;
    }
}
