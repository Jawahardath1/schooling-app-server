/**
 * 
 */
package com.orgid.schools.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Jawahar Dath Thangirala
 * Jan 7, 2020
 */
public class StudentRequest {
	
	@NotBlank
	@Size(max = 15)
	private String studentid;
	
    @NotBlank
    @Size(max = 40)
    private String firstname;

    @Size(max = 40)
    private String middlename;

    @NotBlank
    @Size(max = 40)
    private String lastname;
    
    @Size(max = 100)
    private String address;
    
    @Size(max = 40)
    private String city;
    
    @Size(max = 10)
    private String zipcode;
    
    @Size(max = 20)
    private String state;
    
    @Size(max = 10)
    private String country;

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
