package persistence;

import model.Meal;
import model.MealPlan;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExcludeFromJacocoGeneratedReport
public class TestJsonReader {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            MealPlan mp = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyMealPlan() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyMealPlan.json");
        try {
            MealPlan mp = reader.read();
            assertEquals(0, mp.getMeals().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralMealPlan() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralMealPlan.json");
        try {
            MealPlan mp = reader.read();
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
            fail("Couldn't read from file");
        }
    }

}
