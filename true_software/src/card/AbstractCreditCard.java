package card;

/**
 * AbstractCreditCard entity provides the base persistence definition of the
 * CreditCard entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCreditCard implements java.io.Serializable {

	// Fields

	private String cardNumber;
	private String idCard;
	private String passwd;
	private Double balance;

	// Constructors

	/** default constructor */
	public AbstractCreditCard() {
	}

	/** minimal constructor */
	public AbstractCreditCard(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/** full constructor */
	public AbstractCreditCard(String cardNumber, String idCard, String passwd, Double balance) {
		this.cardNumber = cardNumber;
		this.idCard = idCard;
		this.passwd = passwd;
		this.balance = balance;
	}

	// Property accessors

	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

}