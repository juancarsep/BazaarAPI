package my.bazar.backend.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SaleDTO {
    private Long sale_id;
    private Double saleTotal;
    private int productQuantity;
    private String customerName;
    private String customerLastname;

    public SaleDTO() {
    }

    public SaleDTO(Long sale_id, Double saleTotal, int productQuantity, String customerName, String customerLastname) {
        this.sale_id = sale_id;
        this.saleTotal = saleTotal;
        this.productQuantity = productQuantity;
        this.customerName = customerName;
        this.customerLastname = customerLastname;
    }
}
