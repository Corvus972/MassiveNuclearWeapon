package nuclear_gun.nuclear_gun.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Weapon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer efficiency;

    @ManyToOne
    @JoinColumn(name ="manufacturer_id")
    private Manufacturer manufacturer;


    @ManyToOne
    @JoinColumn(name ="types_id")
    private Types types;

    @ManyToMany(mappedBy = "weapons", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Warehouse> wp = new HashSet<>();

    public Weapon(String name, Integer efficiency, Manufacturer manufacturer, Types types) {
        this.name = name;
        this.efficiency = efficiency;
        this.types = types;
        this.manufacturer = manufacturer;
    }

    public Weapon() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Types getTypes() {
        return types;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Set<Warehouse> getWarehouse() {
        return wp;
    }
    @JsonIgnore
    public void setWarehouse(Set<Warehouse> weapon) {
        this.wp = weapon;
    }
}