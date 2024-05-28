package in.com.form;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginForm {
	
	@NotEmpty
	private String loginId;

	@NotEmpty
	private String password;
	
	private String operation;

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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}
