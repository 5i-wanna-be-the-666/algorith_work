package booking_information;

import java.sql.Timestamp;

/**
 * AbstractBookingInformation entity provides the base persistence definition of
 * the BookingInformation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBookingInformation implements java.io.Serializable {

	// Fields

	private BookingInformationId id;
	private String name;
	private String bookingMethod;
	private Timestamp bookingDate;
	private Timestamp arriveTime;
	private Integer liveDays;
	private Timestamp leavetime;

	// Constructors

	/** default constructor */
	public AbstractBookingInformation() {
	}

	/** minimal constructor */
	public AbstractBookingInformation(BookingInformationId id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractBookingInformation(BookingInformationId id, String name, String bookingMethod, Timestamp bookingDate,
			Timestamp arriveTime, Integer liveDays, Timestamp leavetime) {
		this.id = id;
		this.name = name;
		this.bookingMethod = bookingMethod;
		this.bookingDate = bookingDate;
		this.arriveTime = arriveTime;
		this.liveDays = liveDays;
		this.leavetime = leavetime;
	}

	// Property accessors

	public BookingInformationId getId() {
		return this.id;
	}

	public void setId(BookingInformationId id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBookingMethod() {
		return this.bookingMethod;
	}

	public void setBookingMethod(String bookingMethod) {
		this.bookingMethod = bookingMethod;
	}

	public Timestamp getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(Timestamp bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Timestamp getArriveTime() {
		return this.arriveTime;
	}

	public void setArriveTime(Timestamp arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Integer getLiveDays() {
		return this.liveDays;
	}

	public void setLiveDays(Integer liveDays) {
		this.liveDays = liveDays;
	}

	public Timestamp getLeavetime() {
		return this.leavetime;
	}

	public void setLeavetime(Timestamp leavetime) {
		this.leavetime = leavetime;
	}

}