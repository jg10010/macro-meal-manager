package ui;

import model.MealPlan;
import persistence.JsonWriter;
import persistence.JsonReader;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


import java.awt.BorderLayout;

public class MealPlanGUI extends JFrame {

    private MealPlan mealPlan;
    private NutritionGraphPanel graphPanel;
    private static final String JSON_STORE = "./data/mealplan.json";
private JsonWriter jsonWriter;
private JsonReader jsonReader;


    public MealPlanGUI() {
        
        super("Meal Plan");
        jsonWriter = new JsonWriter(JSON_STORE);
jsonReader = new JsonReader(JSON_STORE);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mealPlan = new MealPlan();

        graphPanel = new NutritionGraphPanel(mealPlan);
        add(graphPanel, BorderLayout.EAST);
        setJMenuBar(createMenuBar());


        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new MealPlanGUI();
    }

    // REQUIRES: this MealPlanGUI has been constructed
// MODIFIES: this
// EFFECTS: returns a menu bar containing a File menu with Save and Load options.
//          Save writes the current mealPlan to JSON.
//          Load reads mealPlan from JSON and refreshes GUI panels.
private JMenuBar createMenuBar() {
    JMenuBar menuBar = new JMenuBar();

    JMenu fileMenu = new JMenu("File");

    JMenuItem saveItem = new JMenuItem("Save");
    JMenuItem loadItem = new JMenuItem("Load");

    saveItem.addActionListener(e -> saveMealPlan());
    loadItem.addActionListener(e -> loadMealPlan());

    fileMenu.add(saveItem);
    fileMenu.add(loadItem);

    menuBar.add(fileMenu);

    return menuBar;
}

// REQUIRES: jsonWriter has been initialized
// MODIFIES: this
// EFFECTS: saves the current mealPlan to JSON_STORE
private void saveMealPlan() {
    try {
        jsonWriter.open();
        jsonWriter.write(mealPlan);
        jsonWriter.close();
        JOptionPane.showMessageDialog(this, "Saved meal plan!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error saving meal plan.");
    }
}

// REQUIRES: jsonReader has been initialized
// MODIFIES: this
// EFFECTS: loads mealPlan from JSON_STORE and refreshes GUI panels
private void loadMealPlan() {
    try {
        mealPlan = jsonReader.read();

        // refresh GUI components
        graphPanel.repaintGraph();

        JOptionPane.showMessageDialog(this, "Loaded meal plan!");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error loading meal plan.");
    }
}


}
