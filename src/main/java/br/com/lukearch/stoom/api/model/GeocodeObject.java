package br.com.lukearch.stoom.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeObject {
  @JsonProperty("place_id")
  private String placeId;

  @JsonProperty("address_components")
  private List<AdressComponent> adressComponents;

  @JsonProperty("formatted_address")
  private String formattedAddress;

  private GeocodeGeometry geometry;

  
  /** 
   * @return String
   */
  public String getPlaceId() {
    return placeId;
  }

  
  /** 
   * @param placeId
   */
  public void setPlaceId(String placeId) {
    this.placeId = placeId;
  }

  
  /** 
   * @return List<AdressComponent>
   */
  public List<AdressComponent> getAdressComponents() {
    return adressComponents;
  }

  
  /** 
   * @param adressComponents
   */
  public void setAdressComponents(List<AdressComponent> adressComponents) {
    this.adressComponents = adressComponents;
  }

  
  /** 
   * @return String
   */
  public String getFormattedAddress() {
    return formattedAddress;
  }

  
  /** 
   * @param formattedAddress
   */
  public void setFormattedAddress(String formattedAddress) {
    this.formattedAddress = formattedAddress;
  }

  
  /** 
   * @return GeocodeGeometry
   */
  public GeocodeGeometry getGeometry() {
    return geometry;
  }

  
  /** 
   * @param geometry
   */
  public void setGeometry(GeocodeGeometry geometry) {
    this.geometry = geometry;
  }

  
}
