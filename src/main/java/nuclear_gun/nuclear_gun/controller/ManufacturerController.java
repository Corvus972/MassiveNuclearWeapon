package nuclear_gun.nuclear_gun.controller;

import nuclear_gun.nuclear_gun.model.Manufacturer;
import nuclear_gun.nuclear_gun.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ManufacturerController {

    @Autowired
    private ManufacturerService service;

    @GetMapping("/manufacturers")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Manufacturer> findAll() {
        return service.findAll();
    }

    @GetMapping("/manufacturer/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Manufacturer findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/by_country/{country}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Manufacturer> findById(@PathVariable("country") String country) {
        return service.findByCountry(country);
    }

    @PostMapping("/manufacturer")
    @ResponseStatus(code = HttpStatus.OK)
    public Manufacturer createWeapon(@RequestBody Manufacturer manufacturer){
        return service.create(manufacturer);
    }


    @DeleteMapping("/manufacturer/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        service.delete(id);

    }

    @PutMapping("/manufacturer/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Manufacturer updateCitation(@PathVariable("id") Long id, @RequestBody Manufacturer manufacturer) {
        return service.edit(id, manufacturer);
    }
}
