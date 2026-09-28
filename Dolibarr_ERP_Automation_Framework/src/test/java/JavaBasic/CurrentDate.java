package JavaBasic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CurrentDate {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sdf.format(date);
		Calendar cal= sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);
		String dateBefore = sdf.format(cal.getTime());
	
		
		

	}

}
