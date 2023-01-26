package com.example.demo.Pojo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotNull(message = "Id must not be null!")
    @Size(min = 3, message = "Id must be 3 characters long at least!")
    private String id;
    @NotNull(message = "Product id must not be null!")
    @Size(min = 3, message = "Product id must be 3 characters long at least!")
    private String productId;
    @NotNull(message = "Merchant id must not be null!")
    @Size(min = 3, message = "Merchant id must be 3 characters long at least!")
    private String merchantId;
    @NotNull(message = "Stock must not be null!")
    @Min(value = 10, message = "Stock must be 10 at least!")
    private int stock;

}
