package for_caloriesTracker;

public class Exercise {

	private String exerciseType;
	private double calories;
	private Date date;
	
	public Exercise(String exerciseType, double calories, Date date) {
		this.exerciseType = exerciseType;
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
		return exerciseType + ", " + calories + ", " + date.toString();
	}
}
