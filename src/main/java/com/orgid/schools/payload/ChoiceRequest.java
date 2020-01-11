/**
 * 
 */
package com.orgid.schools.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Jawahar Dath Thangirala
 * Sep 9, 2019
 */
public class ChoiceRequest {
	
	@NotBlank
    @Size(max = 40)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
