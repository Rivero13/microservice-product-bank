package com.bootcamp.ms.productBank.controller;

import com.bootcamp.ms.commons.entity.ProductBank;
import com.bootcamp.ms.productBank.repository.ProductBankRepository;
import com.bootcamp.ms.productBank.service.ProductBankService;
import com.bootcamp.ms.productBank.service.impl.ProductBankServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ProductBankControllerTest {

    ProductBankRepository productBankRepository;
    ProductBankService productBankService;

    @BeforeEach
    void setUp() {
        productBankRepository = Mockito.mock(ProductBankRepository.class);
        productBankService = new ProductBankServiceImpl(productBankRepository);
    }

    @Test
    void findByDescription() {
        Mockito.when(productBankRepository.findAll()).thenReturn(Datos.PRODUCTOS);
        Optional<ProductBank> productBank = productBankService.findByDescription("Cuentas Corrientes");

        assertTrue(productBank.isPresent());
        assertEquals("Cuentas Corrientes", productBank.orElseThrow().getDescription());
    }

    @Test
    void findById() {
        Mockito.when(productBankRepository.findAll()).thenReturn(Datos.PRODUCTOS);
        Optional<ProductBank> productBank = productBankService.findAll()
                .toStream()
                .filter(p -> p.getId().contains("123"))
                .findFirst();

        assertTrue(productBank.isPresent());
        assertEquals("123", productBank.orElseThrow().getId());
    }
}