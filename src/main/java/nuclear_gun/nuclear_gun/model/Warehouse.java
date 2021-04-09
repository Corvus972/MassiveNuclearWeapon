package nuclear_gun.nuclear_gun.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private double latitude;

    private double longitude;
    private int quantity;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "stock",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "weapon_id"))

    private Set<Weapon> weapons = new HashSet<>();

    public Warehouse(Long id, String country, double latitude, double longitude, int quantity) {
        this.id = id;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.quantity = quantity;
    }

    public Warehouse() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Weapon> getWeapon() {
        return weapons;
    }

    public void setWeapon(Set<Weapon> weapon) {
        this.weapons = weapon;
    }
}