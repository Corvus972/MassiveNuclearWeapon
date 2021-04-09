package nuclear_gun.nuclear_gun.service;


import nuclear_gun.nuclear_gun.model.Manufacturer;
import nuclear_gun.nuclear_gun.model.Weapon;
import nuclear_gun.nuclear_gun.repository.ManufacturerRepository;
import nuclear_gun.nuclear_gun.repository.TypesRepository;
import nuclear_gun.nuclear_gun.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository repository;


    public List<Manufacturer> findAll() {
        return repository.findAll();
    }

    public Manufacturer findById(Long id) {
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Manufacturer not found"));
    }

    public List<Manufacturer> findByCountry(String country) {
        return repository.searchByCountry(country);
    }

    public Manufacturer getOneById(Long id) {
        return repository.getOne(id);
    }

    public Manufacturer create(Manufacturer manufacturer) {
        return repository.save(manufacturer);
    }

    public void delete(Long id) {
        Manufacturer _manufacturer = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Manufacturer " + id.toString() +" not found"));
        repository.delete(_manufacturer);

    }

    public Manufacturer edit(Long id, Manufacturer manufacturer){
        Manufacturer _manufacturer = repository.findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Manufacturer " + id.toString() +" not found"));
        _manufacturer.setName(manufacturer.getName() == null ? _manufacturer.getName() : manufacturer.getName());
        _manufacturer.setReputation(manufacturer.getReputation() == null ? _manufacturer.getReputation() : manufacturer.getReputation());
        _manufacturer.setDeliveryType(manufacturer.getDeliveryType() == null? _manufacturer.getDeliveryType() : manufacturer.getDeliveryType());
        return repository.save(_manufacturer);
    }
}
