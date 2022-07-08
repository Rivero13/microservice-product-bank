package com.bootcamp.ms.productBank.controller;

import com.bootcamp.ms.commons.entity.ProductBank;
import com.bootcamp.ms.productBank.service.ProductBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductBankController {

    @Autowired
    private ProductBankService productBankService;

    @GetMapping(value = "/all")
    public Flux<ProductBank> getAll() {
        return productBankService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<ProductBank> findById(@PathVariable String id) {
        return productBankService.findById(id);
    }

    @PostMapping(value = "/create")
    public Mono<ProductBank> create(@RequestBody ProductBank productBank) {
        return productBankService.save(productBank);
    }

    @PutMapping(value = "/{id}")
    public Mono<ProductBank> update(@PathVariable String id, @RequestBody ProductBank productBank) {

        return productBankService.findById(id).flatMap(p -> {
            p.setDescription(productBank.getDescription());

            return productBankService.save(p);
        });
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return productBankService.findById(id).flatMap(p -> {
            return productBankService.delete(p);
        });
    }
}
