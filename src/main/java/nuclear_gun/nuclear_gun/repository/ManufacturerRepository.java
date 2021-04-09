package nuclear_gun.nuclear_gun.repository;

import nuclear_gun.nuclear_gun.model.DeliveryType;
import nuclear_gun.nuclear_gun.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {

//    @Query("select m from Weapon w join w.manufacturer m join w.warehouse ww where ww.country = :countryParam")
    @Query("from Weapon")
    public List<Manufacturer> findByCountry(@Param("countryParam") String country);

}
