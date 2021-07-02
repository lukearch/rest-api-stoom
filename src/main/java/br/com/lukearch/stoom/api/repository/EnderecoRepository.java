package br.com.lukearch.stoom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lukearch.stoom.api.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
