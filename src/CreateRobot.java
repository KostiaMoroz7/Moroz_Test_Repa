import java.util.ArrayList;
import java.util.List;

public class CreateRobot {

    private String robotName;
    private int healthPoint = 100;
    private String mainString = "qweasdzxc";
    private StringBuffer damageString;
    private String damageLetters;

    private String enteredLetterWithDamageRobot = " ";


    public CreateRobot(String externalRobotName) {
        robotName = externalRobotName;
        damageString = new StringBuffer(mainString);
        for (int i = 0; i < 4; i++) {
            int randomIndex = (int) (Math.random() * (9 - i));
            damageString.delete(randomIndex, randomIndex + 1);
            String enteredLetterWithDamageRobot = " ";
        }
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

    public String getMainString() {
        return mainString;
    }

    public String getEnteredLetterWithDamageRobot() {
        return enteredLetterWithDamageRobot;
    }

    public void setEnteredLetterWithDamageRobot(String enteredLetterWithDamageRobot) {
        this.enteredLetterWithDamageRobot = enteredLetterWithDamageRobot;
    }

    public static int checkDamage(CreateRobot damagedRobot, String compareLetter) {
        if (damagedRobot.getEnteredLetterWithDamageRobot().contains(compareLetter.toLowerCase())) {
            System.out.println("Key is not active");
            return damagedRobot.getHealthPoint();
        }
        if (damagedRobot.getDamageLetters().contains(compareLetter.toLowerCase())) {
            damagedRobot.setHealthPoint(damagedRobot.getHealthPoint() - 20);
            damagedRobot.setEnteredLetterWithDamageRobot(damagedRobot.getEnteredLetterWithDamageRobot() + compareLetter);
            System.out.println("Right on target! Good job. The health of " + "\"" + damagedRobot.getRobotName() + "\"" + " Robot" + " decreased for - 20 points");
            return damagedRobot.getHealthPoint();
        } else {
            System.out.println("Key does no damage");
            return damagedRobot.getHealthPoint();
        }
    }


}
