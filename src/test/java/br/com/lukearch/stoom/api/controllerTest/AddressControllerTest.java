package br.com.lukearch.stoom.api.ControllerTest;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import br.com.lukearch.stoom.api.controller.AddressController;
import br.com.lukearch.stoom.api.controller.dto.AddressDto;
import br.com.lukearch.stoom.api.controller.form.AddressForm;
import br.com.lukearch.stoom.api.model.Address;
import br.com.lukearch.stoom.api.service.AddressService;

@WebMvcTest(AddressController.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AddressControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AddressService addressService;

  private List<AddressDto> addressList;

  @BeforeEach
  void setUp() {
    // Popula uma lista para a realização do primeiro teste
    Address address1 = new Address();
    address1.setId(1L);
    address1.setStreetName("R. Zuneide Aparecida Marin");
    address1.setNumber(43L);
    address1.setComplement("Barao Geraldo");
    address1.setNeighbourhood("Jardim Santa Genebra II");
    address1.setCity("Campinas");
    address1.setState("SP");
    address1.setZipcode(13084780L);
    address1.setCountry("Brasil");

    Address address2 = new Address();
    address2.setId(2L);
    address2.setStreetName("Av. Sen. Queirós");
    address2.setNumber(611L);
    address2.setComplement("Bolsão De Compras Senador Queiroz");
    address2.setNeighbourhood("Centro Histórico de São Paulo");
    address2.setCity("São Paulo");
    address2.setState("SP");
    address2.setZipcode(01026001L);
    address2.setCountry("Brasil");

    Address address3 = new Address();
    address3.setId(3L);
    address3.setStreetName("Av. Luís Viana Filho");
    address3.setNumber(0L);
    address3.setComplement("LJ 120");
    address3.setNeighbourhood("Paralela");
    address3.setCity("Salvador");
    address3.setState("Bahia");
    address3.setZipcode(41701005L);
    address3.setCountry("Brasil");

    this.addressList = new ArrayList<>();
    this.addressList.add(new AddressDto(address1));
    this.addressList.add(new AddressDto(address2));
    this.addressList.add(new AddressDto(address3));
  }

  @Test
  @Order(1)
  void shouldFetchAllAddress() throws Exception {
    // Quando addressService executar getAllAddress(), deve retornar a lista addressList
    when(addressService.getAllAddress()).thenReturn(this.addressList);
    this.mockMvc.perform(get("/address")).andExpect(status().isOk()).andExpect(jsonPath("$.size()", is(addressList.size())));
  }

  @Test
  @Order(2)
  void shouldFetchOneAddressById() throws Exception {
    // Quando addressService executar getAddress(Long id), deve retornar um AddressDto equivalente ao Address encontrado
    Address address = new Address();
    address.setId(1L);
    address.setStreetName("Av. Luís Viana Filho");
    address.setNumber(0L);
    address.setComplement("LJ 120");
    address.setNeighbourhood("Paralela");
    address.setCity("Salvador");
    address.setState("Bahia");
    address.setZipcode(41701005L);
    address.setCountry("Brasil");

    AddressDto addressDto = new AddressDto(address);

    when(addressService.getAddress(address.getId())).thenReturn(addressDto);

    this.mockMvc.perform(get("/address/{id}", address.getId()))
    .andExpect(status().isOk())
    .andExpect(jsonPath("$.country", is(address.getCountry())))
    .andExpect(jsonPath("$.city", is(address.getCity())));
  }

  @Test
  @Order(3)
  void shouldCreateNewAddress() throws Exception {

    // Quando addressService executar saveAddress(AddresForm addressForm), deve retornar um Address populado;
    Address address2 = new Address();
    when(addressService.saveAddress(any(AddressForm.class))).thenReturn(address2);

    Address address = new Address();
    address.setId(1L);
    address.setStreetName("Av. Luís Viana Filho");
    address.setNumber(0L);
    address.setComplement("LJ 120");
    address.setNeighbourhood("Paralela");
    address.setCity("Salvador");
    address.setState("Bahia");
    address.setZipcode(41701005L);
    address.setCountry("Brasil");

    this.mockMvc.perform(post("/address")
    .contentType(MediaType.APPLICATION_JSON)
    .content(new ObjectMapper().writeValueAsString(address)))
    .andExpect(status().isCreated())
    .andExpect(jsonPath("$.country", is(address2.getCountry())))
    .andExpect(jsonPath("$.city", is(address2.getCity())));
  }

  @Test
  @Order(4)
  void shouldDeleteUser() throws Exception {
    // Quando addressService executar canDeleteAddress(Long id), deve retornar true
    Address address = new Address();
    address.setId(1L);
    address.setStreetName("Av. Luís Viana Filho");
    address.setNumber(0L);
    address.setComplement("LJ 120");
    address.setNeighbourhood("Paralela");
    address.setCity("Salvador");
    address.setState("Bahia");
    address.setZipcode(41701005L);
    address.setCountry("Brasil");

    when(addressService.canDeleteAddress(address.getId())).thenReturn(true);

    this.mockMvc.perform(delete("/address/{id}", address.getId()))
    .andExpect(status().isOk());
  }
}
