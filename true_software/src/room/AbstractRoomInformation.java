package room;

/**
 * AbstractRoomInformation entity provides the base persistence definition of
 * the RoomInformation entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractRoomInformation implements java.io.Serializable {

	// Fields

	private String serialNumber;
	private String housingType;
	private Double price;
	private Integer maxperson;
	private Boolean empety;
	private String idCard;
	private Double area;

	// Constructors

	/** default constructor */
	public AbstractRoomInformation() {
	}

	/** minimal constructor */
	public AbstractRoomInformation(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	/** full constructor */
	public AbstractRoomInformation(String serialNumber, String housingType, Double price, Integer maxperson,
			Boolean empety, String idCard, Double area) {
		this.serialNumber = serialNumber;
		this.housingType = housingType;
		this.price = price;
		this.maxperson = maxperson;
		this.empety = empety;
		this.idCard = idCard;
		this.area = area;
	}

	// Property accessors

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getHousingType() {
		return this.housingType;
	}

	public void setHousingType(String housingType) {
		this.housingType = housingType;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getMaxperson() {
		return this.maxperson;
	}

	public void setMaxperson(Integer maxperson) {
		this.maxperson = maxperson;
	}

	public Boolean getEmpety() {
		return this.empety;
	}

	public void setEmpety(Boolean empety) {
		this.empety = empety;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Double getArea() {
		return this.area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

}