package true_book;

/**
 * BookingInformationId entity. @author MyEclipse Persistence Tools
 */
public class BookingInformationId extends AbstractBookingInformationId implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public BookingInformationId() {
	}

	/** full constructor */
	public BookingInformationId(String idCard, String serialNumber) {
		super(idCard, serialNumber);
	}

}
