package webBackend.APIBackend.dto.responses;

public class ResponseReservationDTO{
	private Long id;
	private String contactName;
	private String phoneNumber;
	private ResponseHolidayDTO holiday;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ResponseHolidayDTO getHoliday() {
		return holiday;
	}
	public void setHoliday(ResponseHolidayDTO holiday) {
		this.holiday = holiday;
	}
	public ResponseReservationDTO(Long id, String contactName, String phoneNumber, ResponseHolidayDTO holiday) {
		this.id = id;
		this.contactName = contactName;
		this.phoneNumber = phoneNumber;
		this.holiday = holiday;
	}
	public ResponseReservationDTO() {
	}

}
