package Panels;
/**
 * Interface representing a Panel in the application.
 * A Panel defines the structure for displaying a menu and handling user interaction.
 */
public interface Panel {

   /**
    * Displays the menu of the panel and handles user input for selection.
    * Implementing classes must provide the specific menu options and logic for handling user choices.
    */
   public void ViewMenu();
}
