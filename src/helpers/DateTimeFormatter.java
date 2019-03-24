package helpers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatter {
	public String formatDateTime(Timestamp dateTime) {
		String formattedDateTime = new SimpleDateFormat("MM/dd/yyyy hh:mm a").format(dateTime);
		
		return formattedDateTime;
	}
	
	public String formatTime(Timestamp time) {
		String formattedTime = new SimpleDateFormat("hh:mm a").format(time);
		
		return formattedTime;
	}
	
	public String formatDate(Timestamp date) {
		String formattedDate = new SimpleDateFormat("MM/dd/yyyy").format(date);
		
		return formattedDate;
	}
	
	public String dateToday() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
	}

	public Date parse(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
}
