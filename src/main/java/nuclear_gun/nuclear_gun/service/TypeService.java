package nuclear_gun.nuclear_gun.service;


import nuclear_gun.nuclear_gun.model.Types;
import nuclear_gun.nuclear_gun.repository.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {
    @Autowired
    private TypesRepository repository;

    public List<Types> findAll() {
        return repository.findAll();
    }

    public Types findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Types create(Types type) {
        return repository.save(type);
    }

    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Types edit(Long id, Types types){
        Optional<Types> typesData = repository.findById(id);
        if (typesData.isPresent()) {
            Types _type = typesData.get();
            _type.setLabel(types.getLabel());
            return repository.save(_type);
        }
        return null;
    }
}
