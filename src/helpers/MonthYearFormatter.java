package helpers;

public class MonthYearFormatter {
	public String formatMonth(String month) {
		switch(month) {
		case "January":
			month = "1";
			break;
		case "February":
			month = "2";
			break;
		case "March":
			month = "3";
			break;
		case "April":
			month = "4";
			break;
		case "May":
			month = "5";
			break;
		case "June":
			month = "6";
			break;
		case "July":
			month = "7";
			break;
		case "August":
			month = "8";
			break;
		case "September":
			month = "9";
			break;
		case "October":
			month = "10";
			break;
		case "November":
			month = "11";
			break;
		case "December":
			month = "12";
			break;
		default:
			month = "invalid";
		}
		
		return month;
	}
	
	public String formatYear(String year) {
		switch(year) {
		case "2019":
			year = "19";
			break;
		case "2020":
			year = "20";
			break;
		case "2021":
			year = "21";
			break;
		case "2022":
			year = "22";
			break;
		case "2023":
			year = "23";
			break;
		default:
			year = "invalid";
		}
		
		return year;
	}
	
	public String formatExpirationDate(String expirationMonth, String expirationYear) {
		String formattedExpirationDate = String.join("/", expirationMonth, expirationYear);
		
		return formattedExpirationDate;
	}
	
	
}
