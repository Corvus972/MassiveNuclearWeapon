package nuclear_gun.nuclear_gun.controller;


import nuclear_gun.nuclear_gun.model.Types;
import nuclear_gun.nuclear_gun.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {
    @Autowired
    private TypeService service;

    @GetMapping("/all")
    public List<Types> findAll() {
        return service.findAll();
    }

    @PostMapping("/create")
    public Types createWeapon(@RequestBody Types types){
        return service.create(types);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Types> updateCitation(@PathVariable("id") Long id, @RequestBody Types types) {
        return new ResponseEntity<>(service.edit(id, types), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        boolean deleteTypes = service.delete(id);
        if(deleteTypes){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("{id}")
    public Types findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }
}
