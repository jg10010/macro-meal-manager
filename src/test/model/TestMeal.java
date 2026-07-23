package model;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport

public class TestMeal {

    private Meal meal;

    @BeforeEach
    public void runBefore() {
        meal = new Meal("Pasta", 400, 20, 30, "Vegetarian");
    }

    // EFFECTS: Tests getters and constructor
    @Test
    void constructorAndGettersTest() {
        assertEquals("Pasta", meal.getName());
        assertEquals(400, meal.getCalories());
        assertEquals(20, meal.getProtein());
        assertEquals(30, meal.getFat());
        assertEquals("Vegetarian", meal.getDietPref());
    }

    // Effects: Tests whether healthScore()
    // matches the correctly computed healthscore
    @Test
    public void testmealScore() {
        // Correctly computed score is
        // Protein*3 -Fat-(Calories/20)+40
        // 20*3-30-400/20+40
        // healthscore = 50
        assertEquals(50, meal.mealScore());
    }

    // EFFECTS: Tests whether a meal rating score >= 100 results in incredible
    @Test
    public void testmealRatingIncredible() {
        Meal m = new Meal(null, 0, 30, 0, null);
        // then mealRating = 30*3-0-0+40=130>100
        assertEquals("incredible", m.mealRating());

        // boundary case since mealrating =60+40 =100
        Meal m1 = new Meal(null, 0, 20, 0, null);
        assertEquals("incredible", m1.mealRating());
    }

    // EFFECTS: Tests whether a meal rating score between 80 and 100 results in very
    // good
    @Test
    public void testmealRatingVeryGood() {
        Meal m = new Meal(null, 0, 15, 0, null);
        // then mealRating = 15*3-0-0+40=85
        assertEquals("very good", m.mealRating());

        // boundary case mealrating = 80
        Meal m1 = new Meal(null, 0, 20, 20, null);
        assertEquals("very good", m1.mealRating());
    }

    @Test
    public void testmealRatingGood() {
        Meal m = new Meal(null, 0, 10, 0, null);
        // then mealRating = 10*3-0-0+40=60
        assertEquals("good", m.mealRating());

        // boundary case mealrating = 50
        Meal m1 = new Meal(null, 0, 20, 50, null);
        assertEquals("good", m1.mealRating());
    }

    @Test
    public void testmealRatingPoor() {
        Meal m = new Meal(null, 0, 1, 0, null);
        // then mealRating = 1*3-0-0+40=43
        assertEquals("poor", m.mealRating());

        // boundary case mealrating = 30
        Meal m1 = new Meal(null, 0, 20, 70, null);
        assertEquals("poor", m1.mealRating());
    }

    @Test
    public void testmealRatingVeryPoor() {
        Meal m = new Meal(null, 0, 1, 20, null);
        // then mealRating = 1*3-20-0+40=23
        assertEquals("very poor", m.mealRating());

        // boundary case mealrating = 0
        Meal m1 = new Meal(null, 0, 0, 40, null);
        assertEquals("very poor", m1.mealRating());
    }

    @Test
    public void testmealRatingTerrible() {
        Meal m = new Meal(null, 0, 0, 60, null);
        // then mealRating = 0*3-60-0+40= -20
        assertEquals("terrible", m.mealRating());
    }

}
