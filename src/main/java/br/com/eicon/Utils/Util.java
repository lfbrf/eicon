package br.com.eicon.Utils;

import java.util.ArrayList;

import br.com.eicon.Dto.ClientOrderOutputDto;

public class Util {

	public static String convertMessage(String strToConvert, String value) {
		return strToConvert.replace("$", value);
	}
	
}
