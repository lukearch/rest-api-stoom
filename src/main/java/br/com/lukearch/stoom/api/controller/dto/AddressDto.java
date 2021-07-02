package br.com.lukearch.stoom.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lukearch.stoom.api.model.Address;

public class AddressDto {
  private Long id;
  private String streetName;
  private Long number;
  private String complement;
  private String neighbourhood;
  private String city;
  private String state;
  private String country;
  private Long zipcode;
  private String latitude;
  private String longitude;

  public AddressDto(Address address) {
    this.id = address.getId();
    this.streetName = address.getStreetName();
    this.number = address.getNumber();
    this.complement = address.getComplement();
    this.neighbourhood = address.getNeighbourhood();
    this.city = address.getCity();
    this.state = address.getState();
    this.country = address.getCountry();
    this.zipcode = address.getZipcode();
    this.latitude = address.getLatitude();
    this.longitude = address.getLongitude();
  }
  
  public Long getId() {
    return id;
  }

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

  public static List<AddressDto> convert(List<Address> lAddress) {
    return lAddress.stream().map(AddressDto::new).collect(Collectors.toList());
  }
}
