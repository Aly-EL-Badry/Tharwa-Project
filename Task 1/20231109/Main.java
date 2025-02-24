import java.util.ArrayList;
import Workers.Manger.Manger;
import Workers.Normal.Junior.Junior;
import Workers.Normal.Normal;
import Workers.Normal.Senior.Senior;
import Board.Board;

public class Main {

    public static void main(String[] args) {

        // Initialize manager list and add a default manager
        ArrayList<Manger> mangers = new ArrayList<>();
        mangers.add(new Manger("Aly", 20000, "General", "aly", "11114"));

        // Initialize lists for Juniors and Seniors
        ArrayList<Junior> juniors = new ArrayList<>();
        ArrayList<Senior> seniors = new ArrayList<>();

        // Create the board with the existing worker lists
        Board board = new Board(juniors, mangers, seniors);

        // Main menu loop for user interaction
        while (true) {
            int menuChoice = Normal.getValidChoice(
                    new String[]{"Manager", "Senior", "Junior", "Exit"},
                    "# ==== Welcome to Workers Management System ==== #"
            );

            // Navigate based on user choice
            if (menuChoice == 0)
                board.manage();
            else if (menuChoice == 1)
                board.seniorWork();
            else if (menuChoice == 2)
                board.juniorWork();
            else if (menuChoice == 3)
                break;
        }

        System.out.println("\nThanks For Using Our Program");
    }
}
