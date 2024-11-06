package for_caloriesTracker;

public class Date {

	private String month;
	private int day;
	private int year;
	
	public Date(String month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	public boolean equals(Object otherDate) {
		Date other = (Date)otherDate;
		return month.equals(other.month) && day == other.day && year == other.year;
	}
	
	public String toString() {
		return month + " " + day + ", " + year;
	}
}
