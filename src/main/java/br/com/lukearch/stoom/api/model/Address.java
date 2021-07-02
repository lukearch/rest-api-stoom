package br.com.lukearch.stoom.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
  
  public String getStreetName() {
    return streetName;
  }
 
  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }
 
  public Long getNumber() {
    return number;
  }
 
  public void setNumber(Long number) {
    this.number = number;
  }
  
  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }
 
  public String getNeighbourhood() {
    return neighbourhood;
  }
 
  public void setNeighbourhood(String neighbourhood) {
    this.neighbourhood = neighbourhood;
  }
  
  public String getCity() {
    return city;
  }
  
  public void setCity(String city) {
    this.city = city;
  }
  
  public String getState() {
    return state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
  
  public String getCountry() {
    return country;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public Long getZipcode() {
    return zipcode;
  }
  
  public void setZipcode(Long zipcode) {
    this.zipcode = zipcode;
  }
  
  public String getLatitude() {
    return latitude;
  }
  
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }
  
  public String getLongitude() {
    return longitude;
  }
  
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

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
