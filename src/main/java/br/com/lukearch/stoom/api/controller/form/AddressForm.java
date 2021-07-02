package br.com.lukearch.stoom.api.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.lukearch.stoom.api.model.Address;
import br.com.lukearch.stoom.api.model.GeocodeResult;
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
   * @param streetName
   */
  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }
  
  /** 
   * @param number
   */
  public void setNumber(Long number) {
    this.number = number;
  }
  
  /** 
   * @param complement
   */
  public void setComplement(String complement) {
    this.complement = complement;
  }
  
  /** 
   * @param neighbourhood
   */
  public void setNeighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
  }
  
  /** 
   * @param city
   */
  public void setCity(String city) {
    this.city = city;
  }
  
  /** 
   * @param state
   */
  public void setState(String state) {
    this.state = state;
  }
  
  /** 
   * @param country
   */
  public void setCountry(String country) {
    this.country = country;
  }
  
  /** 
   * @param zipcode
   */
  public void setZipcode(Long zipcode) {
    this.zipcode = zipcode;
  }
  
  /** 
   * @param latitude
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
  
  /** 
   * @param longitude
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  
  /** 
   * @return Address
   */
  public Address convert(GeocodeService gService) {
    Address address = new Address();
    address.setStreetName(streetName);
    address.setNumber(number);
    address.setComplement(complement);
    address.setNeighbourhood(neighbourhood);
    address.setCity(city);
    address.setState(state);
    address.setCountry(country);
    address.setZipcode(zipcode);
    address.setLatitude(latitude);
    address.setLongitude(longitude);
    GeocodeResult result = gService.result(address.toString());
    if(latitude == "") {
      address.setLatitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLatitude());
    }
    if(longitude == "") {
      address.setLongitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLongitude());
    }
    return address;
  }

  
  /** 
   * @param address
   * @return Address
   */
  public Address update(Address pAddress, GeocodeService gService) {
    Address address = pAddress;
    address.setStreetName(streetName);
    address.setNumber(number);
    address.setComplement(complement);
    address.setNeighbourhood(neighbourhood);
    address.setCity(city);
    address.setState(state);
    address.setCountry(country);
    address.setZipcode(zipcode);
    GeocodeResult result = gService.result(address.toString());
    if(latitude == "" | address.getLatitude().equals(latitude)) {
      address.setLatitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLatitude());
    }
    if(longitude == "" | address.getLongitude().equals(longitude)) {
      address.setLongitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLongitude());
    }
    return address;
  }
}
