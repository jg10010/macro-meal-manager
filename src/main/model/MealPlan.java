package model;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {
    private List<Meal> meals;

    // EFFECTS: Constructs MealPlan that is empty
    public MealPlan() {
        meals = new ArrayList<>();
    }

    // REQUIRES: meal is not null
    // MODIFIES: this
    // EFFECTS: Adds meal to meal plan
    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    // REQUIRES: meal is not null
    // MODIFIES: this
    // EFFECTS: Removes meal from meal plan if present and returns true,
    // else returns false if meal not present
    public boolean removeMeal(Meal meal) {
        if (meals.contains(meal)) {
            meals.remove(meal);
            return true;
        } else
            return false;

    }

    // EFFECTS: Returns list of meals in MealPlan
    public List<Meal> getMeals() {
        return meals; // stub
    }

    // EFFECTS: Returns sum of calories in all meals in MealPlan
    public int totalCalories() {
        int total = 0;
        for (Meal m : meals) {
            total = total + m.getCalories();
        }
        return total;
    }

    // EFFECTS: Returns sum of protein in all meals in MealPlan
    public int totalProtein() {
        int total = 0;
        for (Meal m : meals) {
            total = total + m.getProtein();
        }
        return total;
    }

    // EFFECTS: Returns sum of fat in all meals in MealPlan
    public int totalFat() {
        int total = 0;
        for (Meal m : meals) {
            total = total + m.getFat();
        }
        return total;
    }

    // EFFECTS: Returns a new list of meals with dietary preference
    // that matches dietPref
    public List<Meal> filterDietaryPref(String dietPref) {
        List<Meal> filtered = new ArrayList<>();

        for (Meal m : meals) {
            if (m.getDietPref().equals(dietPref)) {
                filtered.add(m);
            }
        }
        return filtered;
    }


//REQUIRES: CalorieGoal, proteinGoal, and fatGoal >= 0
//EFFECTS: Returns true if total calories >= calorieGoal
//                      and total protein >= protein Goal
//                      and total fat >= fatGoal
public boolean dailyMacroRequirements(int calorieGoal, int proteinGoal, int fatGoal) {
    return false; //stub
}




}
