package my.bazar.backend.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Sale {

    private Long sale_id;
    private LocalDate sale_date;
    private Double total;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<Product> productsList;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Sale() {
    }

    public Sale(Long sale_id, LocalDate sale_date, Double total, List<Product> productsList) {
        this.sale_id = sale_id;
        this.sale_date = sale_date;
        this.total = total;
        this.productsList = productsList;
    }
}
