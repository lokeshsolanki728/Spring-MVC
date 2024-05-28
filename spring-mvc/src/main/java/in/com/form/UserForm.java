package in.com.form;

import org.hibernate.validator.constraints.NotEmpty;

public class UserForm {

	private long id = 0;
	private long ids[];
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String loginId;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String dob;
	
	@NotEmpty
	private String address;
	
	
	private int pazeNo;
	
	private String operation;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long[] getIds() {
		return ids;
	}

	public void setIds(long[] ids) {
		this.ids = ids;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPazeNo() {
		return pazeNo;
	}

	public void setPazeNo(int pazeNo) {
		this.pazeNo = pazeNo;
	}
}
