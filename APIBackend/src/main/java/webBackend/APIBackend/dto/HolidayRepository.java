package webBackend.APIBackend.dto;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import webBackend.APIBackend.model.Holiday;

public interface HolidayRepository extends JpaRepository<Holiday, Long>{

}
