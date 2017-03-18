package org.myStudy.utility;

public class ValidateUtility {
	
	public static boolean isNullOrEmpty(String value) {
		if (value == null || value.trim().equals(""))
			return true;
		return false;
	}

}
