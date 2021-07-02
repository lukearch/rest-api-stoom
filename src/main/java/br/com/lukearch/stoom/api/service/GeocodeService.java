package br.com.lukearch.stoom.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.lukearch.stoom.api.model.AddressComponent;
import br.com.lukearch.stoom.api.model.GeocodeGeometry;
import br.com.lukearch.stoom.api.model.GeocodeLocation;
import br.com.lukearch.stoom.api.model.GeocodeObject;
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
  
  public GeocodeObject object(String location) {
    return result(location).getResults().get(0);
  }
  
  public List<AddressComponent> addressComponents(String location) {
    return object(location).getAdressComponents();
  }

  public GeocodeGeometry geometry(String location) {
    return object(location).getGeometry();
  }

  public GeocodeLocation location(String location) {
    return geometry(location).getGeocodeLocation();
  }
}