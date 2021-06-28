package com.platzi.platzimarket.web.controller;

import com.platzi.platzimarket.domain.Product;
import com.platzi.platzimarket.domain.Purchase;
import com.platzi.platzimarket.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    PurchaseService purchaseService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("id") String idClient){
        return this.purchaseService.getByClient(idClient)
                .map(purchases -> ResponseEntity.ok(purchases))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(this.purchaseService.save(purchase), HttpStatus.CREATED);
    }




}
