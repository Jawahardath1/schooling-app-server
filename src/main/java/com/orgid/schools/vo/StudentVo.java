/**
 * 
 */
package com.orgid.schools.vo;

import lombok.Data;

/**
 * @author Jawahar Dath Thangirala
 * Jan 8, 2020
 */
@Data
public class StudentVo {
	
	private Long 	id;
	private String  created_at;
	private String	updated_at;
	private String 	address;
	private String 	city;
	private String 	country;
	private String 	firstname;
	private String 	lastname;
	private String 	middlename;
	private String 	state;
	private String 	studentid;
	private String 	zipcode;

}
