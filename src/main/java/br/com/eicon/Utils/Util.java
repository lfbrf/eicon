package br.com.eicon.Utils;

public class Util {

	public static String convertMessage(String strToConvert, String value) {
		return strToConvert.replace("$", value);
	}
}
