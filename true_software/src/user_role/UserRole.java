package user_role;

/**
 * UserRole entity. @author MyEclipse Persistence Tools
 */
public class UserRole extends AbstractUserRole implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserRole() {
	}

	/** minimal constructor */
	public UserRole(String username) {
		super(username);
	}

	/** full constructor */
	public UserRole(String username, String passwd, String position, String idCard) {
		super(username, passwd, position, idCard);
	}

}
