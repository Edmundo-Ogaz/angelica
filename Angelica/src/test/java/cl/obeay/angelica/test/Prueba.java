package cl.obeay.angelica.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prueba {
	
	public static void main(String [] args) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse("2016-04-30 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(date);
	}

}
