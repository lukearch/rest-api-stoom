package br.com.lukearch.stoom.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lukearch.stoom.restapi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
  
}
