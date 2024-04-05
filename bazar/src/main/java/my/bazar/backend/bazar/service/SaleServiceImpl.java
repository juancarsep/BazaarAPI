package my.bazar.backend.bazar.service;

import my.bazar.backend.bazar.dto.SaleDTO;
import my.bazar.backend.bazar.model.Product;
import my.bazar.backend.bazar.model.Sale;
import my.bazar.backend.bazar.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    @Override
    public List<Product> getSaleProducts(Long id) {
        Sale sale = this.getSaleById(id);
        return sale.getProductsList();
    }

    @Override
    public String getSaleSummary(LocalDate date) {
        double totalAmount = 0;
        int totalQuantity = 0;

        List<Sale> sales = this.getAllSales();

        for(Sale sale : sales){
            if(sale.getSale_date() == date || sale.getSale_date().equals(date)){
                totalQuantity++;
                List<Product> products = sale.getProductsList();
                for(Product product : products){
                    totalAmount += product.getCost();
                }
                products = new ArrayList<>();
            }
        }
        return "Sales summary for the date " + date + "\n" +
                "Total amount: " + totalAmount + "\n" +
                "Total quantity: " + totalQuantity;
    }

    @Override
    public SaleDTO getBiggestSaleInfo() {
        Sale biggestSale = this.findBiggestSale();
        SaleDTO saleDto = new SaleDTO();
        saleDto.setSale_id(biggestSale.getSale_id());
        saleDto.setSaleTotal(biggestSale.getTotal());
        saleDto.setCustomerName(biggestSale.getCustomer().getName());
        saleDto.setCustomerName(biggestSale.getCustomer().getLastname());
        saleDto.setProductQuantity(biggestSale.getProductsList().size());


        return saleDto;
    }

    private Sale findBiggestSale(){
        Double biggestTotal = 0.0;
        Sale sale = null;
        Sale biggestSale = null;
        List<Sale> allSales = this.getAllSales();
        for(Sale sal : allSales){
            if(sal.getTotal() > biggestTotal){
                biggestTotal = sal.getTotal();
                biggestSale = sal;
            }
        }
        return biggestSale;
    }


}
