package com.bootcamp.ms.productBank.service.impl;

import com.bootcamp.ms.commons.entity.ProductBank;
import com.bootcamp.ms.productBank.repository.ProductBankRepository;
import com.bootcamp.ms.productBank.service.ProductBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class ProductBankServiceImpl implements ProductBankService {

    @Autowired
    private ProductBankRepository productBankRepository;

    public ProductBankServiceImpl(ProductBankRepository productBankRepository) {
        this.productBankRepository = productBankRepository;
    }

    @Override
    public Flux<ProductBank> findAll() {
        return productBankRepository.findAll();
    }

    @Override
    public Mono<ProductBank> findById(String id) {
        return productBankRepository.findById(id);
    }

    @Override
    public Mono<ProductBank> save(ProductBank productBank) {
        return productBankRepository.save(productBank);
    }

    @Override
    public Mono<Void> delete(ProductBank productBank) {
        return productBankRepository.delete(productBank);
    }

    @Override
    public Optional<ProductBank> findByDescription(String description) {
        return productBankRepository.findAll()
                .toStream()
                .filter(p -> p.getDescription().contains(description))
                .findFirst();
    }
}
