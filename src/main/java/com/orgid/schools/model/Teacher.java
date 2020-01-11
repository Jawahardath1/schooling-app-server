/**
 * 
 */
package com.orgid.schools.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.orgid.schools.model.audit.UserDateAudit;

/**
 * @author Jawahar Dath Thangirala
 * Jan 7, 2020
 */

@Entity
@Table(name = "teacher", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "teacherid"
        })        
})
public class Teacher  extends UserDateAudit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5419208075615163421L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    @Size(max = 40)
    private String teacherid;

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


    public Teacher() {

    }

    public Teacher(String teacherid, String firstname, String middlename, String lastname, String address, String city, String zipcode, String state, String country) {
        this.teacherid 	= teacherid;
        this.firstname 	= firstname;
        this.middlename = middlename;
        this.lastname 	= lastname;
        this.address 	= address;
        this.city 		= city;
        this.zipcode 	= zipcode;
        this.country 	= country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
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
