package ui;

import model.Meal;
import model.MealPlan;

import javax.swing.*;
import java.awt.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport

// Represents the panel of user controls for interacting with a MealPlan,
// including adding meals, filtering meals by dietary preference, and
// updating the meal list and nutrition graph displayed in the GUI.
public class ActionPanel extends JPanel {

    private MealPlan mealPlan;
    private MealListPanel mealListPanel;
    private NutritionGraphPanel graphPanel;

    private JTextField nameField;
    private JTextField calField;
    private JTextField proteinField;
    private JTextField fatField;
    private JTextField dietField;

    private JTextField filterField;

    private JButton addButton;
    private JButton filterButton;
    private JButton showAllButton;

    // REQUIRES: mealPlan, mealListPanel, graphPanel are not null
    // MODIFIES: this
    // EFFECTS: constructs an ActionPanel with controls for adding and filtering
    // meals
    public ActionPanel(MealPlan mealPlan, MealListPanel mealListPanel, NutritionGraphPanel graphPanel) {
        this.mealPlan = mealPlan;
        this.mealListPanel = mealListPanel;
        this.graphPanel = graphPanel;

        setLayout(new GridLayout(0, 1));

        createInputFields();
        createButtons();
        layoutComponents();

    }

    // MODIFIES: this
    // EFFECTS: initializes all text fields used for adding and filtering meals
    private void createInputFields() {
        nameField = new JTextField(10);
        calField = new JTextField(5);
        proteinField = new JTextField(5);
        fatField = new JTextField(5);
        dietField = new JTextField(10);
        filterField = new JTextField(10);
    }

    // MODIFIES: this
    // EFFECTS: creates buttons and attaches action listeners
    private void createButtons() {
        addButton = new JButton("Add Meal");
        filterButton = new JButton("Filter by Diet");
        showAllButton = new JButton("Show All Meals");

        addButton.addActionListener(e -> addMeal());
        filterButton.addActionListener(e -> filterMeals());
        showAllButton.addActionListener(e -> {
            mealListPanel.restoreOriginalModel();
            mealListPanel.refresh();
        });

    }

    // MODIFIES: this
    // EFFECTS: adds all components to the panel in the correct order
    private void layoutComponents() {
        add(showAllButton);

        add(new JLabel("Name:"));
        add(nameField);

        add(new JLabel("Calories:"));
        add(calField);

        add(new JLabel("Protein:"));
        add(proteinField);

        add(new JLabel("Fat:"));
        add(fatField);

        add(new JLabel("Diet Pref:"));
        add(dietField);
        add(addButton);

        add(new JLabel("Filter Diet Pref:"));
        add(filterField);
        add(filterButton);
    }

    // REQUIRES: all text fields contain valid input
    // MODIFIES: mealPlan, mealListPanel, graphPanel
    // EFFECTS: adds a new meal to mealPlan and refreshes GUI
    private void addMeal() {
        try {
            String name = nameField.getText();
            int cal = Integer.parseInt(calField.getText());
            int protein = Integer.parseInt(proteinField.getText());
            int fat = Integer.parseInt(fatField.getText());
            String diet = dietField.getText();

            Meal m = new Meal(name, cal, protein, fat, diet);
            mealPlan.addMeal(m);

            mealListPanel.refresh();
            graphPanel.repaintGraph();

            JOptionPane.showMessageDialog(this, "Meal added!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid input.");
        }
    }

    // REQUIRES: filterField contains a non-null string
    // MODIFIES: mealListPanel
    // EFFECTS: displays only meals matching the diet preference
    private void filterMeals() {
        String pref = filterField.getText();
        java.util.List<Meal> filtered = mealPlan.filterDietaryPref(pref);

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Meal m : filtered) {
            model.addElement(
                    m.getName() + " | " + m.getCalories() + " cal | "
                            + m.getProtein() + "p | " + m.getFat() + "f");

        }

        mealListPanel.setModel(model);
    }

    // REQUIRES: newMealPlan is not null
    // MODIFIES: this
    // EFFECTS: updates this panel to use the newly loaded MealPlan
    public void updateMealPlan(MealPlan newMealPlan) {
        this.mealPlan = newMealPlan;
    }
}
