package br.com.lukearch.stoom.restapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeResult {
  private List<GeocodeObject> results;
  private String status;
  
  /** 
   * @return List<GeocodeObject>
   */
  public List<GeocodeObject> getResults() {
    return results;
  }
  
  /** 
   * @param results
   */
  public void setResults(List<GeocodeObject> results) {
    this.results = results;
  }
  
  /** 
   * @return String
   */
  public String getStatus() {
    return status;
  }
  
  /** 
   * @param status
   */
  public void setStatus(String status) {
    this.status = status;
  }
}
