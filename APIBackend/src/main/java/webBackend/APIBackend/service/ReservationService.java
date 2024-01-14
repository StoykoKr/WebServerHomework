package webBackend.APIBackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import webBackend.APIBackend.dto.LocationRepository;
import webBackend.APIBackend.dto.ReservationRepository;
import webBackend.APIBackend.dto.requests.CreateReservationDTO;
import webBackend.APIBackend.dto.requests.UpdateReservationDTO;
import webBackend.APIBackend.dto.responses.ResponseHolidayDTO;
import webBackend.APIBackend.dto.responses.ResponseReservationDTO;
import webBackend.APIBackend.model.Holiday;
import webBackend.APIBackend.model.Reservation;
import webBackend.APIBackend.dto.HolidayRepository;

@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;
	private final HolidayRepository holidayRepository;
	private final HolidayService holidayService;
	
	public ReservationService(ReservationRepository reservationRepository, HolidayService holidayService,HolidayRepository holidayRepository) {
		super();
		this.reservationRepository = reservationRepository;
		this.holidayService = holidayService;
		this.holidayRepository = holidayRepository;
	}
	
	public boolean deleteReservationById(Integer id) {
		if(reservationRepository.existsById(Long.parseLong(id.toString()))) {
			reservationRepository.deleteById(Long.parseLong(id.toString()));
			return true;
		}
		return false;
	}
	
	public List<ResponseReservationDTO> getAllReservations(){
		return reservationRepository.findAll().stream().map(this::reservationToResponseDTO).toList();
	}
	public ResponseReservationDTO getReservationById(Integer id) {
		return reservationToResponseDTO(reservationRepository.findById(Long.parseLong(id.toString())).get());
	}
	public ResponseReservationDTO updateReservation(UpdateReservationDTO updateDto) {
		Reservation reservation = reservationRepository.findById(updateDto.getId()).get();
		reservation.setContactName(updateDto.getContactName());
		reservation.setId(updateDto.getId());
		reservation.setPhoneNumber(updateDto.getPhoneNumber());
		Holiday holiday = holidayRepository.findById(updateDto.getHoliday()).get();
		reservation.setHoliday(holiday);
		
		return reservationToResponseDTO(reservationRepository.save(reservation));
	}
	public ResponseReservationDTO createReservation(CreateReservationDTO createreservationDTO) {
		Reservation reservation = new Reservation();
		reservation.setContactName(createreservationDTO.getContactName());
		reservation.setPhoneNumber(createreservationDTO.getPhoneNumber());
		Holiday holiday = new Holiday();
		holiday = holidayRepository.findById(createreservationDTO.getHoliday()).get();
		reservation.setHoliday(holiday);		
		
		return reservationToResponseDTO(reservationRepository.save(reservation));
	}
	private ResponseReservationDTO reservationToResponseDTO(Reservation reservation) {
		Holiday holiday = reservation.getHoliday();
		ResponseReservationDTO response = new ResponseReservationDTO();
		response.setContactName(reservation.getContactName());
		response.setId(reservation.getId());
		response.setPhoneNumber(reservation.getPhoneNumber());
		response.setHoliday(holidayService.getHolidayById(Integer.parseInt(holiday.getId().toString())));		
		
		return response;
	}

}
