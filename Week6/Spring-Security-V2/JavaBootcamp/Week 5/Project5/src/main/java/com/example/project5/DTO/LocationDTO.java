package com.example.project5.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDTO {
    @NotNull(message = "Store id is required")
    private Integer store_id;
    @NotNull(message = "Area is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;
    @NotNull(message = "street is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String street;
}
