package br.com.lukearch.stoom.api.dataJpaTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import br.com.lukearch.stoom.api.model.Endereco;
import br.com.lukearch.stoom.api.repository.EnderecoRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EnderecoRepositoryTest {
  @Autowired
  private EnderecoRepository eRepository;

  @Test
  @Rollback(false)
  public void testSaveNewEndereco() {
    // Instancia uma nova entidade endereço
    Endereco e = new Endereco();
    e.setStreetName("R. Zuneide Aparecida Marin");
    e.setNumber(43L);
    e.setComplement("Barao Geraldo");
    e.setNeighbourhood("Jardim Santa Genebra II");
    e.setCity("Campinas");
    e.setState("SP");
    e.setZipcode(13084780L);
    e.setCountry("Brasil");

    // Salva a entidade Endereço e no banco de dados 
    eRepository.save(e);

    // Verifica se o ID foi gerado corretamente
    assertThat(e.getId()).isGreaterThan(0L);
  }

  @Test
  public void testReadEndereco() {
    // Salva um novo endereço no banco de dados
    testSaveNewEndereco();

    // Faz um select no banco de dados em busca do endereço de ID 1
    Optional<Endereco> e = eRepository.findById(1L);

    // Verifica se o endereço foi encontrado corretamente
    assertThat(e.isPresent()).isTrue();
  }

  @Test
  @Transactional
  public void testUpdateEndereco() {
    // Salva um novo endereço no banco de dados
    testSaveNewEndereco();

    // Faz um select no banco de dados em busca do endereço de ID 1
    Optional<Endereco> e = eRepository.findById(1L);

    // Verifica se o endereço foi encontrado corretamente
    if(e.isPresent()) {

      // Altera a entidade Endereço e em sua propriedade country com o valor "United Kingdom"
      e.get().setCountry("United Kingdom");
    }

    // Busca novamente no banco de dados pelo endereço de ID 1
    e = eRepository.findById(1L);

    // Verifica se a propriedade foi alterada com sucesso
    assertThat(e.get().getCountry()).isEqualTo("United Kingdom");
  }

  @Test
  @Transactional
  public void testDeleteEndereco() {
    // Salva um novo endereço no banco de dados
    testSaveNewEndereco();

    // Faz um select no banco de dados em busca do endereço de ID 1
    Optional<Endereco> e = eRepository.findById(1L);

    // Verifica se o endereço foi encontrado corretamente
    if(e.isPresent()) {

      // Pede para o repositorio remover a entidade endereço do banco de dados
      eRepository.delete(e.get());
    }

    // Verifica se o retorno da busca pela entidade Endereço com ID 1 é null
    assertThat(eRepository.findById(1L)).isEmpty();
  }
}
