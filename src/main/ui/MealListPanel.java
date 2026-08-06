package ui;

import model.Meal;
import model.MealPlan;

import javax.swing.*;
import java.awt.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport

// Represents the panel in the Meal Plan GUI that displays the meals
// currently stored in a MealPlan and allows the displayed list to be
// refreshed or updated.
public class MealListPanel extends JPanel {

    private MealPlan mealPlan;
    private DefaultListModel<String> listModel;
    private JList<String> mealList;

    // EFFECTS: constructs panel that displays all meals in mealPlan
    public MealListPanel(MealPlan mealPlan) {
        this.mealPlan = mealPlan;

        setLayout(new BorderLayout());
        listModel = new DefaultListModel<>();
        mealList = new JList<>(listModel);

        add(new JScrollPane(mealList), BorderLayout.CENTER);
        refresh();
    }

    // MODIFIES: this
    // EFFECTS: refreshes the displayed list of meals
    public void refresh() {
        listModel.clear();
        for (Meal m : mealPlan.getMeals()) {
            listModel.addElement(m.getName() + " | " + m.getCalories() + " cal | "
                    + m.getProtein() + "p | " + m.getFat() + "f | " + m.getDietPref());
        }
    }

    public void setModel(DefaultListModel<String> model) {
        mealList.setModel(model);
    }

    public void updateMealPlan(MealPlan newMealPlan) {
        this.mealPlan = newMealPlan;
    }

    public void restoreOriginalModel() {
        mealList.setModel(listModel);
    }

}
