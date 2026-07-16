package model;

// Represents a single meal with the amount of 
// calories, protein, fat, and the dietary preference.
public class Meal {
    private String name;
    private int calories;
    private int protein;
    private int fat;
    private String dietPref;

    // EFFECTS: Constructs Meal with name,
    // calories, protein, fat and diet Preference
    public Meal(String name, int calories, int protein, int fat, String dietPref) {
        // stub
    }

    // EFFECTS: Returns name of a meal
    public String getName() {
        return null; // stub
    }

    // EFFECTS: Returns calories in a meal
    public int getCalories() {
        return 0; // stub
    }

    // EFFECTS: Returns protein in a meal
    public int getProtein() {
        return 0; // stub
    }

    // EFFECTS: Returns fat in a meal
    public int getFat() {
        return 0; // stub
    }

    // EFFECTS: Returns Dietary Preference category of a meal
    public String getDietPref() {
        return null; // stub
    }

    // EFFECTS: Returns a score of the healthiness of a meal based on
    // calories, protein, and fat. The formula used is
    // (Protein*3) - Fat - (Calories/20)+40
    public int mealScore() {
        return (getProtein() * 3) - getFat() - (getCalories() / 20);
    }


}
