package br.com.lukearch.stoom.api.controller;

import java.net.URI;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Optional;
>>>>>>> 4e6186e24f9e5c3711830de8fa680ba3904e2eef

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
<<<<<<< HEAD
import br.com.lukearch.stoom.api.service.AddressService;
=======
import br.com.lukearch.stoom.api.repository.AddressRepository;
import br.com.lukearch.stoom.api.service.GeocodeService;
>>>>>>> 4e6186e24f9e5c3711830de8fa680ba3904e2eef

@RestController
@RequestMapping("address")
public class AddressController {
<<<<<<< HEAD

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
=======
  @Autowired
  private AddressRepository addressRepository;
  
  @Autowired
  private GeocodeService gService;

  /** 
   * @return List<AddressDto>
   */
  @GetMapping
  public List<AddressDto> getAll() {
    List<Address> laddresss = addressRepository.findAll();
    return AddressDto.convert(laddresss);
  }
  
  /** 
   * @param id
   * @return ResponseEntity<AddressDto>
   */
  @GetMapping("/{id}")
  public ResponseEntity<AddressDto> getOne(@PathVariable Long id) {
    Optional<Address> address = addressRepository.findById(id);
    if(address.isPresent()) {
      return ResponseEntity.ok(new AddressDto(address.get()));
>>>>>>> 4e6186e24f9e5c3711830de8fa680ba3904e2eef
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
<<<<<<< HEAD
    Address address = addressService.saveAddress(addressForm);
=======
    Address address = addressForm.convert(gService);
    addressRepository.save(address);
>>>>>>> 4e6186e24f9e5c3711830de8fa680ba3904e2eef
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
<<<<<<< HEAD
    AddressDto address = addressService.updateAddress(id);
    if(address != null) {
      return ResponseEntity.ok(address);
=======
    Optional<Address> address = addressRepository.findById(id);
    if(address.isPresent()) {
      addressForm.update(address.get(), gService);
      return ResponseEntity.ok(new AddressDto(address.get()));
>>>>>>> 4e6186e24f9e5c3711830de8fa680ba3904e2eef
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
<<<<<<< HEAD
    if(addressService.canDeleteAddress(id)) {
=======
    Optional<Address> address = addressRepository.findById(id);
    if(address.isPresent()) {
      addressRepository.delete(address.get());
>>>>>>> 4e6186e24f9e5c3711830de8fa680ba3904e2eef
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.notFound().build();
  }
}