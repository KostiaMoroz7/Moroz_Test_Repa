import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Robot extends CreateRobot {
    public Robot(String externalRobotName) {
        super(externalRobotName);
    }

    public static boolean isEnd(String enteredLetter, List<Robot> robotMassive) {
        boolean gameIsEnd = false;
        if (enteredLetter.equalsIgnoreCase("p")) {
            gameIsEnd = true;
            System.out.println("Game Over. GoodBye!!!");
            MenuRobots.printRobotInfo(robotMassive);
            return gameIsEnd;
        }
        return gameIsEnd;
    }

    public static String checkWrongEnters(String compareString, String letter, List<Robot> robotMassive) {
        boolean isWrong = false;
        do {
            if (Robot.isEnd(letter, robotMassive)) {
                System.exit(0);
            }
            if (compareString.contains(letter.toLowerCase()) & (letter.length() == 1)) {
                return letter;
            } else {
                System.out.println(letter + " - Wrong Enters. Use only one key from QWEASDZXC keys");
                isWrong = true;
                letter = MenuRobots.getValueFromConsoleString();
            }
        } while (isWrong == true);
        return letter;
    }

    public static Robot[] removeDeadRobot( Robot[] robotMassive) {
        List test = new ArrayList<>();
        test.toArray();
        for (int i = 0; i < robotMassive.length; i++) {

        }
        return robotMassive;
    }


}
