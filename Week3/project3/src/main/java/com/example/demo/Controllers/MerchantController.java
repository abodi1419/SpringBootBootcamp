package com.example.demo.Controllers;

import com.example.demo.ApiResponse;
import com.example.demo.Pojo.Merchant;
import com.example.demo.Services.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/merchant")
public class MerchantController {
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchants(){
        return ResponseEntity.status(200).body(merchantService.getMerchants());
    }
    @GetMapping("/get/{id}")
    public ResponseEntity getMerchant(@PathVariable String id){
        int index = merchantService.getMerchant(id);
        if(index>-1){
            return ResponseEntity.status(200).body(merchantService.getMerchant(index));
        }
        return ResponseEntity.status(404).body(id+" not found!");
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        merchantService.addMerchant(product);
        return ResponseEntity.status(200).body("Merchant Added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id, @Valid @RequestBody Merchant product, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage()));
        }
        boolean isUpdated = merchantService.updateMerchant(product,id);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("Merchant updated successfully"));
        }else {
            return ResponseEntity.status(404).body(id+" not found!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){

        boolean isDeleted = merchantService.deleteMerchant(id);
        if(isDeleted) {
            return ResponseEntity.status(200).body(id + " deleted!");
        }
        return ResponseEntity.status(404).body(id+" not found!");

    }





}
