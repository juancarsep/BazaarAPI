package my.bazar.backend.bazar.controller;

import my.bazar.backend.bazar.model.Product;
import my.bazar.backend.bazar.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    IProductService prodService;

    @PostMapping("/product/create")
    public String createProduct(@RequestBody Product prod){
        prodService.saveProduct(prod);
        return "Product successfully created";
    }

    @GetMapping("/product/get/{id}")
    public Product getProductById(@PathVariable Long id){
        return prodService.getProductById(id);
    }

    @GetMapping("/product/get/all")
    public List<Product> getAllProducts(){
        return prodService.getAllProducts();
    }

    @PostMapping("/product/edit/{id}")
    public Product editProduct(@PathVariable Long id,
                               @RequestParam(required = false, name = "name")String newName,
                               @RequestParam(required = false, name = "brand")String newBrand,
                               @RequestParam(required = false, name ="cost")Double newCost,
                               @RequestParam(required = false, name = "stock")Double newStock){
        return prodService.editProduct(id,newName,newBrand, newCost, newStock);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProductById(@PathVariable Long id){
        prodService.deleteProductById(id);
        return "Product successfully deleted";
    }
}
