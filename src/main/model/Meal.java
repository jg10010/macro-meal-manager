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
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.dietPref = dietPref;
    }

    // EFFECTS: Returns name of a meal
    public String getName() {
        return name;
    }

    // EFFECTS: Returns calories in a meal
    public int getCalories() {
        return calories;
    }

    // EFFECTS: Returns protein in a meal
    public int getProtein() {
        return protein;
    }

    // EFFECTS: Returns fat in a meal
    public int getFat() {
        return fat;
    }

    // EFFECTS: Returns Dietary Preference category of a meal
    public String getDietPref() {
        return dietPref;
    }

    // EFFECTS: Returns a score of the healthiness of a meal based on
    // calories, protein, and fat. The formula used is
    // (Protein*3) - Fat - (Calories/20)+40
    public int mealScore() {
        return (getProtein() * 3) - getFat() - (getCalories() / 20) + 40;
    }

    // Effects: Gives a rating to meal the based on the mealScore.
    // if mealscore >= 100, then rating = incredible
    // if mealScore >= 80, then rating = very good
    // if 50 <= mealScore < 80, then rating = good
    // if 30 <= mealScore < 50, then rating = poor
    // if 0 <= mealScore < 30, then rating = very poor
    // if mealScore < 0, then rating = terrible
    public String mealRating() {
        int score = mealScore();

        if (score >= 100) {
            return "incredible";
        } else if (score >= 80) {
            return "very good";
        } else if (score >= 50) {
            return "good";
        } else if (score >= 30) {
            return "poor";
        } else if (score >= 0) {
            return "very poor";
        } else {
            return "terrible";
        }

    }
}
