import java.util.Scanner;

public class Menu {

    public static String getValueFromConsoleString() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.next();
        } catch (Exception e) {
            return "0";
        }
    }

    public static int getValueFromConsoleInt() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            return 0;
        }
    }
}
