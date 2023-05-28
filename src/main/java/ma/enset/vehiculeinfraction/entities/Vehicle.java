package ma.enset.vehiculeinfraction.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.vehiculeinfraction.enums.VehiculeType;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    private String id;
    private String licencePlateNumber;
    private String brand;
    private double fiscalPower;
    private String model;
    @ManyToOne
    private Owner owner;
    @Enumerated(EnumType.STRING)
    private VehiculeType type;



}
