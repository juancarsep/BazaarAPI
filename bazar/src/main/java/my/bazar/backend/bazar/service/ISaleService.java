package my.bazar.backend.bazar.service;

import my.bazar.backend.bazar.dto.SaleDTO;
import my.bazar.backend.bazar.model.Product;
import my.bazar.backend.bazar.model.Sale;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    public void saveSale(Sale sale);
    public Sale getSaleById(Long id);
    public List<Sale> getAllSales();
    public Sale editSale(Long id, LocalDate sale_date, Double total, List<Product> productsList);
    public void deleteSaleById(Long id);
    public List<Product> getSaleProducts(Long id);
    public String getSaleSummary(LocalDate date);

    public SaleDTO getBiggestSaleInfo();
}
