import java.util.Scanner;
import java.util.Random;

public class Functions {
    static Scanner sc = new Scanner(System.in);
    public static Attribute att = new Attribute();

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
        System.out.println("Stärke: " + att.getPlayerStr());
        System.out.println("Verteidigung: " + att.getPlayerDef());
        System.out.println("Lebenspunkte: " + att.getPlayerHp());
        System.out.println("Alter: " + att.getAge());
        System.out.println("Mein Name ist: " + att.getPlayerName() + "\n");
    }

    // Einleitung
    public static void einleitung() throws InterruptedException {

        System.out.println("\nDas Ziel des Spiels ist es 10 Jahre alt zu werden.");
        Thread.sleep(1000);
        System.out.println("Wie ist mein Name?");
        String newName = sc.nextLine();
        att.setPlayerName(newName);

        // Godmode
        if (att.getPlayerName().equals("Godmode")) {
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

            att.setPlayerStr(255);
            att.setPlayerDef(255);
            att.setPlayerHp(9999);
            att.setHunger(255);
        }

        // Twigolu
        else if (att.getPlayerName().equals("Twigolu")) {
            System.out.println("\nOh, ich heiße wohl wie deine Katzen?!\n");
            Thread.sleep(1000);
            ASCII.Katze();
            Thread.sleep(1500);
            Functions.mainMenu();
        }

        // Cyberpunk
        else if (att.getPlayerName().equals("V")) {
            System.out.println("Cyberpunk?\n");
            Thread.sleep(1000);
            ASCII.Cyberpunk();
            Thread.sleep(1500);
            Functions.mainMenu();
        }
        else {
            System.out.println("\nHallo! Ich bin ein Javagotchiritter und Ich heiße " + att.getPlayerName() + ". Trainiere mich und koche für mich, damit ich stärker werde!\n\n");
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
                att.setAge(newAge);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nAlter wurde auf " + att.getAge() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("h")) {
                System.out.println("\nAuf welchen Wert soll der Hunger geändert werden?\n");
                int newHunger = sc.nextInt();
                att.setHunger(newHunger);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nHunger wurde auf " + att.getHunger() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("s")) {
                System.out.println("\nAuf welchen Wert soll die Stärke geändert werden?\n");
                int newStr = sc.nextInt();
                att.setPlayerStr(newStr);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nStärke wurde auf " + att.getPlayerStr() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("v")) {
                System.out.println("\nAuf welchen Wert soll die Verteidigung geändert werden?\n");
                int newDef = sc.nextInt();
                att.setPlayerDef(newDef);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nVerteidigung wurde auf " + att.getPlayerDef() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("l")) {
                System.out.println("\nAuf welchen Wert soll die Lebenspunkte geändert werden?\n");
                int newHp = sc.nextInt();
                att.setPlayerHp(newHp);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nLebenspunkte wurde auf " + att.getPlayerHp() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("alle")) {
                System.out.println("\nAuf welchen Wert sollen alle Attribute (außer Alter) geändert werden?\n");
                int newVariable = sc.nextInt();
                sc.nextLine();

                att.setPlayerStr(newVariable);
                att.setPlayerDef(newVariable);
                att.setPlayerHp(newVariable);
                att.setHunger(newVariable);
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

    // Training
    public static void training() throws InterruptedException {
        System.out.print("\nIch muss meine Fähigkeiten mit Schwert und Schild trainieren!\nEin Jahr vergeht");
        Functions.dotText();
        att.setAge(att.getAge() + 1);

        Random rng = new Random();

        int strIncrease = rng.nextInt(1, 4);         // 1 bis 3
        int defIncrease = rng.nextInt(1, 3);         // 1 bis 2
        int hpIncrease = rng.nextInt(10, 21);        // 10 bis 20
        int hungerDecrease = rng.nextInt(-4, 0);     // -1 bis -4

        att.setPlayerStr(att.getPlayerStr() + strIncrease);
        att.setPlayerDef(att.getPlayerDef() + defIncrease);
        att.setPlayerHp(att.getPlayerHp() + hpIncrease);
        att.setHunger(att.getHunger() + hungerDecrease);

        att.setPunkte(att.getPunkte() + strIncrease + defIncrease + hpIncrease);

        Thread.sleep(1000);
        System.out.println("\nIch bin um ein Jahr gealtert. Ich bin nun " + att.getAge() + " Jahre alt.");
        Thread.sleep(500);
        System.out.println("\nIch bin stärker geworden!\n");
        Thread.sleep(200);
        System.out.println("Stärke: +" + strIncrease + " = " + att.getPlayerStr());
        System.out.println("Verteidigung: +" + defIncrease + " = " + att.getPlayerDef());
        System.out.println("Lebenspunkte: +" + hpIncrease + " = " + att.getPlayerHp());
        System.out.println("Ich bin hungrig! " + hungerDecrease + " = " + att.getHunger() + "\n");
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