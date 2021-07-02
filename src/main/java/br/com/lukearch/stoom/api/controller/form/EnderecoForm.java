package br.com.lukearch.stoom.api.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.lukearch.stoom.api.model.Endereco;
import br.com.lukearch.stoom.api.model.GeocodeResult;
import br.com.lukearch.stoom.api.service.GeocodeService;

public class EnderecoForm {
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
   * @return Endereco
   */
  public Endereco convert(GeocodeService gService) {
    Endereco e = new Endereco();
    e.setStreetName(streetName);
    e.setNumber(number);
    e.setComplement(complement);
    e.setNeighbourhood(neighbourhood);
    e.setCity(city);
    e.setState(state);
    e.setCountry(country);
    e.setZipcode(zipcode);
    e.setLatitude(latitude);
    e.setLongitude(longitude);
    GeocodeResult result = gService.result(e.toString());
    if(latitude == "") {
      e.setLatitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLatitude());
    }
    if(longitude == "") {
      e.setLongitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLongitude());
    }
    return e;
  }

  
  /** 
   * @param endereco
   * @return Endereco
   */
  public Endereco update(Endereco endereco, GeocodeService gService) {
    Endereco e = endereco;
    e.setStreetName(streetName);
    e.setNumber(number);
    e.setComplement(complement);
    e.setNeighbourhood(neighbourhood);
    e.setCity(city);
    e.setState(state);
    e.setCountry(country);
    e.setZipcode(zipcode);
    GeocodeResult result = gService.result(e.toString());
    if(latitude == "" | e.getLatitude().equals(latitude)) {
      e.setLatitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLatitude());
    }
    if(longitude == "" | e.getLongitude().equals(longitude)) {
      e.setLongitude(result.getResults().get(0).getGeometry().getGeocodeLocation().getLongitude());
    }
    return e;
  }
}
