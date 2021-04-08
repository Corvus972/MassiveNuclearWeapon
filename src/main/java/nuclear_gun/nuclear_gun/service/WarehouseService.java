package nuclear_gun.nuclear_gun.service;


import nuclear_gun.nuclear_gun.model.Warehouse;
import nuclear_gun.nuclear_gun.model.Weapon;
import nuclear_gun.nuclear_gun.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WarehouseService {
    @Autowired
    private WarehouseRepository repository;

    private final WeaponService weaponService;

    public WarehouseService(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    public List<Warehouse> findAll() {
        return repository.findAll();
    }

    public Warehouse findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Warehouse create(Warehouse warehouse) {
        warehouse.getWeapon()
                .addAll(warehouse
                        .getWeapon()
                        .stream()
                        .map(s -> {
                            Weapon weapon = weaponService.getOneById(s.getId());
                            weapon.getWarehouse().add(warehouse);
                            return weapon;
                        }).collect(Collectors.toList()));

        return repository.save(warehouse);
    }

    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Warehouse edit(Long id, Warehouse weapon){
        Optional<Warehouse> warehouseData = repository.findById(id);
        if (warehouseData.isPresent()) {
            Warehouse _warehouse = warehouseData.get();
            _warehouse.setCountry(weapon.getCountry());
            _warehouse.setLatitude(weapon.getLatitude());
            _warehouse.setLongitude(weapon.getLongitude());
            _warehouse.setQuantity(weapon.getQuantity());
            return repository.save(_warehouse);
        }
        return null;
    }
}
