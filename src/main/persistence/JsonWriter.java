// Citation: This class is based on the JsonWriter example 
// provided in the CPSC 210 WorkRoom sample project.

package persistence;

import model.Meal;
import model.MealPlan;
import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;

// Represents a writer that writes JSON representation of MealPlan to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file
    // cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of MealPlan to file
    public void write(MealPlan mp) {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        for (Meal m : mp.getMeals()) {
            JSONObject mealJson = new JSONObject();
            mealJson.put("name", m.getName());
            mealJson.put("calories", m.getCalories());
            mealJson.put("protein", m.getProtein());
            mealJson.put("fat", m.getFat());
            mealJson.put("dietPref", m.getDietPref());
            jsonArray.put(mealJson);
        }

        json.put("meals", jsonArray);
        saveToFile(json.toString(TAB));
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }

}
