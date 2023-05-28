package ma.enset.vehiculeinfraction.Repositories;

import ma.enset.vehiculeinfraction.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,String> {

}
