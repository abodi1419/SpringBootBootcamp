package com.example.day3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    @NotNull(message = "teacher id is required")
    private Integer teacher_id;

    @NotNull(message = "area is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String area;
    @NotNull(message = "street is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String street;
    @NotNull(message = "building number is required")
    @Column(columnDefinition = "varchar(30) not null")
    private String buildingNumber;
}
