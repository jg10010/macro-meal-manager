# My Personal Project - Meal PLanner 

## Purpose of Project

The purpose of this project is to create an application that allows users to record and manage their diet. The application will include features that let users add meals and create a meal plan based on factors such as weight, age, and daily exercise needs. Users will also be able to filter meals by dietary preferences and use a tracker to see whether they have met their macro requirements.

This application is intended for users who need a reliable way to track their meals and macros accurately. One group of users who may benefit from this application is gym-goers, who often need to plan their meals carefully in order to meet specific protein and nutrition goals. This project is of interest to me because I am an avid *gym-goer*, and I want to be able to track my meals and create a meal plan accordingly.

## User Stories

- As a user, I want to be able to add a meal to my meal plan and specify its name, calories, and macronutrient information.

- As a user, I want to be able to view the list of meals in my meal plan.

- As a user, I want to be able to filter meals by dietary preferences such as vegetarian, vegan, or high-protein.

- As a user, I want to be able to track whether I have met my daily macro requirements.

- As a user, I want to be able to save the meal plan I created.

- As a user, I want to be able to reload the meal plan from a previous session.

## Instructions for End User

- You can view the panel that displays the meals that have already been added to the meal plan by looking at the left side of the application window, where the Meal List Panel shows all meals currently in your meal plan.

- You can generate the first required action related to the user story “adding multiple meals to a meal plan” by entering a meal’s name, calories, protein, fat, and dietary preference into the text fields in the center Action Panel, and then clicking the “Add Meal” button.

- You can generate the second required action related to the user story “adding multiple meals to a meal plan” by typing a dietary preference (e.g., “vegan”, “vegetarian”, “high-protein”) into the filter field in the Action Panel, and then clicking the “Filter by Diet” button to display only the meals that match that preference.
To return to the full list of meals, click “Show All Meals”.

- You can locate my visual component by looking at the right side of the application window, where the Nutrition Graph Panel displays a bar graph showing total calories, protein, and fat in your meal plan.

- You can save the state of my application by clicking “File” → “Save” in the menu bar at the top of the window. This writes your current meal plan to a JSON file.

- You can reload the state of my application by clicking “File” → “Load” in the menu bar. This loads your previously saved meal plan and updates all panels in the GUI.