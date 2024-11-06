package for_caloriesTracker;

public class CustomList {
    private Date date;
    private double calories;

    public CustomList(Date date, double calories) {
        this.date = date;
        this.calories = calories;
    }

    public Date getDate() {
        return date;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Date: " + date + ", Value: " + calories;
    }
}
