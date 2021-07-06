package room;

/**
 * RoomInformation entity. @author MyEclipse Persistence Tools
 */
public class RoomInformation extends AbstractRoomInformation implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public RoomInformation() {
	}

	/** minimal constructor */
	public RoomInformation(String serialNumber) {
		super(serialNumber);
	}

	/** full constructor */
	public RoomInformation(String serialNumber, String housingType, Double price, Integer maxperson, Boolean empety,
			String idCard, Double area) {
		super(serialNumber, housingType, price, maxperson, empety, idCard, area);
	}

}
