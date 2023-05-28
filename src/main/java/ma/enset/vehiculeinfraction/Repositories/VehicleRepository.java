package ma.enset.vehiculeinfraction.Repositories;

import ma.enset.vehiculeinfraction.entities.Vehicle;
import ma.enset.vehiculeinfraction.enums.VehiculeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface VehicleRepository extends JpaRepository<Vehicle,String> {

}
