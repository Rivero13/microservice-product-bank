package com.bootcamp.ms.productBank.repository;

import com.bootcamp.ms.commons.entity.ProductBank;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductBankRepository extends ReactiveMongoRepository<ProductBank, String> {
}
