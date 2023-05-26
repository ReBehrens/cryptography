package interfaces;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Interface für ein Standardformat von DatumsStempel
 *  
 * @author rene
 *
 */
public interface DateFormat {
	
	
	static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.YYYY_HH:mm");
	
	/**
	 * erstellung eines neuen Zeitstempels
	 * @return gibt einen Formatierten Zeitstempel aus
	 */
	public static String newDate() {
		Date datum = new Date();
		return sdf.format(datum);
	}

}
