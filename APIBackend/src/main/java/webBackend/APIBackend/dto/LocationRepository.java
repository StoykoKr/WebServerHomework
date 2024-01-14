package webBackend.APIBackend.dto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import webBackend.APIBackend.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long>{
	
	List<Location> findAll();
}