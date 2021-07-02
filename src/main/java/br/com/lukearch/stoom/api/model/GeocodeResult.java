package br.com.lukearch.stoom.api.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeResult {
  private List<GeocodeObject> results;
  private String status;

  public List<GeocodeObject> getResults() {
    return results;
  }
  
  public void setResults(List<GeocodeObject> results) {
    this.results = results;
  }

  public String getStatus() {
    return status;
  }
  
  public void setStatus(String status) {
    this.status = status;
  }
}
