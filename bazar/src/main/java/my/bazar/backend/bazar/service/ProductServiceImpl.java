package my.bazar.backend.bazar.service;

import my.bazar.backend.bazar.model.Product;
import my.bazar.backend.bazar.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepository productRepo;

    @Override
    public void saveProduct(Product prod) {
        productRepo.save(prod);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product editProduct(Long product_id, String name, String brand, Double cost, Double stock) {
        Product prod = this.getProductById(product_id);
        if(prod != null){
            prod.setName(name);
            prod.setBrand(brand);
            prod.setCost(cost);
            prod.setStock(stock);
            this.saveProduct(prod);
        }

        return prod;
    }

    @Override
    public void deleteProductById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> lackOfStock() {
        List<Product> allProducts = this.getAllProducts();
        List<Product> lackOfStockProducts = new ArrayList<>();
        final int MINIMUN_STOCK = 5;
        for(Product product : allProducts){
            if(product.getStock() < MINIMUN_STOCK){
                lackOfStockProducts.add(product);
            }
        }
        return lackOfStockProducts;
    }
}
