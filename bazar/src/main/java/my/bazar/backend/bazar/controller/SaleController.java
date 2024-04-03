package my.bazar.backend.bazar.controller;

import my.bazar.backend.bazar.model.Product;
import my.bazar.backend.bazar.model.Sale;
import my.bazar.backend.bazar.repository.ISaleRepository;
import my.bazar.backend.bazar.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SaleController {
    @Autowired
    ISaleService saleService;

    @PostMapping("/sale/create")
    public String createSale(@RequestBody Sale sale){
        saleService.saveSale(sale);
        return "Sale successfully created";
    }

    @GetMapping("/sale/get/{id}")
    public Sale getSaleById(@PathVariable Long id){
        return saleService.getSaleById(id);
    }

    @GetMapping("/sale/get/all")
    public List<Sale> getAllSales(){
        return saleService.getAllSales();
    }

    @PutMapping("/sale/edit/{id}")
    public Sale editSale(@PathVariable Long id,
                         @RequestParam(required = false, name = "localDate") LocalDate newLocalDate,
                         @RequestParam(required = false, name = "total")Double newTotal,
                         @RequestParam(required = false, name = "productsList")List<Product> newProductList){
        return saleService.editSale(id, newLocalDate,newTotal, newProductList);
    }

    @DeleteMapping("/sale/delete/{id}")
    public String deleteSaleById(@PathVariable Long id){
        saleService.deleteSaleById(id);
        return "Sale successfully deleted";
    }

    @GetMapping("/sale/products/{sale_id}")
    public List<Product> getSaleProduct(@PathVariable Long id){
        return saleService.getSaleProducts(id);
    }
}
