package nuclear_gun.nuclear_gun.repository;

import nuclear_gun.nuclear_gun.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface WarehouseRepository extends JpaRepository<Warehouse, Serializable> {
}
