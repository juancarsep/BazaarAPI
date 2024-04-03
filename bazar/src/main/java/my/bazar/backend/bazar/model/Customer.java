package my.bazar.backend.bazar.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long customer_id;
    private String name;
    private String lastname;
    private String dni;

    private Sale sale;

    public Customer() {
    }

    public Customer(Long customer_id, String name, String lastname, String dni) {
        this.customer_id = customer_id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
    }
}
