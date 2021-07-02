package br.com.lukearch.stoom.api.controllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.lukearch.stoom.api.model.Address;
import br.com.lukearch.stoom.api.service.GeocodeService;

@WebAppConfiguration
public class AddressControllerTest {
  @Autowired
  GeocodeService gService;

  @Test
  public void shouldReturnAllAddress() {
    Address address = new Address();
    address.setStreetName("R. Zuneide Aparecida Marin");
    address.setNumber(43L);
    address.setComplement("Barao Geraldo");
    address.setNeighbourhood("Jardim Santa Genebra II");
    address.setCity("Campinas");
    address.setState("SP");
    address.setZipcode(13084780L);
    address.setCountry("Brasil");
  }
}
