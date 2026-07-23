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
        return null; // stub
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null; // stub
    }

    // EFFECTS: parses MealPlan from JSON object and returns it
    private MealPlan parseMealPlan(JSONObject jsonObject) {
        return null; // stub
    }

    // MODIFIES: mp
    // EFFECTS: parses meals from JSON object and adds them to MealPlan
    private void addMeals(MealPlan mp, JSONObject jsonObject) {

        // stub
    }

    // MODIFIES: mp
    // EFFECTS: parses meal from JSON object and adds it to MealPlan
    private void addMeal(MealPlan mp, JSONObject jsonObject) {

        // stub
    }
}