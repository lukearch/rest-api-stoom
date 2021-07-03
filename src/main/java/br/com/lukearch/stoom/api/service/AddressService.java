package br.com.lukearch.stoom.api.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lukearch.stoom.api.controller.dto.AddressDto;
import br.com.lukearch.stoom.api.controller.form.AddressForm;
import br.com.lukearch.stoom.api.model.Address;
import br.com.lukearch.stoom.api.repository.AddressRepository;

@Service
@Transactional
public class AddressService {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private GeocodeService gService;

  public List<AddressDto> getAllAddress() {
    List<Address> lAddress = addressRepository.findAll();
    return AddressDto.convert(lAddress);
  }

  public AddressDto getAddress(Long id) {
    Optional<Address> address = addressRepository.findById(id);
    if(address.isPresent()) {
      return new AddressDto(address.get());
    }
    return null;
  }

  public Address saveAddress(AddressForm addressForm) {
    Address address = addressForm.convert(gService);
    addressRepository.save(address);
    return address;
  }

  public AddressDto updateAddress(Long id, AddressForm addressForm) {
    Optional<Address> address = addressRepository.findById(id);
    if(address.isPresent()) {
      addressForm.update(address.get(), gService);
      return new  AddressDto(address.get());
    }
    return null;
  }

  public boolean canDeleteAddress(Long id) {
    Optional<Address> address = addressRepository.findById(id);
    if(address.isPresent()) {
      addressRepository.delete(address.get());
      return true;
    }
    return false;
  }
}