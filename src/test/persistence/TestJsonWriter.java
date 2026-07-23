package persistence;

import model.Meal;
import model.MealPlan;
import org.junit.jupiter.api.Test;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
class JsonWriterTest {

    // Strategy: write data to a file, then read it back using JsonReader
    // and verify the MealPlan is identical.

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyMealPlan() {
        try {
            MealPlan mp = new MealPlan();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyMealPlan.json");
            writer.open();
            writer.write(mp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyMealPlan.json");
            mp = reader.read();
            assertEquals(0, mp.getMeals().size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralMealPlan() {
        try {
            MealPlan mp = new MealPlan();
            mp.addMeal(new Meal("Pasta", 400, 20, 10, "vegetarian"));
            mp.addMeal(new Meal("Salmon", 700, 40, 30, "high-protein"));

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralMealPlan.json");
            writer.open();
            writer.write(mp);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralMealPlan.json");
            mp = reader.read();

            assertEquals(2, mp.getMeals().size());

            Meal m1 = mp.getMeals().get(0);
            assertEquals("Pasta", m1.getName());
            assertEquals(400, m1.getCalories());
            assertEquals(20, m1.getProtein());
            assertEquals(10, m1.getFat());
            assertEquals("vegetarian", m1.getDietPref());

            Meal m2 = mp.getMeals().get(1);
            assertEquals("Salmon", m2.getName());
            assertEquals(700, m2.getCalories());
            assertEquals(40, m2.getProtein());
            assertEquals(30, m2.getFat());
            assertEquals("high-protein", m2.getDietPref());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}

