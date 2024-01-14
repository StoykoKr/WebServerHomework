package webBackend.APIBackend.dto.responses;
import java.time.LocalDate;
import java.util.Date;
public class ResponseHolidayDTO{
		
	private Long id;
	private ResponseLocationDTO location;
		private String title;
		private LocalDate startDate;
		private Integer duration;
		private Double price;
		private Integer freeSlots;
		public ResponseHolidayDTO() {
			
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public ResponseLocationDTO getLocation() {
			return location;
		}
		public void setLocation(ResponseLocationDTO location) {
			this.location = location;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public Integer getDuration() {
			return duration;
		}
		public void setDuration(Integer duration) {
			this.duration = duration;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Integer getFreeSlots() {
			return freeSlots;
		}
		public void setFreeSlots(Integer freeSlots) {
			this.freeSlots = freeSlots;
		}
		public ResponseHolidayDTO(Long id, ResponseLocationDTO location, String title, LocalDate startDate, Integer duration,
				Double price, Integer freeSlots) {
			
			this.id = id;
			this.location = location;
			this.title = title;
			this.startDate = startDate;
			this.duration = duration;
			this.price = price;
			this.freeSlots = freeSlots;
		}
		

}
