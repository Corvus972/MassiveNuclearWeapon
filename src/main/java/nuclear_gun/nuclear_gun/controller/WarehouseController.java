package nuclear_gun.nuclear_gun.controller;

import nuclear_gun.nuclear_gun.model.Types;
import nuclear_gun.nuclear_gun.model.Warehouse;

import nuclear_gun.nuclear_gun.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService service;

    @GetMapping("/all")
    public List<Warehouse> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createWeapon(@RequestBody Warehouse warehouse){
        service.create(warehouse);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean deleteWarehouse = service.delete(id);
        if(deleteWarehouse){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable("id") Long id, @RequestBody Warehouse warehouse) {
        return new ResponseEntity<>(service.edit(id, warehouse), HttpStatus.OK);
    }
    @GetMapping("{id}")
    public Warehouse findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

}
