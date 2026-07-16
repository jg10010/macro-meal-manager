package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMealPlan {
    private Meal m1;
    private Meal m2;
    private Meal m3;
    private MealPlan mealPlan;

    @BeforeEach
    public void runBefore() {
        mealPlan = new MealPlan();
        m1 = new Meal("Pasta", 400, 20, 20, "Vegetarian");
        m2 = new Meal("Chicken Burger", 700, 40, 60, "Meat");
        m3 = new Meal("Salad", 150, 5, 15, "Vegetarian");
    }

    @Test
    // EFFECT: Confirm mealPlan starts empty
    public void testConstructor() {
        assertTrue(mealPlan.getMeals().isEmpty());
    }

    // EFFECT: Test whether addMeal correctly adds meal correctly
    @Test
    public void testAddMeal() {

        mealPlan.addMeal(m1);
        assertEquals(1, mealPlan.getMeals().size());
        assertTrue(mealPlan.getMeals().contains(m1));
        mealPlan.addMeal(m2);
        assertEquals(2, mealPlan.getMeals().size());
        assertTrue(mealPlan.getMeals().contains(m2));
    }

    // MODIFIES: this
    // EFFECTS: Test succesful removal of meal to mealPlan when meal to
    // be removed is contained in mealPlan
    @Test
    public void testRemoveMealSuccess() {
        mealPlan.addMeal(m1);
        assertTrue(mealPlan.removeMeal(m1));
        assertEquals(0, mealPlan.getMeals().size());
        assertFalse(mealPlan.getMeals().contains(m1));
    }

    // EFFECTS: Test failed removal of meal when meal to be removed is not
    // not contained in mealPlan
    @Test
    public void testRemoveMealFail() {
        assertFalse(mealPlan.removeMeal(m1));
        assertEquals(0, mealPlan.getMeals().size());
    }

    // EFFECTS: Tests whether getMeals gets the correct list of meals from
    // mealPlan
    @Test
    public void testGetMeals() {
        assertTrue(mealPlan.getMeals().isEmpty());
        mealPlan.addMeal(m1);
        assertTrue(mealPlan.getMeals().contains(m1));
        assertEquals(1, mealPlan.getMeals().size());
    }

    // EFFECTSs: Confirms that correct sum of the calories of all meals
    // in mealPlan is returned
    @Test
    public void testTotalCalories() {
        // empty mealPlan case
        assertEquals(0, mealPlan.totalCalories());
        // Case with m1, m2, and m3 in mealPlan
        mealPlan.addMeal(m1); // 400
        mealPlan.addMeal(m2); // 750
        mealPlan.addMeal(m3); // 150
        assertEquals(1250, mealPlan.totalCalories());
    }

    // EFFECTSs: Confirms that correct sum of the protein of all meals
    // in mealPlan is returned
    @Test
    public void testTotalProtein() {
        // empty mealPlan case
        assertEquals(0, mealPlan.totalProtein());
        // Case with m1, m2, and m3 in mealPlan
        mealPlan.addMeal(m1); // 20
        mealPlan.addMeal(m2); // 40
        mealPlan.addMeal(m3); // 5
        assertEquals(65, mealPlan.totalProtein());
    }

    // EFFECTSs: Confirms that correct sum of the protein of all meals
    // in mealPlan is returned
    @Test
    public void testTotalFat() {
        // empty mealPlan case
        assertEquals(0, mealPlan.totalFat());
        // Case with m1, m2, and m3 in mealPlan
        mealPlan.addMeal(m1); // 20
        mealPlan.addMeal(m2); // 60
        mealPlan.addMeal(m3); // 15
        assertEquals(95, mealPlan.totalFat());
    }

    // EFFECT: Return new list made of meals that satisfy diet preference
    @Test
    public void filterDietaryPref() {

        mealPlan.addMeal(m1); // Vegetarian
        mealPlan.addMeal(m2); // Meat
        mealPlan.addMeal(m3); // Vegetarian

        List<Meal> vegMeals = mealPlan.filterDietaryPref("Vegetarian");

        assertEquals(2, vegMeals.size());
        assertTrue(vegMeals.contains(m1));
        assertFalse(vegMeals.contains(m2));
        assertTrue(vegMeals.contains(m3));

        // empty case, no meals matching diet preference are found
        List<Meal> veganMeals = mealPlan.filterDietaryPref("Vegan");
        assertTrue(veganMeals.isEmpty());
    }

    // EFFECTS: Tests if dailyMcaroRequirements returns true if all three totals
    // exceed or equal goals in mealPlan, else returns false
    @Test
    public void testdailyMacroRequirements() {

        mealPlan.addMeal(m1); // 400, 20, 20
        mealPlan.addMeal(m2); // 700, 40, 60
        mealPlan.addMeal(m3); // 150, 5, 15
        // exceeds case
        assertTrue(mealPlan.dailyMacroRequirements(1, 1, 1));
        // equals case
        assertTrue(mealPlan.dailyMacroRequirements(1250, 65, 95));
        // less than case
        assertFalse(mealPlan.dailyMacroRequirements(2000, 200, 200));
    }

}
