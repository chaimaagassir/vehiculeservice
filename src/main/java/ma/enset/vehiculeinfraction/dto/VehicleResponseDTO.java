package ma.enset.vehiculeinfraction.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.vehiculeinfraction.enums.VehiculeType;

@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class VehicleResponseDTO {
    private String id;
    private String licencePlateNumber;
    private String brand;
    private int fiscalPower;
    private String model;
    private VehiculeType type;
}
