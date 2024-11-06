package for_caloriesTracker;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class Driver {

	public static void main(String arg[]) {
		try {
			Scanner scnr = new Scanner(new File("src/fooddiary.txt"));
			Scanner scan = new Scanner(new File("src/exercisediary.txt"));
			ArrayList<Meal> meal = new ArrayList<>();
			ArrayList<Exercise> exercise = new ArrayList<>();
			ArrayList<CustomList> result = new ArrayList<>();
			
			System.out.println("----------------------");
			System.out.println("Date:            Cals:");
			System.out.println("----------------------");
			
			while(scnr.hasNextLine()) {
				
				String foodItem = scnr.nextLine();
				String[] foodSplit = foodItem.split(", ");
				String food = foodSplit[0];
				double calories = Double.valueOf(foodSplit[1]);
				String month = foodSplit[2];
				int day = Integer.valueOf(foodSplit[3]);
				int year = Integer.valueOf(foodSplit[4]);
				
				Date newDate = new Date(month, day, year);
				Meal newMeal = new Meal(food, calories, newDate);
				
				meal.add(newMeal);
				
			}
			scnr.close();
			
			while(scan.hasNextLine()) {
				String workoutItem = scan.nextLine();
				String[] exerciseSplit = workoutItem.split(", ");
				String workout = exerciseSplit[0];
				double cal = Double.valueOf(exerciseSplit[1]);
				String mon = exerciseSplit[2];
				int date = Integer.valueOf(exerciseSplit[3]);
				int yr = Integer.valueOf(exerciseSplit[4]);
				
				Date nextDate = new Date(mon, date, yr);
				Exercise newExercise = new Exercise(workout, cal, nextDate);
				
				exercise.add(newExercise);
				
				
			}
			scan.close();
			
			double foodSum = 0.0;
			Date current = meal.get(0).getDate();
			
			
			for(int i = 0; i < meal.size(); i++) {
				Date next = meal.get(i).getDate();
				double calVal = meal.get(i).getCal();
				
				if(current.equals(next)) {
					foodSum += calVal;
				} else {
					result.add(new CustomList(current, foodSum));
					current = next;
					foodSum = calVal;
				}
			}
			
			result.add(new CustomList(current, foodSum));
			
	        //Subtracting exercise calories for each date
	        for (int i = 0; i < result.size(); i++) {
	            Date resultDate = result.get(i).getDate();
	            double totalCalories = result.get(i).getCalories();
	
	            for (Exercise ex : exercise) {
	                if (resultDate.equals(ex.getDate())) {
	                    totalCalories -= ex.getCal();
	                }
	            }
	            result.set(i, new CustomList(resultDate, totalCalories));
	        }
			
			// Print out the results
	        for (CustomList item : result) {
	            System.out.println(item);
	        }
	        
		} catch(FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		}	
	}
}
