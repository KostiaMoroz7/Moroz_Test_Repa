import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        MenuRobots menuRobots = new MenuRobots();
        List<Robot> robotMassive = menuRobots.createAndPrintRobots();
        String enteredLetter;
        do {
            for (int i = 0; i < robotMassive.size(); i++) {
                MenuRobots.printRobotsMenu(robotMassive.get(i).getRobotName());
                enteredLetter = MenuRobots.getValueFromConsoleString();
                if (Robot.isEnd(enteredLetter, robotMassive) == true) {
                    System.exit(0);
                }
                if (robotMassive.get(i).getMainString().contains(enteredLetter) & (enteredLetter.length() == 1)) {
                    Robot.checkDamage(robotMassive.get(i), enteredLetter);
                    if (robotMassive.get(i).getHealthPoint() == 0) {
                        menuRobots.removeAndPrintDeadRobotInfo(robotMassive);
                        i--;
                    }
                    continue;
                } else {
                    Robot.checkDamage(robotMassive.get(i), Robot.checkWrongEnters(robotMassive.get(i).getMainString(), enteredLetter, robotMassive));
                    if (robotMassive.get(i).getHealthPoint() == 0) {
                        menuRobots.removeAndPrintDeadRobotInfo(robotMassive);
                        i--;
                    }
                    continue;
                }
            }
            if (robotMassive.size() > 1) {
                MenuRobots.printRobotInfo(robotMassive);
            }
        } while (robotMassive.size() > 1);
        menuRobots.printWinnerInfo(robotMassive);
    }
}

