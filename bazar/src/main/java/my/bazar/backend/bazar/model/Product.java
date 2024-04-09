package my.bazar.backend.bazar.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long product_id;
    private String name;
    private String brand;
    private Double cost;
    private Double stock;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;


    public Product() {
    }

    public Product(Long product_id, String name, String brand, Double cost, Double stock, Sale sale) {
        this.product_id = product_id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.stock = stock;
        this.sale = sale;

    }

    public void reduceStock(){
        this.stock--;
    }
}
