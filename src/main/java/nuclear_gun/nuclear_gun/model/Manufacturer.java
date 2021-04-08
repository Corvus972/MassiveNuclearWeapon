package nuclear_gun.nuclear_gun.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    private String reputation;
    @Enumerated(EnumType.ORDINAL)
    private DeliveryType deliveryType;

    public Manufacturer(String name, String reputation, DeliveryType deliveryType) {
        this.name = name;
        this.reputation = reputation;
        this.deliveryType = deliveryType;
    }

    public Manufacturer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getReputation() {
        return reputation;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReputation(String reputation) {
        this.reputation = reputation;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}

