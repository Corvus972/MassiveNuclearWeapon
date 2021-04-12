package nuclear_gun.nuclear_gun.repository;
import nuclear_gun.nuclear_gun.model.Types;
import nuclear_gun.nuclear_gun.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.io.Serializable;
import java.util.List;

public interface WeaponRepository extends JpaRepository<Weapon, Serializable> {

    @Query("from Weapon where name = :nameParam")
    public List<Weapon> findByName(@Param("nameParam") String name);

    @Query("from Weapon where efficiency > :efficiencyParam")
    public List<Weapon> findByEfficiencyGreaterThan(@Param("efficiencyParam") int efficiency);

    @Query("select m from Weapon w join w.manufacturer m  where m.deliveryType = :deliveryParam")
    public List<Weapon> findByDeliveryType(@Param("deliveryParam") String delivery);
}
