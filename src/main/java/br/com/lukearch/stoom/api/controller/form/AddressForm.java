package br.com.lukearch.stoom.api.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.lukearch.stoom.api.model.Address;
import br.com.lukearch.stoom.api.model.GeocodeLocation;
import br.com.lukearch.stoom.api.service.GeocodeService;

public class AddressForm {

  @NotBlank
  private String streetName;

  @NotNull
  private Long number;

  @NotBlank
  private String complement;

  @NotBlank
  private String neighbourhood;

  @NotBlank
  private String city;

  @NotBlank
  private String state;

  @NotBlank
  private String country;
  
  @NotNull
  private Long zipcode;


  private String latitude;
  private String longitude;

  public String getStreetName() {
    return streetName;
  }

  public Long getNumber() {
    return number;
  }

  public String getComplement() {
    return complement;
  }

  public String getNeighbourhood() {
    return neighbourhood;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getCountry() {
    return country;
  }

  public Long getZipcode() {
    return zipcode;
  }

  public String getLatitude() {
    return latitude;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }
  
  public void setNumber(Long number) {
    this.number = number;
  }
  
  public void setComplement(String complement) {
    this.complement = complement;
  }
  
  public void setNeighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public void setZipcode(Long zipcode) {
    this.zipcode = zipcode;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
  
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Address convert(GeocodeService gService) {
    Address address = new Address();
    address.setStreetName(this.streetName);
    address.setNumber(this.number);
    address.setComplement(this.complement);
    address.setNeighbourhood(this.neighbourhood);
    address.setCity(this.city);
    address.setState(this.state);
    address.setCountry(this.country);
    address.setZipcode(this.zipcode);
    address.setLatitude(this.latitude);
    address.setLongitude(this.longitude);
    GeocodeLocation location = gService.location(address.toString());
    if(this.latitude == "") {
      address.setLatitude(location.getLatitude());
    }
    if(this.longitude == "") {
      address.setLongitude(location.getLongitude());
    }
    return address;
  }

  public Address update(Address pAddress, GeocodeService gService) {
    pAddress.setStreetName(this.streetName);
    pAddress.setNumber(this.number);
    pAddress.setComplement(this.complement);
    pAddress.setNeighbourhood(this.neighbourhood);
    pAddress.setCity(this.city);
    pAddress.setState(this.state);
    pAddress.setCountry(this.country);
    pAddress.setZipcode(this.zipcode);
    GeocodeLocation location = gService.location(pAddress.toString());
    if(checkIfLatitudeIsOk(pAddress.getLatitude())) {
      pAddress.setLatitude(this.latitude);
    }
    if(!checkIfLatitudeIsOk(pAddress.getLatitude())) {
      pAddress.setLatitude(location.getLatitude());
    }
    if(checkIfLongitudeIsOk(pAddress.getLongitude())) {
      pAddress.setLongitude(this.longitude);
    }
    if(!checkIfLongitudeIsOk(pAddress.getLongitude())) {
      pAddress.setLongitude(location.getLongitude());
    }
    return pAddress;
  }

  public boolean checkIfLatitudeIsOk(String lat) {
    if(!this.latitude.equals("") || !this.latitude.equals(lat)) {
      return true;
    }
    return false;
  }

  public boolean checkIfLongitudeIsOk(String lng) {
    if(!this.longitude.equals("") || !this.longitude.equals(lng)) {
      return true;
    }
    return false;
  }
}
