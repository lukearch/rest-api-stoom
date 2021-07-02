package br.com.lukearch.stoom.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.lukearch.stoom.api.controller.EnderecoController;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	EnderecoController eController;

	@Test
	void contextLoads() {
		assertThat(eController).isNotNull();
	}
}
