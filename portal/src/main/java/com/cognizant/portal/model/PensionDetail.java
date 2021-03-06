package com.cognizant.portal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class PensionDetail {
	private String name;
	private String dateOfBirth;
	private String pan;
	private boolean isSelfPension;
	private boolean isFamilyPension;
	private double pensionAmount;

}
