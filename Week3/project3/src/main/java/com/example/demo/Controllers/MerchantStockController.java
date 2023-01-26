package com.example.demo.Controllers;

import com.example.demo.ApiResponse;
import com.example.demo.Pojo.MerchantStock;
import com.example.demo.Services.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/merchant/stock")
public class MerchantStockController {
    private final MerchantStockService merchantStockService;


    @GetMapping("/get")
    public ResponseEntity getMerchantStockStocks(){
        return ResponseEntity.status(200).body(merchantStockService.getMerchantStocks());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getMerchantStock(@PathVariable String id){
        int index = merchantStockService.getMerchantStock(id);
        if(index>-1){
            return ResponseEntity.status(200).body(merchantStockService.getMerchantStock(index));
        }
        return ResponseEntity.status(404).body(id+" not found!");
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        merchantStockService.addMerchantStock(product);
        return ResponseEntity.status(200).body("Merchant Stock Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable String id, @Valid @RequestBody MerchantStock product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        boolean isUpdated = merchantStockService.updateMerchantStock(product,id);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("MerchantStock updated successfully"));
        }else {
            return ResponseEntity.status(404).body(id+" not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id){

        boolean isDeleted = merchantStockService.deleteMerchantStock(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body(id + " deleted!");
        }
        return ResponseEntity.status(404).body(id+" not found!");

    }





}
