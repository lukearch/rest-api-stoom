package br.com.lukearch.stoom.api.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import br.com.lukearch.stoom.api.model.Address;
import br.com.lukearch.stoom.api.repository.AddressRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressRepositoryTest {
  @Autowired
  private AddressRepository addressRepository;

  @Test
  @Rollback(false)
  @Order(1)
  public void testSaveNewAddress() {
    // Instancia uma nova entidade endereço
    Address address = new Address();
    address.setStreetName("R. Zuneide Aparecida Marin");
    address.setNumber(43L);
    address.setComplement("Barao Geraldo");
    address.setNeighbourhood("Jardim Santa Genebra II");
    address.setCity("Campinas");
    address.setState("SP");
    address.setZipcode(13084780L);
    address.setCountry("Brasil");

    // Salva a entidade Endereço e no banco de dados 
    addressRepository.save(address);

    // Verifica se o ID foi gerado corretamente
    assertThat(address.getId()).isGreaterThan(0L);
  }

  @Test
  @Order(2)
  public void testReadAddress() {
    // Salva um novo endereço no banco de dados
    testSaveNewAddress();

    // Faz um select no banco de dados em busca do endereço de ID 1
    Optional<Address> address = addressRepository.findById(1L);

    // Verifica se o endereço foi encontrado corretamente
    assertThat(address.isPresent()).isTrue();
  }

  @Test
  @Transactional
  @Order(3)
  public void testUpdateAddress() {
    // Salva um novo endereço no banco de dados
    testSaveNewAddress();

    // Faz um select no banco de dados em busca do endereço de ID 1
    Optional<Address> address = addressRepository.findById(1L);

    // Verifica se o endereço foi encontrado corretamente
    if(address.isPresent()) {

      // Altera a entidade Endereço e em sua propriedade country com o valor "United Kingdom"
      address.get().setCountry("United Kingdom");
    }

    // Busca novamente no banco de dados pelo endereço de ID 1
    address = addressRepository.findById(1L);

    // Verifica se a propriedade foi alterada com sucesso
    assertThat(address.get().getCountry()).isEqualTo("United Kingdom");
  }

  @Test
  @Transactional
  @Order(4)
  public void testDeleteAddress() {
    // Salva um novo endereço no banco de dados
    testSaveNewAddress();

    // Faz um select no banco de dados em busca do endereço de ID 1
    Optional<Address> address = addressRepository.findById(1L);

    // Verifica se o endereço foi encontrado corretamente
    if(address.isPresent()) {

      // Pede para o repositorio remover a entidade endereço do banco de dados
      addressRepository.delete(address.get());
    }

    // Verifica se o retorno da busca pela entidade Endereço com ID 1 é null
    assertThat(addressRepository.findById(1L)).isEmpty();
  }
}
