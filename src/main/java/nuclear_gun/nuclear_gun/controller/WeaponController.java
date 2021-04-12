package nuclear_gun.nuclear_gun.controller;

import nuclear_gun.nuclear_gun.model.Types;
import nuclear_gun.nuclear_gun.model.Weapon;
import nuclear_gun.nuclear_gun.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weapons")
public class WeaponController {
    @Autowired
    private WeaponService service;

    @GetMapping("/all")
    public List<Weapon> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Weapon findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping("/delivery_type/{name}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Weapon> getByDeliveryType(@PathVariable("name") String name) {
        return service.findByDeliveryType(name);
    }

    @GetMapping("/gt/{efficiency}")
    public List<Weapon> greaterThan(@PathVariable("efficiency") Integer efficiency) {
        return service.findByEfficiencyGreaterThan(efficiency);
    }

    @PostMapping("/create")
    public Weapon createWeapon(@RequestBody Weapon weapon){
        return service.create(weapon);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean deleteWeapon = service.delete(id);
        if(deleteWeapon){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Weapon> updateCitation(@PathVariable("id") Long id, @RequestBody Weapon weapon) {
        return new ResponseEntity<>(service.edit(id, weapon), HttpStatus.OK);
    }
}
