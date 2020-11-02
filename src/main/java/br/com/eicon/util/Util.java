package br.com.eicon.util;

public class Util {
	
	private Util() {}

	public static String convertMessage(String strToConvert, String value) {
		return strToConvert.replace("$", value);
	}

	public static String formatToValidQuery(String query) {
		return 	query.substring(0, query.length() - 4);
	}

	public static Long convertToLong(Object o){
		String stringToConvert = String.valueOf(o);
		return  Long.parseLong(stringToConvert);

	}

}
