package br.com.lukearch.stoom.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeObject {
  
  @JsonProperty("place_id")
  private String placeId;

  @JsonProperty("address_components")
  private List<AddressComponent> addressComponents;

  @JsonProperty("formatted_address")
  private String formattedAddress;

  private GeocodeGeometry geometry;

  public String getPlaceId() {
    return placeId;
  }

  public void setPlaceId(String placeId) {
    this.placeId = placeId;
  }

  public List<AddressComponent> getAdressComponents() {
    return addressComponents;
  }

  public void setAdressComponents(List<AddressComponent> adressComponents) {
    this.addressComponents = adressComponents;
  }

  public String getFormattedAddress() {
    return formattedAddress;
  }

  public void setFormattedAddress(String formattedAddress) {
    this.formattedAddress = formattedAddress;
  }

  public GeocodeGeometry getGeometry() {
    return geometry;
  }

  public void setGeometry(GeocodeGeometry geometry) {
    this.geometry = geometry;
  }
}
