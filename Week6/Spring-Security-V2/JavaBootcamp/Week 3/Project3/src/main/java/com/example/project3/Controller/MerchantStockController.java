package com.example.project3.Controller;

import com.example.project3.Pojo.MerchantStock;
import com.example.project3.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant-stock")
@RequiredArgsConstructor
public class MerchantStockController {
    private final MerchantStockService merchantStockService;

    @GetMapping("/get")
    public ResponseEntity getMerchantStocks(){
        ArrayList<MerchantStock> merchantStocks = merchantStockService.getMerchantStocks();
        return ResponseEntity.status(200).body(merchantStocks);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchantStock(@Valid @RequestBody MerchantStock merchantStock, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantStockService.addMerchantStock(merchantStock);
        return ResponseEntity.status(200).body("MerchantStock Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchantStock(@PathVariable String id, @Valid @RequestBody MerchantStock merchantStock, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        } else if (merchantStockService.updateMerchantStock(id, merchantStock)) {
            return ResponseEntity.status(200).body("MerchantStock Was updated");
        }else
            return ResponseEntity.status(400).body("MerchantStock Was not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchantStock(@PathVariable String id){
        if(merchantStockService.deleteMerchantStock(id))
            return ResponseEntity.status(200).body("MerchantStock was Deleted");
        else
            return ResponseEntity.status(400).body("MerchantStock was not Found");
    }
}
