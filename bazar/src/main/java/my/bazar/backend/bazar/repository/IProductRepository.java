package my.bazar.backend.bazar.repository;

import my.bazar.backend.bazar.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
