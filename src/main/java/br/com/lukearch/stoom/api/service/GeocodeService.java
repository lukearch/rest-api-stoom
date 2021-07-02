package br.com.lukearch.stoom.api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.lukearch.stoom.api.model.GeocodeResult;

@Service
public class GeocodeService {
  
  /** 
   * @param location
   * @return GeocodeResult
   */
  public GeocodeResult result(String location) {
    String api = "https://maps.googleapis.com/maps/api/geocode/json?address=" + location + "&key=AIzaSyCj0cY2yEvVfYhAaTz3-P2MW-YRKmhz5Uw";
    RestTemplate template = new RestTemplate();
    GeocodeResult results = template.getForObject(api, GeocodeResult.class);
    return results;
  }
}