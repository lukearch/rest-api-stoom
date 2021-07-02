package br.com.lukearch.stoom.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocodeLocation {
  @JsonProperty("lat")
  private String latitude;

  @JsonProperty("lng")
  private String longitude;

  
  /** 
   * @return String
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
   * @return String
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
}
