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
  
  /** 
   * @return Long
   */
  public Long getId() {
    return id;
  }
  
  /** 
   * @return String
   */
  public String getStreetName() {
    return streetName;
  }
  
  /** 
   * @return Long
   */
  public Long getNumber() {
    return number;
  }
  
  /** 
   * @return String
   */
  public String getComplement() {
    return complement;
  }
  
  /** 
   * @return String
   */
  public String getNeighbourhood() {
    return neighbourhood;
  }
  
  /** 
   * @return String
   */
  public String getCity() {
    return city;
  }
  
  /** 
   * @return String
   */
  public String getState() {
    return state;
  }
  
  /** 
   * @return String
   */
  public String getCountry() {
    return country;
  }
  
  /** 
   * @return Long
   */
  public Long getZipcode() {
    return zipcode;
  }
  
  /** 
   * @return Double
   */
  public String getLatitude() {
    return latitude;
  }
  
  /** 
   * @return Double
   */
  public String getLongitude() {
    return longitude;
  }

  
  
  /** 
   * @param lAddress
   * @return List<AddressDto>
   */
  public static List<AddressDto> convert(List<Address> lAddress) {
    return lAddress.stream().map(AddressDto::new).collect(Collectors.toList());
  }
}
