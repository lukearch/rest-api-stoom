package br.com.lukearch.stoom.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AdressComponent {
  @JsonProperty("long_name")
  private String longName;

  @JsonProperty("short_name")
  private String shortName;

  private List<String> types;

  
  /** 
   * @return String
   */
  public String getLongName() {
    return longName;
  }

  
  /** 
   * @param longName
   */
  public void setLongName(String longName) {
    this.longName = longName;
  }

  
  /** 
   * @return String
   */
  public String getShortName() {
    return shortName;
  }

  
  /** 
   * @param shortName
   */
  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  
  /** 
   * @return List<String>
   */
  public List<String> getTypes() {
    return types;
  }

  
  /** 
   * @param types
   */
  public void setTypes(List<String> types) {
    this.types = types;
  }

  
}
