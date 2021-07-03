package br.com.lukearch.stoom.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeGeometry {
  
  @JsonProperty("location")
  private GeocodeLocation geocodeLocation;

  public GeocodeLocation getGeocodeLocation() {
    return geocodeLocation;
  }

  public void setGeocodeLocation(GeocodeLocation geocodeLocation) {
    this.geocodeLocation = geocodeLocation;
  }
}
