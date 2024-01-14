package webBackend.APIBackend.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import webBackend.APIBackend.dto.requests.CreateHolidayDTO;
import webBackend.APIBackend.dto.requests.CreateLocationDTO;
import webBackend.APIBackend.dto.requests.UpdateHolidayDTO;
import webBackend.APIBackend.dto.requests.UpdateLocationDTO;
import webBackend.APIBackend.dto.responses.ResponseHolidayDTO;
import webBackend.APIBackend.dto.responses.ResponseLocationDTO;
import webBackend.APIBackend.service.HolidayService;
import webBackend.APIBackend.service.LocationService;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

	@Autowired
	private HolidayService service;
	
	@PostMapping
	public ResponseHolidayDTO createHoliday(@RequestBody CreateHolidayDTO createHolidayDTO) {		
		return service.createHoliday(createHolidayDTO);
	}
	@DeleteMapping("/{id}")
	public boolean deleteHolidayById(@PathVariable("id") int holidayId ) {
		return service.deleteHolidayById(holidayId );
	}
	
	@GetMapping
	public List<ResponseHolidayDTO> getAllHolidays() {
		
		return service.getAllHolidays();
	}
	@GetMapping("/{id}")
	public ResponseHolidayDTO getHolidayById(@PathVariable("id") int id) {
		return service.getHolidayById(id);
	}
	
	@PutMapping
	public ResponseHolidayDTO updateHolidayById(@RequestBody UpdateHolidayDTO updateHoliday) {
		return service.updateHoliday(updateHoliday);
	}
}
