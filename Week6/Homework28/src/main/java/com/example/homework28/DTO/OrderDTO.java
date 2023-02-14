package com.example.homework28.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {
    @NotNull(message = "products ids must not be null")
    private List<Integer> productIds;
    @NotNull(message = "quantities must not be null")
    private List<Integer> quantities;
}
