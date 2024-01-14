package webBackend.APIBackend.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import webBackend.APIBackend.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}
