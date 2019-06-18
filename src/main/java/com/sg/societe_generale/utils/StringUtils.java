package com.sg.societe_generale.utils;

/**
 * @author Sangram Badi
 * @since  18-06-2019
 *
 */
public class StringUtils {
	
	/**
	 * @param data
	 * @return boolean
	 * 
	 * Check if string is empty or not
	 */
	public static boolean isValid(String data) {
		if(data.trim().isEmpty() || data.trim().length() <= 3)
			return false;
		return true;
	}

}
