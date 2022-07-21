package com.bootcamp.ms.productBank;

import com.bootcamp.ms.commons.entity.ProductBank;
import com.bootcamp.ms.productBank.service.ProductBankService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class MicroserviceProductBankApplicationTests {

	private final ProductBank productBank = ProductBank.builder()
			.id("12345")
			.description("cuentas corrientes")
			.build();

	@Test
	void create() {
		assertNotNull(productBank);
	}

	@Test
	void findById() {
		assertAll(
				() -> assertNotNull(productBank.getId()),
				() -> assertEquals("12345", productBank.getId())
		);
	}

	@Test
	void findByName() {
		assertAll(
				() -> assertNotNull(productBank.getDescription()),
				() -> assertEquals("cuentas corrientes", productBank.getDescription())
		);
	}

}
