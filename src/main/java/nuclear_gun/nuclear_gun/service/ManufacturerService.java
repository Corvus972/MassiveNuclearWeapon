package nuclear_gun.nuclear_gun.service;


import nuclear_gun.nuclear_gun.model.Manufacturer;
import nuclear_gun.nuclear_gun.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    @Autowired
    private ManufacturerRepository repository;

    public List<Manufacturer> findAll() {
        return repository.findAll();
    }
    public Manufacturer findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Manufacturer create(Manufacturer manufacturer) {
        return repository.save(manufacturer);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
