package webBackend.APIBackend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import webBackend.APIBackend.dto.HolidayRepository;
import webBackend.APIBackend.dto.LocationRepository;
import webBackend.APIBackend.dto.requests.CreateHolidayDTO;
import webBackend.APIBackend.dto.requests.CreateLocationDTO;
import webBackend.APIBackend.dto.requests.UpdateHolidayDTO;
import webBackend.APIBackend.dto.responses.ResponseHolidayDTO;
import webBackend.APIBackend.dto.responses.ResponseLocationDTO;
import webBackend.APIBackend.model.Holiday;
import webBackend.APIBackend.model.Location;

@Service
public class HolidayService {

	private final HolidayRepository holidayRepository;
	private final LocationRepository locationRepository;

	public HolidayService(HolidayRepository holidayRepository, LocationRepository locationRepository) {
		super();
		this.holidayRepository = holidayRepository;
		this.locationRepository = locationRepository;
	}
	public boolean deleteHolidayById(Integer id) {
		if(holidayRepository.existsById(Long.parseLong(id.toString()))) {
			holidayRepository.deleteById(Long.parseLong(id.toString()));
			return true;
		}
		return false;
	}
	public List<ResponseHolidayDTO> getAllHolidays(){
		
		return holidayRepository.findAll().stream().map(this::holidayToResponse).toList();
	}
	public ResponseHolidayDTO getHolidayById(Integer id) {
		return holidayToResponse(holidayRepository.findById(Long.parseLong(id.toString())).get());
	}
	public ResponseHolidayDTO updateHoliday(UpdateHolidayDTO updateDTO) {
		Holiday holiday = holidayRepository.findById(updateDTO.getId()).get();
		holiday.setDuration(updateDTO.getDuration());
		holiday.setFreeSlots(updateDTO.getFreeSlots());
		holiday.setPrice(updateDTO.getPrice());
		holiday.setStartDate(updateDTO.getStartDate());
		holiday.setTitle(updateDTO.getTitle());	
		Location location = locationRepository.findById(updateDTO.getLocation()).get();
		 holiday.setLocation(location);
		 
		 return holidayToResponse(holidayRepository.save(holiday));
		
	}
	public ResponseHolidayDTO createHoliday(CreateHolidayDTO holidayDTO) {
		Holiday holiday = new Holiday();
		holiday.setDuration(holidayDTO.getDuration());
		holiday.setFreeSlots(holidayDTO.getFreeSlots());
		holiday.setPrice(holidayDTO.getPrice());
		holiday.setStartDate(holidayDTO.getStartDate());
		holiday.setTitle(holidayDTO.getTitle());		
		Location location = locationRepository.findById(holidayDTO.getLocation()).get();
		 holiday.setLocation(location);
		 
		return holidayToResponse(holidayRepository.save(holiday));
	}
	private ResponseHolidayDTO holidayToResponse(Holiday holiday) {
		ResponseHolidayDTO response = new ResponseHolidayDTO();
		response.setDuration(holiday.getDuration());
		response.setFreeSlots(holiday.getFreeSlots());
		response.setId(holiday.getId());
		response.setPrice(Double.parseDouble(holiday.getPrice()));
		response.setStartDate(holiday.getStartDate());
		response.setTitle(holiday.getTitle());		
		response.setLocation(locationToDTO(holiday.getLocation()));
		return response;
	}
	private ResponseLocationDTO locationToDTO(Location local) {		 
		return new ResponseLocationDTO(local.getId(),local.getStreet(),local.getNumber(),local.getCity(),local.getCountry(),local.getImageUrl());
	}
}
