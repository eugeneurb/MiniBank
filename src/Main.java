import UI.ConsoleInterface;
import exception.ExitAppException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsoleInterface ui = new ConsoleInterface(new Scanner(System.in));
        try{
            ui.loginLoop();
            ui.mainLoop();
        }catch (ExitAppException e){
            System.out.println("Спасибо, всего доброго!");
        }

    }
}
