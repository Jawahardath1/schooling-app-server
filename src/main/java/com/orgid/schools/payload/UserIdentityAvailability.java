/**
 * 
 */
package com.orgid.schools.payload;

/**
 * @author Jawahar Dath Thangirala
 * Sep 9, 2019
 */
public class UserIdentityAvailability {
	
	private Boolean available;

    public UserIdentityAvailability(Boolean available) {
        this.available = available;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

}
