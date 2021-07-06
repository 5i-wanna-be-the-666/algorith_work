package user_role;

/**
 * AbstractUserRole entity provides the base persistence definition of the
 * UserRole entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserRole implements java.io.Serializable {

	// Fields

	private String username;
	private String passwd;
	private String position;
	private String idCard;

	// Constructors

	/** default constructor */
	public AbstractUserRole() {
	}

	/** minimal constructor */
	public AbstractUserRole(String username) {
		this.username = username;
	}

	/** full constructor */
	public AbstractUserRole(String username, String passwd, String position, String idCard) {
		this.username = username;
		this.passwd = passwd;
		this.position = position;
		this.idCard = idCard;
	}

	// Property accessors

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}