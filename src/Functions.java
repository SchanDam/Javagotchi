import java.util.Scanner;

public class Functions {
    static Scanner sc = new Scanner(System.in);

    // Hauptmenü
    public static void mainMenu() throws InterruptedException {
        System.out.println("\n Was möchstest du tun?\n");
        Thread.sleep(500);
        System.out.println("\"a\" für Attribute prüfen");
        Thread.sleep(100);
        System.out.println("\"h\" für Hungerlevel prüfen");
        Thread.sleep(100);
        System.out.println("\"e\" für Essen kochen");
        Thread.sleep(100);
        System.out.println("\"t\" für trainieren");
        Thread.sleep(100);
        System.out.println("\"k\" für kämpfen");
        Thread.sleep(100);
        System.out.println("\"p\" für Punktestand abfragen");
        Thread.sleep(100);
        System.out.println("\"n\" für Programmneustart");
        Thread.sleep(100);
        System.out.println("\"q\" für Programm beenden\n");
    }

    // Attribute abfragen
    public static void att() {
        System.out.println("\nMeine Attribute sind:");
        System.out.println("Stärke: " + Main.att.getPlayerStr());
        System.out.println("Verteidigung: " + Main.att.getPlayerDef());
        System.out.println("Lebenspunkte: " + Main.att.getPlayerHp());
        System.out.println("Alter: " + Main.att.getAge());
        System.out.println("Mein Name ist: " + Main.att.getPlayerName() + "\n");
    }

    // Einleitung
    public static void einleitung() throws InterruptedException {

        System.out.println("\nDas Ziel des Spiels ist es 10 Jahre alt zu werden.");
        Thread.sleep(1000);
        System.out.println("Wie ist mein Name?");
        String newName = sc.nextLine();
        Main.att.setPlayerName(newName);

        // Godmode
        if (Main.att.getPlayerName().equals("Godmode")) {
            Thread.sleep(500);
            System.out.println("\nWoher wusstest du, dass es einen Godmode gibt?");
            Thread.sleep(1000);
            System.out.print("Godmode wird aktiviert, bitte warten");
            Functions.dotText();
            System.out.println("\n\nStärke, Verteidigung und Hunger auf 255 gesetzt, Lebenspunkte auf 9999 gesetzt.\n");
            Thread.sleep(1000);
            ASCII.javaRitter();
            Thread.sleep(1500);
            Functions.mainMenu();

            Main.att.setPlayerStr(255);
            Main.att.setPlayerDef(255);
            Main.att.setPlayerHp(9999);
            Main.att.setHunger(255);
        }

        // Twigolu
        else if (Main.att.getPlayerName().equals("Twigolu")) {
            System.out.println("\nOh, ich heiße wohl wie deine Katzen?!\n");
            Thread.sleep(1000);
            ASCII.Katze();
            Thread.sleep(1500);
            Functions.mainMenu();
        }

        // Cyberpunk
        else if (Main.att.getPlayerName().equals("V")) {
            System.out.println("Cyberpunk?\n");
            Thread.sleep(1000);
            ASCII.Cyberpunk();
            Thread.sleep(1500);
            Functions.mainMenu();
        }
        else {
            System.out.println("\nHallo! Ich bin ein Javagotchiritter und Ich heiße " + Main.att.getPlayerName() + ". Trainiere mich und koche für mich, damit ich stärker werde!\n\n");
            Thread.sleep(1000);
            ASCII.javaRitter();
            Thread.sleep(1500);
            Functions.mainMenu();
        }
    }

    // Debugmenü
    public static void debugMenu() throws InterruptedException {

        while (true) {

            System.out.println("\nWelchen Wert möchtest du bearbeiten?\n");
            Thread.sleep(500);
            System.out.println("\"a\" für Alter");
            Thread.sleep(100);
            System.out.println("\"h\" für Hunger");
            Thread.sleep(100);
            System.out.println("\"s\" für Stärke");
            Thread.sleep(100);
            System.out.println("\"v\" für Verteidigung");
            Thread.sleep(100);
            System.out.println("\"l\" für Lebenspunkte");
            Thread.sleep(100);
            System.out.println("\"alle\" für alle Werte (außer Alter)");
            Thread.sleep(100);
            System.out.println("\"q\" für Hauptmenü\n");

            Main.input = sc.nextLine();

            if (Main.input.equals("a")) {
                System.out.println("\nAuf welchen Wert soll das Alter geändert werden?\n");
                int newAge = sc.nextInt();
                Main.att.setAge(newAge);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nAlter wurde auf " + Main.att.getAge() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("h")) {
                System.out.println("\nAuf welchen Wert soll der Hunger geändert werden?\n");
                int newHunger = sc.nextInt();
                Main.att.setHunger(newHunger);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nHunger wurde auf " + Main.att.getHunger() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("s")) {
                System.out.println("\nAuf welchen Wert soll die Stärke geändert werden?\n");
                int newStr = sc.nextInt();
                Main.att.setPlayerStr(newStr);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nStärke wurde auf " + Main.att.getPlayerStr() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("v")) {
                System.out.println("\nAuf welchen Wert soll die Verteidigung geändert werden?\n");
                int newDef = sc.nextInt();
                Main.att.setPlayerDef(newDef);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nVerteidigung wurde auf " + Main.att.getPlayerDef() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("l")) {
                System.out.println("\nAuf welchen Wert soll die Lebenspunkte geändert werden?\n");
                int newHp = sc.nextInt();
                Main.att.setPlayerHp(newHp);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nLebenspunkte wurde auf " + Main.att.getPlayerHp() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("alle")) {
                System.out.println("\nAuf welchen Wert sollen alle Attribute (außer Alter) geändert werden?\n");
                int newVariable = sc.nextInt();
                sc.nextLine();

                Main.att.setPlayerStr(newVariable);
                Main.att.setPlayerDef(newVariable);
                Main.att.setPlayerHp(newVariable);
                Main.att.setHunger(newVariable);
            }
            else if (Main.input.equals("q")) {
                System.out.print("\nIns Hauptmenü zurückkehren, bitte warten");
                dotText();
                Functions.mainMenu();
                return;
            }
            else {
                System.out.println("ungültige Taste");
                debugMenu();
            }
        }
    }

    // dots verzögert ausgeben
    public static void dotText() throws InterruptedException {
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
    }
}