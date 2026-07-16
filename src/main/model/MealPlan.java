package model;

import java.util.ArrayList;
import java.util.List;

public class MealPlan {
    private List<Meal> meals;

    // EFFECTS: Constructs MealPlan that is empty
    public MealPlan() {
        // stub
    }

    // REQUIRES: meal is not null
    // MODIFIES: this
    // EFFECTS: Adds meal to meal plan
    public void addMeal(Meal meal) {
        // stub
    }

    // REQUIRES: meal is not null
    // MODIFIES: this
    // EFFECTS: Removes meal from meal plan if present and returns true,
    // else returns false if meal not present
    public boolean removeMeal(Meal meal) {
        return false;// stub
    }

    // EFFECTS: Returns list of meals in MealPlan
    public List<Meal> getMeals() {
        return null; // stub
    }

    // EFFECTS: Returns sum of calories in all meals in MealPlan
    public int totalCalories() {
        return 0; // stub
    }

    // EFFECTS: Returns sum of protein in all meals in MealPlan
    public int totalProtein() {
        return 0; // stub
    }

    // EFFECTS: Returns sum of fat in all meals in MealPlan
    public int totalFat() {
        return 0; // stub
    }

    // EFFECTS: Returns a new list of meals with dietary preference
    // that matches dietPref
    public List<Meal> filterDietaryPref(String dietPref) {
        return new ArrayList<>(); // stub
    }
}
