// Citation: This class is based on the JsonReader example 
//provided in the CPSC 210 WorkRoom sample project.

package persistence;

import model.Meal;
import model.MealPlan;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads meal plans from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads MealPlan from file and returns it;
    // throws IOException if an error occurs reading data from file
    public MealPlan read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseMealPlan(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(contentBuilder::append);
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses MealPlan from JSON object and returns it
    private MealPlan parseMealPlan(JSONObject jsonObject) {
        MealPlan mp = new MealPlan();
        addMeals(mp, jsonObject);
        return mp;
    }

    // MODIFIES: mp
    // EFFECTS: parses meals from JSON object and adds them to MealPlan
    private void addMeals(MealPlan mp, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("meals");
        for (Object obj : jsonArray) {
            JSONObject nextMeal = (JSONObject) obj;
            addMeal(mp, nextMeal);
        }
    }

    // MODIFIES: mp
    // EFFECTS: parses meal from JSON object and adds it to MealPlan
    private void addMeal(MealPlan mp, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int calories = jsonObject.getInt("calories");
        int protein = jsonObject.getInt("protein");
        int fat = jsonObject.getInt("fat");
        String dietPref = jsonObject.getString("dietPref");

        Meal meal = new Meal(name, calories, protein, fat, dietPref);
        mp.addMeal(meal);
    }
}