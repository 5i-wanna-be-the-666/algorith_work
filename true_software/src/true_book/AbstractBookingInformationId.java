package true_book;

/**
 * AbstractBookingInformationId entity provides the base persistence definition
 * of the BookingInformationId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBookingInformationId implements java.io.Serializable {

	// Fields

	private String idCard;
	private String serialNumber;

	// Constructors

	/** default constructor */
	public AbstractBookingInformationId() {
	}

	/** full constructor */
	public AbstractBookingInformationId(String idCard, String serialNumber) {
		this.idCard = idCard;
		this.serialNumber = serialNumber;
	}

	// Property accessors

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractBookingInformationId))
			return false;
		AbstractBookingInformationId castOther = (AbstractBookingInformationId) other;

		return ((this.getIdCard() == castOther.getIdCard()) || (this.getIdCard() != null
				&& castOther.getIdCard() != null && this.getIdCard().equals(castOther.getIdCard())))
				&& ((this.getSerialNumber() == castOther.getSerialNumber())
						|| (this.getSerialNumber() != null && castOther.getSerialNumber() != null
								&& this.getSerialNumber().equals(castOther.getSerialNumber())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdCard() == null ? 0 : this.getIdCard().hashCode());
		result = 37 * result + (getSerialNumber() == null ? 0 : this.getSerialNumber().hashCode());
		return result;
	}

}