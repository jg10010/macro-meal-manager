package ui;

import model.MealPlan;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.BorderLayout;

public class MealPlanGUI extends JFrame {

    private MealPlan mealPlan;
    private NutritionGraphPanel graphPanel;

    public MealPlanGUI() {
        super("Meal Plan");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mealPlan = new MealPlan();

        graphPanel = new NutritionGraphPanel(mealPlan);
        add(graphPanel, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MealPlanGUI();
    }
}
