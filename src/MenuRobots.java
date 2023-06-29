import java.util.ArrayList;
import java.util.List;

public class MenuRobots extends Menu {

    private int WorkingRobot;

    public List<Robot> createAndPrintRobots() {
        int numberOfRobots;
        String robotname;
        System.out.println("");
        System.out.println("Enter the number of robots to start a game: ");
        numberOfRobots = Menu.getValueFromConsoleInt();
        do {
            if (numberOfRobots == 0) {
                System.out.println("Wrong Enters. Please enter only a number");
                numberOfRobots = Menu.getValueFromConsoleInt();
                continue;
            }
            if (numberOfRobots < 2 || numberOfRobots > 5) {
                System.out.println("You can create from 2 to 5 robots. Please select a number from 2 to 5");
                numberOfRobots = Menu.getValueFromConsoleInt();
                continue;
            }
        } while (numberOfRobots < 2 || numberOfRobots > 5);
        Robot[] robots = new Robot[numberOfRobots];
        List<Robot> robotList = new ArrayList<>();
        for (int i = 0; i <= numberOfRobots - 1; i++) {
            System.out.println("");
            System.out.println("Enter the Robot №" + (i + 1) + " name: ");
            robotname = MenuRobots.getValueFromConsoleString();
            robots[i] = new Robot(robotname);
            robotList.add(robots[i]);
        }
        return robotList;
    }

    public static void printRobotsMenu(String robotName) {
        System.out.println("");
        System.out.println("For exit press P.");
        System.out.println("Time to shoot " + robotName);
        System.out.println("Choose one key from QWEASDZXC.");
    }

    public static void printRobotInfo(List<Robot> robotMassive) {
        for (int i = 0; i < robotMassive.size(); i++) {
            System.out.println("----------------------------------------------------------");
            System.out.println("Robot name: " + robotMassive.get(i).getRobotName() + ", HealthPoints: " + robotMassive.get(i).getHealthPoint());
            System.out.println("----------------------------------------------------------");
        }

    }

    public void printWinnerInfo(List<Robot> robotMassive) {
        for (int i = 0; i < robotMassive.size(); i++) {
            if (robotMassive.get(i).getHealthPoint() == 0) {
                System.out.println("Robot Name: " + robotMassive.get(i).getRobotName() + ", Result: You Died. Maybe better luck next time!");
            } else {
                System.out.println("Robot Name: " + robotMassive.get(i).getRobotName() + ", Result: Your Won. Congratulations!!!");
            }
        }
    }

    public void removeAndPrintDeadRobotInfo(List<Robot> robotMassive) {
        for (int i = 0; i < robotMassive.size(); i++) {
            if (robotMassive.get(i).getHealthPoint() == 0) {
                System.out.println("----------------------------------------------------------");
                System.out.println("Robot name: " + robotMassive.get(i).getRobotName() + ", Result: You Died. Maybe better luck next time!");
                System.out.println("----------------------------------------------------------");
                robotMassive.remove(i);
            } else {
                continue;
            }
            System.out.println("These are robots that are still alive: ");
            for (int j = 0; j < robotMassive.size(); j++) {
                System.out.println("----------------------------------------------------------");
                System.out.println("Robot name: " + robotMassive.get(j).getRobotName());
                System.out.println("----------------------------------------------------------");
            }
        }
    }


}



