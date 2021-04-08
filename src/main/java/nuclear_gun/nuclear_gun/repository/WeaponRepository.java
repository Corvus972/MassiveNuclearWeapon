package nuclear_gun.nuclear_gun.repository;

import nuclear_gun.nuclear_gun.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {

}
