package free.biava.springmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.Instant;
import java.time.format.DateTimeParseException;

public class URL {
	
	public static String decodeParameter(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Instant convertDate(String date, Instant defaultDate) {
		try {
			return Instant.parse(date);
		}
		catch (DateTimeParseException e) {
			return defaultDate;
		}
			
	}
}
