import java.util.ArrayList;
import java.util.List;

public class CreateRobot {

    private String robotName;
    private int healthPoint = 100;
    private String mainString = "qweasdzxc";

    private String defence = "tygh";
    private StringBuffer damageString;
    private String damageLetters;
    private String enteredLetterWithDamageRobot = " ";

    private StringBuffer defenceString;

    private String defenceLetters;

    private String enteredDefenceLetter = " ";

    public CreateRobot(String externalRobotName) {
        robotName = externalRobotName;
        damageString = new StringBuffer(mainString);
        for (int i = 0; i < 4; i++) {
            int randomIndex = (int) (Math.random() * (9 - i));
            damageString.delete(randomIndex, randomIndex + 1);
        }
        String enteredLetterWithDamageRobot = " ";
        defenceString = new StringBuffer(defence);
        for (int i = 0; i < 2; i++) {
            int randomIndex = (int) (Math.random() * (4 - i));
            defenceString.delete(randomIndex, randomIndex + 1);
        }
        String enteredDefenceLetter = " ";
    }

    public String getRobotName() {
        return robotName;
    }


    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public String getDamageLetters() {
        return damageString.toString();
    }

    private void setDamageLetters(String damageLetters) {
        this.damageLetters = damageLetters;
    }

    public String getDefenceLetters() {
        return defenceString.toString();
    }

    public void setDefenceLetters(String defenceLetters) {
        this.defenceLetters = defenceLetters;
    }

    public String getMainString() {
        return mainString;
    }

    public String getEnteredLetterWithDamageRobot() {
        return enteredLetterWithDamageRobot;
    }

    public void setEnteredLetterWithDamageRobot(String enteredLetterWithDamageRobot) {
        this.enteredLetterWithDamageRobot = enteredLetterWithDamageRobot;
    }

    public String getEnteredDefenceLetter() {
        return enteredDefenceLetter;
    }

    public void setEnteredDefenceLetter(String enteredDefenceLetter) {
        this.enteredDefenceLetter = enteredDefenceLetter;
    }

    private static void increaseHealth(CreateRobot damagedRobot, String compareLetter) {
        damagedRobot.setHealthPoint(damagedRobot.getHealthPoint() - 20);
        damagedRobot.setEnteredLetterWithDamageRobot(damagedRobot.getEnteredLetterWithDamageRobot() + compareLetter);
        System.out.println("Right on target! Good job. The health of " + "\"" + damagedRobot.getRobotName() + "\"" + " Robot" + " decreased for - 20 points");
    }

    public static int checkDamage(CreateRobot damagedRobot, String compareLetter) {
        String enter;
        if (damagedRobot.getEnteredLetterWithDamageRobot().contains(compareLetter.toLowerCase())) {
            System.out.println("Key is not active");
            return damagedRobot.getHealthPoint();
        }
        if (damagedRobot.getDamageLetters().contains(compareLetter.toLowerCase())) {
            if (damagedRobot.getEnteredDefenceLetter().length() > 2){
                System.out.println("There are no more keys for protection");
                CreateRobot.increaseHealth(damagedRobot, compareLetter);
                return damagedRobot.getHealthPoint();
            }
            System.out.println("Select letter to defence from TYGH.");
            enter = MenuRobots.getValueFromConsoleString();
            if (damagedRobot.getEnteredDefenceLetter().contains(enter)) {
                System.out.println("Protection key isn't active");
                CreateRobot.increaseHealth(damagedRobot, compareLetter);
                return damagedRobot.getHealthPoint();
            }
            if (damagedRobot.getDefenceLetters().contains(enter.toLowerCase())) {
                System.out.println("The damage did not pass, the protection is activated");
                damagedRobot.setEnteredDefenceLetter(damagedRobot.getEnteredDefenceLetter() + enter);
                return damagedRobot.getHealthPoint();
            } else {
                System.out.println("Protection isn't activated");
            }
            CreateRobot.increaseHealth(damagedRobot, compareLetter);
            return damagedRobot.getHealthPoint();
        } else {
            System.out.println("Key does no damage");
            return damagedRobot.getHealthPoint();
        }
    }


}
