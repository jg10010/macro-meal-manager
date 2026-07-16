package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMeal {

    private Meal meal;
    
    @BeforeEach
    public void runBefore() {
    meal = new Meal("Pasta", 400, 20, 30, "Vegetarian");
    }



    //EFFECTS: Tests getters and constructor
    @Test
    void constructorAndGettersTest() {
        assertEquals("Pasta", meal.getName());
        assertEquals(400, meal.getCalories());
        assertEquals(20, meal.getProtein());
        assertEquals(30, meal.getFat());
        assertEquals("Vegetarian", meal.getDietPref());
    }
    
    //Effects: Tests whether healthScore()
    //matches the correctly computed healthscore
    @Test
    public void testmealScore() {
    // Correctly computed score is
    // Protein*3 -Fat-(Calories/20)+40
    //20*3-30-400/20+40
    //healthscore = 50
        assertEquals(50, meal.mealScore());
    }
}
