package nuclear_gun.nuclear_gun.service;

import nuclear_gun.nuclear_gun.model.Manufacturer;
import nuclear_gun.nuclear_gun.model.Types;
import nuclear_gun.nuclear_gun.model.Weapon;
import nuclear_gun.nuclear_gun.repository.ManufacturerRepository;
import nuclear_gun.nuclear_gun.repository.TypesRepository;
import nuclear_gun.nuclear_gun.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository repository;

    private ManufacturerRepository manuRepo;

    private TypesRepository typeRepo;

    public List<Weapon> findAll() {
        return repository.findAll();
    }

    public Weapon findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Weapon create(Weapon weapon) {
        return repository.save(weapon);
    }

    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Weapon edit(Long id, Weapon weapon){
        Optional<Weapon> weaponData = repository.findById(id);
        if (weaponData.isPresent()) {
           Weapon _weapon = weaponData.get();
           _weapon.setName(weapon.getName());
           _weapon.setEfficiency(weapon.getEfficiency());
            return repository.save(_weapon);
        }
        return null;
    }

}
