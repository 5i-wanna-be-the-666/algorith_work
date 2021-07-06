package booking_information;

import java.sql.Timestamp;

/**
 * BookingInformation entity. @author MyEclipse Persistence Tools
 */
public class BookingInformation extends AbstractBookingInformation implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BookingInformation() {
	}

	/** minimal constructor */
	public BookingInformation(BookingInformationId id) {
		super(id);
	}

	/** full constructor */
	public BookingInformation(BookingInformationId id, String name, String bookingMethod, Timestamp bookingDate,
			Timestamp arriveTime, Integer liveDays, Timestamp leavetime) {
		super(id, name, bookingMethod, bookingDate, arriveTime, liveDays, leavetime);
	}

}
