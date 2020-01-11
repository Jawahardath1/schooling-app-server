/**
 * 
 */
package com.orgid.schools.vo;

import lombok.Data;

/**
 * @author Jawahar Dath Thangirala
 * Jan 10, 2020
 */
@Data
public class TeacherVo {
	
	private Long 	id;
	private String  created_at;
	private Long	created_by;
	private String	updated_at;
	private Long	updated_by;
	private String 	address;
	private String 	city;
	private String 	country;
	private String 	firstname;
	private String 	lastname;
	private String 	middlename;
	private String 	state;
	private String 	teacherid;
	private String 	zipcode;

}
