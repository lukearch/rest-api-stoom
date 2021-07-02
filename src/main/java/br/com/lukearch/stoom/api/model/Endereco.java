package br.com.lukearch.stoom.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  
  /** 
   * @return Long
   */
  public Long getId() {
    return id;
  }
  
  /** 
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }
  
  /** 
   * @return String
   */
  public String getStreetName() {
    return streetName;
  }
  
  /** 
   * @param streetName
   */
  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }
  
  /** 
   * @return Long
   */
  public Long getNumber() {
    return number;
  }
  
  /** 
   * @param number
   */
  public void setNumber(Long number) {
    this.number = number;
  }
  
  /** 
   * @return String
   */
  public String getComplement() {
    return complement;
  }
  
  /** 
   * @param complement
   */
  public void setComplement(String complement) {
    this.complement = complement;
  }
  
  /** 
   * @return String
   */
  public String getNeighbourhood() {
    return neighbourhood;
  }
  
  /** 
   * @param neighbourhood
   */
  public void setNeighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
  }
  
  /** 
   * @return String
   */
  public String getCity() {
    return city;
  }
  
  /** 
   * @param city
   */
  public void setCity(String city) {
    this.city = city;
  }
  
  /** 
   * @return String
   */
  public String getState() {
    return state;
  }
  
  /** 
   * @param state
   */
  public void setState(String state) {
    this.state = state;
  }
  
  /** 
   * @return String
   */
  public String getCountry() {
    return country;
  }
  
  /** 
   * @param country
   */
  public void setCountry(String country) {
    this.country = country;
  }
  
  /** 
   * @return Long
   */
  public Long getZipcode() {
    return zipcode;
  }
  
  /** 
   * @param zipcode
   */
  public void setZipcode(Long zipcode) {
    this.zipcode = zipcode;
  }
  
  /** 
   * @return Double
   */
  public String getLatitude() {
    return latitude;
  }
  
  /** 
   * @param latitude
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
  
  /** 
   * @return Double
   */
  public String getLongitude() {
    return longitude;
  }
  
  /** 
   * @param longitude
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  
  /** 
   * @return String
   */
  @Override
  public String toString() {
    return
    streetName
    + "," +
    number
    + "," + 
    complement 
    + "," + 
    neighbourhood
    + "," +
    city
    + "," +
    state
    + "," +
    country;
  }
}
