package ui;

import model.Meal;
import model.MealPlan;

import javax.swing.*;
import java.awt.*;

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
}
