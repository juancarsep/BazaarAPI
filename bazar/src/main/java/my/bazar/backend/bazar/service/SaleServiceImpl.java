package my.bazar.backend.bazar.service;

import my.bazar.backend.bazar.model.Product;
import my.bazar.backend.bazar.model.Sale;
import my.bazar.backend.bazar.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService{

    @Autowired
    ISaleRepository saleRepo;
    @Override
    public void saveSale(Sale sale) {
        saleRepo.save(sale);
    }

    @Override
    public Sale getSaleById(Long id) {
        return saleRepo.findById(id).orElse(null);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepo.findAll();
    }

    @Override
    public Sale editSale(Long id, LocalDate sale_date, Double total, List<Product> productsList) {
        Sale sale = this.getSaleById(id);
        if(sale != null){
            sale.setSale_date(sale_date);
            sale.setTotal(total);
            sale.setProductsList(productsList);
            this.saveSale(sale);
        }
        return sale;
    }

    @Override
    public void deleteSaleById(Long id) {
        saleRepo.deleteById(id);
    }
}
