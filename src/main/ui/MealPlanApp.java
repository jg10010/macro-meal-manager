package ui;

import java.util.Scanner;

import model.MealPlan;

public class MealPlanApp {
private MealPlan mealPlan;
private Scanner input;



//MODIFIES: this
//EFFECTS: Initializes app, creates new mealPlan and scanner, and 
//starts up app
public MealPlanApp() {
    mealPlan = new MealPlan();
    input = new Scanner(System.in);
    runApp();
}

//EFFECTS: Reads user input,
//calls methods based on user input,
//manages menu loop, and quits when q is pressed.
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






//EFFECTS: Prints menu options to console
public void printMenu() {
    System.out.println("Select an option");
    System.out.println("a -> add a meal");
    System.out.println("r -> remove a meal");
    System.out.println("v -> view meals");
    System.out.println("f -> filter meals");
    System.out.println("d -> check daily macro requirements");
    System.out.println("q -> quit");

}
//EFFECTS: Processes user input and calls corresponding method
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
    } else  {
        System.out.println("Invalid selection");
    }
}

public void doAddMeal() {

}

public void doRemoveMeal() {

}

public void doViewMeals() {

}

public void doFilterMeals() {

}

public void doDailyMacro() {


}

}
