import java.util.Scanner;
import java.util.Random;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static Character player = new Character(1, 1, 100);
    static Character enemyWeak = new Character("Skelett", 10, 5, 100);
    static Character enemyNormal = new Character("Oger", 25, 15, 200);
    static Character enemyStrong = new Character("Drache", 50, 30, 500);

    // Einleitung
    public static void einleitung() throws InterruptedException {

        System.out.println("\nDas Ziel des Spiels ist es den Drache zu besiegen.");
        Thread.sleep(1000);
        System.out.println("Wie ist mein Name?");
        player.setName(sc.nextLine());
        Thread.sleep(1000);

        // Godmode
        if (player.getName().equals("Godmode")) {
            Thread.sleep(500);
            System.out.println("\nWoher wusstest du, dass es einen Godmode gibt?");
            Thread.sleep(1000);
            System.out.print("Godmode wird aktiviert, bitte warten");
            dotText();
            System.out.println("\n\nStärke, Verteidigung und Hunger auf 255 gesetzt, Lebenspunkte auf 9999 gesetzt.\n");
            Thread.sleep(1000);
            ASCII.javaRitter();
            Thread.sleep(1500);
            mainMenu();

            player.setStr(255);
            player.setDef(255);
            player.setHp(9999);
            player.setHunger(255);
        }

        // Twigolu
        else if (player.getName().equals("Twigolu")) {
            System.out.println("\nOh, ich heiße wohl wie deine Katzen?!\n");
            Thread.sleep(1000);
            ASCII.Katze();
            Thread.sleep(1500);
            mainMenu();
        }

        // Cyberpunk
        else if (player.getName().equals("V")) {
            System.out.println("Cyberpunk?\n");
            Thread.sleep(1000);
            ASCII.Cyberpunk();
            Thread.sleep(1500);
            System.out.println("\nHallo! Ich bin ein Javagotchiritter und Ich heiße " + player.getName() + ". Trainiere mich und koche für mich, damit ich stärker werde!\n\n");
            mainMenu();
        }
        else {
            System.out.println("\nHallo! Ich bin ein Javagotchiritter und Ich heiße " + player.getName() + ". Trainiere mich und koche für mich, damit ich stärker werde!\n\n");
            Thread.sleep(1000);
            ASCII.javaRitter();
            Thread.sleep(1500);
            mainMenu();
        }
    }

    // Hauptmenü
    public static void mainMenu() throws InterruptedException {
        System.out.println("\n Was möchstest du tun?\n");
        Thread.sleep(1000);
        System.out.println("\"a\" für Attribute prüfen");
        Thread.sleep(200);
        System.out.println("\"h\" für Hungerlevel prüfen");
        Thread.sleep(200);
        System.out.println("\"e\" für Essen kochen");
        Thread.sleep(200);
        System.out.println("\"t\" für trainieren");
        Thread.sleep(200);
        System.out.println("\"k\" für kämpfen");
        Thread.sleep(200);
        System.out.println("\"p\" für Punktestand abfragen");
        Thread.sleep(200);
        System.out.println("\"n\" für Programmneustart");
        Thread.sleep(200);
        System.out.println("\"q\" für Programm beenden\n");
    }

    // Attribute abfragen
    public static void att() {
        System.out.println("\nMeine Attribute sind:");
        System.out.println("Stärke: " + player.getStr());
        System.out.println("Verteidigung: " + player.getDef());
        System.out.println("Lebenspunkte: " + player.getHp());
        System.out.println("Alter: " + player.getAge());
        System.out.println("Mein Name ist: " + player.getName() + "\n");
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
                player.setAge(newAge);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nAlter wurde auf " + player.getAge() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("h")) {
                System.out.println("\nAuf welchen Wert soll der Hunger geändert werden?\n");
                int newHunger = sc.nextInt();
                player.setHunger(newHunger);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nHunger wurde auf " + player.getHunger() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("s")) {
                System.out.println("\nAuf welchen Wert soll die Stärke geändert werden?\n");
                int newStr = sc.nextInt();
                player.setStr(newStr);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nStärke wurde auf " + player.getStr() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("v")) {
                System.out.println("\nAuf welchen Wert soll die Verteidigung geändert werden?\n");
                int newDef = sc.nextInt();
                player.setDef(newDef);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nVerteidigung wurde auf " + player.getDef() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("l")) {
                System.out.println("\nAuf welchen Wert soll die Lebenspunkte geändert werden?\n");
                int newHp = sc.nextInt();
                player.setHp(newHp);
                sc.nextLine();
                Thread.sleep(200);
                System.out.println("\nLebenspunkte wurde auf " + player.getHp() + " gesetzt\n");
                Thread.sleep(200);
            }
            else if (Main.input.equals("alle")) {
                System.out.println("\nAuf welchen Wert sollen alle Attribute geändert werden?\n");
                int newVariable = sc.nextInt();
                sc.nextLine();

                player.setStr(newVariable);
                player.setDef(newVariable);
                player.setHp(newVariable);
                player.setHunger(newVariable);
            }
            else if (Main.input.equals("q")) {
                System.out.print("\nIns Hauptmenü zurückkehren, bitte warten");
                dotText();
                Game.mainMenu();
                break;
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
        Game.dotText();
        player.setAge(player.getAge() + 1);

        Random rng = new Random();

        int strIncrease = rng.nextInt(1, 4);         // 1 bis 3
        int defIncrease = rng.nextInt(1, 3);         // 1 bis 2
        int hpIncrease = rng.nextInt(10, 21);        // 10 bis 20
        int hungerDecrease = rng.nextInt(-4, 0);     // -1 bis -4

        player.setStr(player.getStr() + strIncrease);
        player.setDef(player.getDef() + defIncrease);
        player.setHp(player.getHp() + hpIncrease);
        player.setHunger(player.getHunger() + hungerDecrease);

        player.setPunkte(player.getPunkte() + strIncrease + defIncrease + hpIncrease);

        Thread.sleep(1000);
        System.out.println("\nIch bin um ein Jahr gealtert. Ich bin nun " + player.getAge() + " Jahre alt.");
        Thread.sleep(500);
        System.out.println("\nIch bin stärker geworden!\n");
        Thread.sleep(200);
        System.out.println("Stärke: +" + strIncrease + " = " + player.getStr());
        System.out.println("Verteidigung: +" + defIncrease + " = " + player.getDef());
        System.out.println("Lebenspunkte: +" + hpIncrease + " = " + player.getHp());
        System.out.println("Ich bin hungrig! " + hungerDecrease + " = " + player.getHunger() + "\n");
    }

    // Kampflogik
    public static void kampf() throws InterruptedException {

        String input;

        System.out.println("\ngegen welchen Gegner möchtest du kämpfen?\n");
        Thread.sleep(1000);
        System.out.println("\"1\" für Skelett");
        Thread.sleep(500);
        System.out.println("\"2\" für Oger");
        Thread.sleep(500);
        System.out.println("\"3\" für Drache");
        Thread.sleep(500);
        System.out.println("\"q\" zurück in Hauptmenü\n");
        input = sc.nextLine();

        if (input.equals("1")) {
            System.out.print(enemyWeak.getName() + " ausgewählt, starte Kampf");
            dotText();
            System.out.println("\n");
            System.out.println("Kampf beginnt gegen " + enemyWeak.getName() + "\n");
            Thread.sleep(500);

            while (true) {

                System.out.printf("Du greifst " + enemyWeak.getName() + " an und verursacht %s Schaden.\n", player.getStr() - enemyWeak.getDef());
                player.attack(enemyWeak);
                Thread.sleep(500);
                System.out.println(enemyWeak.getName() + " Lebenspunkte " + enemyWeak.getHp() + "\n");

                if (enemyWeak.getHp() <= 0) {
                    System.out.println(enemyWeak.getName() + " wurde besiegt!\n");
                    return;
                }
                System.out.printf(enemyWeak.getName() + " greift dich an und verursacht %s Schaden.\n", enemyWeak.getStr() - player.getDef());
                enemyWeak.attack(player);
                Thread.sleep(500);
                System.out.println("Deine Lebenspunkte " + player.getHp());

                if (player.getHp() <= 0) {
                    System.out.println("Du wurdest besiegt!\n");
                    return;
                }
            }
        }
        if (input.equals("2")) {
            System.out.print(enemyNormal.getName() + " ausgewählt, starte Kampf");
            dotText();
            System.out.println("\n");
            System.out.println("Kampf beginnt gegen " + enemyNormal.getName() + "\n");
            Thread.sleep(500);

            while (true) {

                System.out.printf("Du greifst " + enemyNormal.getName() + " an und verursacht %s Schaden.\n", player.getStr() - enemyWeak.getDef());
                player.attack(enemyNormal);
                Thread.sleep(500);
                System.out.println(enemyNormal.getName() + " Lebenspunkte " + enemyNormal.getHp() + "\n");

                if (enemyNormal.getHp() <= 0) {
                    System.out.println(enemyNormal.getName() + " wurde besiegt!\n");
                    return;
                }
                System.out.printf(enemyNormal.getName() + " greift dich an und verursacht %s Schaden.\n", enemyNormal.getStr() - player.getDef());
                enemyNormal.attack(player);
                Thread.sleep(500);
                System.out.println("Deine Lebenspunkte " + player.getHp());

                if (player.getHp() <= 0) {
                    System.out.println("Du wurdest besiegt!\n");
                    return;
                }
            }
        }
        if (input.equals("3")) {
            System.out.print(enemyStrong.getName() + " ausgewählt, starte Kampf");
            dotText();
            System.out.println("\n");
            System.out.println("Kampf beginnt gegen " + enemyStrong.getName() + "\n");
            Thread.sleep(500);

            while (true) {

                player.attack(enemyStrong);
                System.out.printf("Du greifst " + enemyStrong.getName() + " an und verursacht %s Schaden.\n", player.getStr() - enemyStrong.getDef());
                Thread.sleep(500);
                System.out.println(enemyStrong.getName() + " Lebenspunkte " + enemyStrong.getHp() + "\n");

                if (enemyStrong.getHp() <= 0) {
                    System.out.println(enemyStrong.getName() + " wurde besiegt!\n");
                    return;
                }
                System.out.printf(enemyStrong.getName() + " greift dich an und verursacht %s Schaden.\n", enemyStrong.getStr() - player.getDef());
                enemyStrong.attack(player);
                Thread.sleep(500);
                System.out.println("Deine Lebenspunkte " + player.getHp());

                if (player.getHp() <= 0) {
                    System.out.println("Du wurdest besiegt!\n");
                    return;
                }
            }
        }
            else if (input.equals("q")) {
            System.out.print("\nIns Hauptmenü zurückkehren, bitte warten");
            dotText();
            mainMenu();
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