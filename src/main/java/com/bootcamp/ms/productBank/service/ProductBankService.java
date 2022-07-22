package com.bootcamp.ms.productBank.service;

import com.bootcamp.ms.commons.entity.ProductBank;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.stream.Stream;

public interface ProductBankService {

    Flux<ProductBank> findAll();
    Mono<ProductBank> findById(String id);
    Mono<ProductBank> save(ProductBank productBank);
    Mono<Void> delete(ProductBank productBank);
    Optional<ProductBank> findByDescription(String description);
}
