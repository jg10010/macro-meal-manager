package ui;

import javax.swing.JFrame;

import model.MealPlan;

public class MealPlanGUI extends JFrame {

   private MealPlan mealPlan;

    // Constructs main window
	// effects: sets up window in which MealPlan will be displayed
	public MealPlanGUI() {
         super("Meal Plan");  // sets the window title

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        pack();             
        setVisible(true);   
    }

    public static void main(String[] args) {
        new MealPlanGUI();
    }
}
