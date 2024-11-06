package for_caloriesTracker;

public class Meal {

	private String foodName;
	private double calories;
	private Date date;
	
	public Meal(String foodName, double calories, Date date) {
		this.foodName = foodName;
		this.calories = calories;
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}
	
	public double getCal() {
		return calories;
	}
	
	public String toString() {
		return foodName + ", " + calories + ", " + date.toString();
	}
	
	
}
