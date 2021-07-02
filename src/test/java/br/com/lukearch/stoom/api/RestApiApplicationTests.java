package br.com.lukearch.stoom.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lukearch.stoom.api.controller.AddressController;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	AddressController addressController;

	@Test
	void contextLoads() {
		assertThat(addressController).isNotNull();
	}
}
