package person;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */
public class Person extends AbstractPerson implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** minimal constructor */
	public Person(String idCard) {
		super(idCard);
	}

	/** full constructor */
	public Person(String idCard, String name, String sex, String EMail) {
		super(idCard, name, sex, EMail);
	}

}
