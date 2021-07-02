package br.com.lukearch.stoom.restapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeGeometry {
  @JsonProperty("location")
  private GeocodeLocation geocodeLocation;

  
  /** 
   * @return GeocodeLocation
   */
  public GeocodeLocation getGeocodeLocation() {
    return geocodeLocation;
  }
  
  /** 
   * @param geocodeLocation
   */
  public void setGeocodeLocation(GeocodeLocation geocodeLocation) {
    this.geocodeLocation = geocodeLocation;
  }
}
