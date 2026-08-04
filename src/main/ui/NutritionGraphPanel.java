package ui;

import model.MealPlan;
import model.Meal;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class NutritionGraphPanel extends JPanel {

    private MealPlan mealPlan;

    public NutritionGraphPanel(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
        setPreferredSize(new Dimension(300, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int cal = mealPlan.totalCalories();
        int protein = mealPlan.totalProtein();
        int fat = mealPlan.totalFat();

        int calHeight = cal / 5;
        int proteinHeight = protein * 5;
        int fatHeight = fat * 5;

        // draw bars
        g.setColor(Color.RED);
        g.fillRect(60, 250 - calHeight, 40, calHeight);

        g.setColor(Color.BLUE);
        g.fillRect(120, 250 - proteinHeight, 40, proteinHeight);

        g.setColor(Color.GREEN);
        g.fillRect(180, 250 - fatHeight, 40, fatHeight);

        // labels
        g.setColor(Color.BLACK);
        g.drawString("Calories", 55, 270);
        g.drawString("Protein", 120, 270);
        g.drawString("Fat", 190, 270);
    }

    public void repaintGraph() {
        repaint();
    }
}
