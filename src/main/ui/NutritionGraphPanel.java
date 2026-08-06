package ui;

import model.MealPlan;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport


// Represents a graphical panel that displays nutritional information from a MealPlan.
// The panel visualizes total calories, protein, and fat as scaled vertical bars.
// The graph updates to reflect the current values stored in the associated MealPlan.
public class NutritionGraphPanel extends JPanel {

    private MealPlan mealPlan;

    // REQUIRES: mealPlan is not null
    // MODIFIES: this
    // EFFECTS: constructs a NutritionGraphPanel that will draw a bar graph
    // based on the totals in mealPlan; sets preferred panel size
    public NutritionGraphPanel(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
        setPreferredSize(new Dimension(300, 300));
    }

    // REQUIRES: g is not null
    // MODIFIES: this
    // EFFECTS: draws three vertical bars representing total calories,
    // total protein, and total fat in mealPlan; bar heights are
    // scaled for display; labels are drawn under each bar
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

    // MODIFIES: this
    // EFFECTS: repaints the bar graph to reflect updated mealPlan totals
    public void repaintGraph() {
        repaint();
    }
    

    // MODIFIES: this
    // EFFECTS: updates mealPlan
    public void updateMealPlan(MealPlan newMealPlan) {
        this.mealPlan = newMealPlan;
    }

}
