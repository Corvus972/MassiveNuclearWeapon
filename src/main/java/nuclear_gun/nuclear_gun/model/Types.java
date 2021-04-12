package nuclear_gun.nuclear_gun.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;

    public Types() { }
    public Types(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}