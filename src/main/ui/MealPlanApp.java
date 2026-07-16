package ui;

import java.util.Scanner;

import model.Meal;
import model.MealPlan;

public class MealPlanApp {
    private MealPlan mealPlan;
    private Scanner input;

    // MODIFIES: this
    // EFFECTS: Initializes app, creates new mealPlan and scanner, and
    // starts up app
    public MealPlanApp() {
        mealPlan = new MealPlan();
        input = new Scanner(System.in);

    }

    // EFFECTS: Reads user input,
    // calls methods based on user input,
    // manages menu loop, and quits when q is pressed.
    public void runApp() {
        boolean runLoop = true;

        while (runLoop) {
            printMenu();
            String command = input.next();
            if (command.equals("q")) {
                runLoop = false;
            } else {
                commandProcessor(command);
            }
        }
        System.out.println("Farewell");
    }

    // EFFECTS: Prints menu options to console
    public void printMenu() {
        System.out.println("Select an option");
        System.out.println("a -> add a meal");
        System.out.println("r -> remove a meal");
        System.out.println("v -> view meals");
        System.out.println("f -> filter meals");
        System.out.println("d -> check daily macro requirements");
        System.out.println("q -> quit");

    }

    // EFFECTS: Processes user input and calls corresponding method
    public void commandProcessor(String command) {
        if (command.equals("a")) {
            doAddMeal();
        } else if (command.equals("r")) {
            doRemoveMeal();
        } else if (command.equals("v")) {
            doViewMeals();
        } else if (command.equals("f")) {
            doFilterMeals();
        } else if (command.equals("d")) {
            doDailyMacro();
        } else {
            System.out.println("Invalid selection");
        }
    }

    // REQUIRES" Calories, Protein, Fat >=0
    // MODIFIES: this
    // EFFECTS: Add meal with name, calories, protein, fat, diet preference to
    // MealPlan
    public void doAddMeal() {
        System.out.println("Enter meal name");
        input.nextLine();
        String name = input.nextLine();

        System.out.println("Enter calories");
        int calories = input.nextInt();

        System.out.println("Enter protein");
        int protein = input.nextInt();

        System.out.println("Enter fat");
        int fat = input.nextInt();

        System.out.println("Enter Dietary Preference");
        input.nextLine();
        String dietPref = input.nextLine();

        Meal meal = new Meal(name, calories, protein, fat, dietPref);
        mealPlan.addMeal(meal);
    }

    // MODIFIES: this
    // EFFECTS: if present, removes meal with specified name from MealPlan.
    // if not present, returns meal not found
    public void doRemoveMeal() {
        System.out.println("Enter the name of meal to remove");
        input.nextLine();
        String name = input.nextLine();

        Boolean removed = mealPlan.removeMeal(name);

        if (removed) {
            System.out.println("Meal removed");
        } else {
            System.out.println("Meal not found");
        }
    }

    // EFFECTS: Prints all meals in MealPlan or message if empty
    public void doViewMeals() {
        if (mealPlan.getMeals().isEmpty()) {
            System.out.println("No meals in list");
            return;
        }
        for (Meal m : mealPlan.getMeals()) {
            System.out.println(m.getName());
        }
    }

    // EFFECTS: Prints meals with matching diet preference or message if none
    public void doFilterMeals() {
        System.out.println("Enter dietary preference to filter by");
        input.nextLine();
        String pref = input.nextLine();

        Boolean found = false;

        for (Meal m : mealPlan.getMeals()) {
            if (m.getDietPref().equals(pref)) {
                System.out.println(m.getName());
                found = true;
            }
            if (!found) {
                System.out.println("No meals found");
            }
        }
    }

    // REQUIRES: CalorieGoal, ProteinGoal, and FatGoal >= 0
    // EFFECTS: Produces true if daily macro goals have been fulfuiled,
    // false otherwise
    public void doDailyMacro() {
        System.out.println("Enter Calorie goal");
        int calorieGoal = input.nextInt();

        System.out.println("Enter Protein goal");
        int proteinGoal = input.nextInt();

        System.out.println("Enter Fat goal");
        int fatGoal = input.nextInt();

        boolean met = mealPlan.dailyMacroRequirements(calorieGoal, proteinGoal, fatGoal);

        if (met) {
            System.out.println("Daily Macro goals met");
        } else {
            System.out.println("Daily Macro goals not met");
        }
    }

}
