package nuclear_gun.nuclear_gun.repository;

import nuclear_gun.nuclear_gun.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
