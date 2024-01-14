package webBackend.APIBackend.controllers;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import webBackend.APIBackend.dto.requests.CreateLocationDTO;
import webBackend.APIBackend.dto.requests.UpdateLocationDTO;
import webBackend.APIBackend.dto.responses.ResponseLocationDTO;
import webBackend.APIBackend.model.Location;
import webBackend.APIBackend.service.LocationService;

@RestController
@RequestMapping("/locations")
public class LocationController {

	@Autowired
	private LocationService service;

	
	@PostMapping
	public ResponseLocationDTO createLocation(@RequestBody CreateLocationDTO createLocationDTO) {		
		return service.createLocation(createLocationDTO);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteLocationById(@PathVariable("id") int locationId ) {
		return service.deleteLocationById(locationId );
	}
	
	@GetMapping
	public List<ResponseLocationDTO> getAllLocations() {
		
		return service.getAllLocations();
	}
	@GetMapping("/{id}")
	public ResponseLocationDTO getLocationById(@PathVariable("id") int id) {
		return service.getLocationById(id);
	}
	
	@PutMapping
	public ResponseLocationDTO updateLocationById(@RequestBody UpdateLocationDTO updateLocation) {
		return service.updateLocation(updateLocation);
	}
}
