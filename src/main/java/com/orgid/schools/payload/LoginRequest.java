/**
 * 
 */
package com.orgid.schools.payload;

import javax.validation.constraints.NotBlank;

/**
 * @author Jawahar Dath Thangirala Sep 9, 2019
 */
public class LoginRequest {
	@NotBlank
	private String usernameOrEmail;

	@NotBlank
	private String password;

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
