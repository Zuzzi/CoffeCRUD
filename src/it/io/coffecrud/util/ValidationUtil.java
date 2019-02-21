package it.io.coffecrud.util;
import org.apache.commons.lang3.StringUtils;


public class ValidationUtil {

	public static boolean checkStringField(String input) {
		return StringUtils.isBlank(input);
	}

	public static boolean checkNumberField(String input) {
		return StringUtils.isNumeric(input) && !input.isEmpty();
	}

}
