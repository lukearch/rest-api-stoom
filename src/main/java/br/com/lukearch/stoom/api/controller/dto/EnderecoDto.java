package br.com.lukearch.stoom.api.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.lukearch.stoom.api.model.Endereco;

public class EnderecoDto {
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

  public EnderecoDto(Endereco e) {
    this.id = e.getId();
    this.streetName = e.getStreetName();
    this.number = e.getNumber();
    this.complement = e.getComplement();
    this.neighbourhood = e.getNeighbourhood();
    this.city = e.getCity();
    this.state = e.getState();
    this.country = e.getCountry();
    this.zipcode = e.getZipcode();
    this.latitude = e.getLatitude();
    this.longitude = e.getLongitude();
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
   * @param lEnderecos
   * @return List<EnderecoDto>
   */
  public static List<EnderecoDto> convert(List<Endereco> lEnderecos) {
    return lEnderecos.stream().map(EnderecoDto::new).collect(Collectors.toList());
  }
}
