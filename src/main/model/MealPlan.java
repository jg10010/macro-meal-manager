package model;

import java.util.List;

public class MealPlan {
    private List<Meal> meals;

    // EFFECTS: Constructs MealPlan that is empty
    public MealPlan() {
        // stub;
    }

    // REQUIRES: meal is not null
    // MODIFIES: this
    // EFFECTS: Adds meal to meal plan
    public void addMeal() {
        // stub;
    }

    // REQUIRES: meal is not null
    // MODIFIES: this
    // EFFECTS: Removes meal from meal plan
public void removeMeal(){
    // stub;

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

    // EFFECTS: Returns a new list of meals with preferred dietary category
    public List<Meal> filterDietaryPref() {
        return null; // stub
    }
}
