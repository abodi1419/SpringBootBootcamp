package com.example.project3.Controller;

import com.example.project3.Pojo.Merchant;
import com.example.project3.Service.MerchantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/merchant")
@RequiredArgsConstructor
public class MerchantController {
    
    private final MerchantService merchantService;

    @GetMapping("/get")
    public ResponseEntity getMerchants(){
        ArrayList<Merchant> merchants = merchantService.getMerchants();
        return ResponseEntity.status(200).body(merchants);
    }

    @PostMapping("/add")
    public ResponseEntity addMerchant(@Valid @RequestBody Merchant merchant, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        merchantService.addMerchant(merchant);
        return ResponseEntity.status(200).body("Merchant Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateMerchant(@PathVariable String id, @Valid @RequestBody Merchant merchant, Errors errors){
        if (errors.hasErrors()){
            String message= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        } else if (merchantService.updateMerchant(id, merchant)) {
            return ResponseEntity.status(200).body("Merchant Was updated");
        }else
            return ResponseEntity.status(400).body("Merchant Was not Found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMerchant(@PathVariable String id){
        if(merchantService.deleteMerchant(id))
            return ResponseEntity.status(200).body("Merchant was Deleted");
        else
            return ResponseEntity.status(400).body("Merchant was not Found");
    }
}
