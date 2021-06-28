package com.platzi.platzimarket.domain.service;

import com.platzi.platzimarket.domain.Purchase;
import com.platzi.platzimarket.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseService(PurchaseRepository purchaseRepository){
        this.purchaseRepository = purchaseRepository;
    }

    public List<Purchase> getAll(){
        return this.purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String idClient){
        return this.purchaseRepository.getByClient(idClient);
    }

    public Purchase save(Purchase purchase){
        return this.purchaseRepository.save(purchase);
    }
}
