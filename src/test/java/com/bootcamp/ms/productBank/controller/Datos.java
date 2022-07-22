package com.bootcamp.ms.productBank.controller;

import com.bootcamp.ms.commons.entity.ProductBank;
import reactor.core.publisher.Flux;

public class Datos {

    public final static Flux<ProductBank> PRODUCTOS = Flux.just(
            new ProductBank("123", "Cuentas Corrientes"),
            new ProductBank("456", "Creditos")
    );
}
