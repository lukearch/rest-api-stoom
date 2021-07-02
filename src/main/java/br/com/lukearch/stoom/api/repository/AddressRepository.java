package br.com.lukearch.stoom.api.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lukearch.stoom.api.model.Address;

@Cacheable
public interface AddressRepository extends JpaRepository<Address, Long> {
}
