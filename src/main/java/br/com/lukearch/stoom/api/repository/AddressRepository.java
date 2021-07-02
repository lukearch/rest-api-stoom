package br.com.lukearch.stoom.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lukearch.stoom.api.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
