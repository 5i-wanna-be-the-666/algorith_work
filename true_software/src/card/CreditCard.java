package card;

/**
 * CreditCard entity. @author MyEclipse Persistence Tools
 */
public class CreditCard extends AbstractCreditCard implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public CreditCard() {
	}

	/** minimal constructor */
	public CreditCard(String cardNumber) {
		super(cardNumber);
	}

	/** full constructor */
	public CreditCard(String cardNumber, String idCard, String passwd, Double balance) {
		super(cardNumber, idCard, passwd, balance);
	}

}
