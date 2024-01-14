package webBackend.APIBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import webBackend.APIBackend.dto.LocationRepository;
import webBackend.APIBackend.dto.requests.CreateLocationDTO;
import webBackend.APIBackend.dto.requests.UpdateLocationDTO;
import webBackend.APIBackend.dto.responses.ResponseLocationDTO;
import webBackend.APIBackend.model.Location;

@Service
public class LocationService {
	private final LocationRepository locationRepository;

	public LocationService(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}
	
	public ResponseLocationDTO createLocation(CreateLocationDTO locationDTO) {
		Location location = new Location();
		location.setCity(locationDTO.getCity());
		location.setCountry(locationDTO.getCountry());
		location.setNumber(locationDTO.getNumber());
		location.setStreet(locationDTO.getStreet());
		location.setImageUrl(locationDTO.getImageUrl());
		location = locationRepository.save(location);
		
		return this.locationToDTO(location);
	}
	
	public boolean deleteLocationById(Integer id) {
		if(locationRepository.existsById(Long.parseLong(id.toString()))) {
			locationRepository.deleteById(Long.parseLong(id.toString()));
			return true;
		}
		return false;
	}

	public List<ResponseLocationDTO> getAllLocations(){
		return locationRepository.findAll().stream().map(this::locationToDTO).toList();
	}
	
	public ResponseLocationDTO getLocationById(int id) {
		return this.locationToDTO(findbyID(id));
	}
	public ResponseLocationDTO updateLocation(UpdateLocationDTO updatedto) {
		Location location = locationRepository.findById(updatedto.getId()).get();
		location.setCity(updatedto.getCity());
		location.setCountry(updatedto.getCountry());
		location.setImageUrl(updatedto.getImageUrl());
		location.setNumber(updatedto.getNumber());
		location.setStreet(updatedto.getStreet());
		Location savedLocation = locationRepository.save(location);
		return locationToDTO(savedLocation);
	}

	private Location findbyID(Integer id) {
		return locationRepository.findById(Long.parseLong(id.toString())).get();
	}
	private ResponseLocationDTO locationToDTO(Location local) {		 
		return new ResponseLocationDTO(local.getId(),local.getStreet(),local.getNumber(),local.getCity(),local.getCountry(),local.getImageUrl());
	}
	
}
