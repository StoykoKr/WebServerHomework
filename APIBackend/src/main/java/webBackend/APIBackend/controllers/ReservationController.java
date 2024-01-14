package webBackend.APIBackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webBackend.APIBackend.dto.requests.CreateReservationDTO;
import webBackend.APIBackend.dto.requests.UpdateLocationDTO;
import webBackend.APIBackend.dto.requests.UpdateReservationDTO;
import webBackend.APIBackend.dto.responses.ResponseLocationDTO;
import webBackend.APIBackend.dto.responses.ResponseReservationDTO;
import webBackend.APIBackend.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	
	@PostMapping
	public ResponseReservationDTO createReservation(@RequestBody CreateReservationDTO createreservationDTO) {
		return service.createReservation(createreservationDTO);
	}
	@DeleteMapping("/{id}")
	public boolean deleteReservationById(@PathVariable("id") int locationId ) {
		return service.deleteReservationById(locationId );
	}
	
	@GetMapping
	public List<ResponseReservationDTO> getAllReservations() {
		
		return service.getAllReservations();
	}
	@GetMapping("/{id}")
	public ResponseReservationDTO getReservationById(@PathVariable("id") int id) {
		return service.getReservationById(id);
	}
	
	@PutMapping
	public ResponseReservationDTO updateReservationById(@RequestBody UpdateReservationDTO updateReservation) {
		return service.updateReservation(updateReservation);
	}
}
