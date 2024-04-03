package my.bazar.backend.bazar.service;

import my.bazar.backend.bazar.model.Product;

import java.util.List;

public interface IProductService {
    public void saveProduct(Product prod);
    public Product getProductById(Long id);
    public List<Product> getAllProducts();
    public Product editProduct(Long product_id, String name, String brand, Double cost, Double stock);
    public void deleteProductById(Long id);

}
