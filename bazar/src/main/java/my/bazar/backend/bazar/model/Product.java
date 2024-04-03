package my.bazar.backend.bazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public Product() {
    }

    public Product(Long product_id, String name, String brand, Double cost, Double stock) {
        this.product_id = product_id;
        this.name = name;
        this.brand = brand;
        this.cost = cost;
        this.stock = stock;
    }

    public void reduceStock(){
        this.stock--;
    }
}
