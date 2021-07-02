package br.com.lukearch.stoom.api.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.lukearch.stoom.api.controller.dto.AddressDto;
import br.com.lukearch.stoom.api.controller.form.AddressForm;
import br.com.lukearch.stoom.api.model.Address;
import br.com.lukearch.stoom.api.service.AddressService;

@RestController
@RequestMapping("address")
public class AddressController {

  @Autowired
  private AddressService addressService;

  @GetMapping
  public List<AddressDto> getAll() {
    return addressService.getAllAddress();
  }

  @GetMapping("/{id}")
  public ResponseEntity<AddressDto> getOne(@PathVariable Long id) {
    AddressDto address = addressService.getAddress(id);
    if(address != null) {
      return ResponseEntity.ok(address);
    }
    return ResponseEntity.notFound().build();
  }

  /** 
   * @param addressForm
   */
  @PostMapping
  @Transactional
  public ResponseEntity<AddressDto> save(@RequestBody @Valid AddressForm addressForm, UriComponentsBuilder builder, BindingResult result) {
    if(result.hasErrors()) {
    }
    Address address = addressService.saveAddress(addressForm);
    URI uri = builder.path("/addresss/{id}").buildAndExpand(address.getId()).toUri();
    return ResponseEntity.created(uri).body(new AddressDto(address));
  }
  
  /** 
   * @param id
   * @param addressForm
   * @return ResponseEntity<addressDto>
   */
  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity<AddressDto> update(@PathVariable Long id, @RequestBody @Valid AddressForm addressForm) {
    AddressDto address = addressService.updateAddress(id);
    if(address != null) {
      return ResponseEntity.ok(address);
    }
    return ResponseEntity.notFound().build();
  }
  
  /** 
   * @param id
   * @return ResponseEntity<?>
   */
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<?> delete(@PathVariable Long id) {
    if(addressService.canDeleteAddress(id)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}