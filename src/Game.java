import java.util.Scanner;
import java.util.Random;

public class Game {
    static Scanner sc = new Scanner(System.in);

    static Character player = new Character(10, 5, 100, 0);
    static Character enemyWeak = new Character("Skelett", 10, 5, 100);
    static Character enemyNormal = new Character("Oger", 25, 15, 200);
    static Character enemyStrong = new Character("Drache", 50, 30, 500);

    static Random rng = new Random();

    // Einleitung
    public static void einleitung() throws InterruptedException {

        System.out.printf("%nDas Ziel des Spiels ist es den Drache zu besiegen.%n");
        Thread.sleep(1000);
        System.out.println("Wie ist mein Name?");
        player.setName(sc.nextLine());
        Thread.sleep(1000);

        // Godmode
        switch (player.getName()) {
            case "Godmode" -> {
                Thread.sleep(500);
                System.out.printf("%nWoher wusstest du, dass es einen Godmode gibt?%n");
                Thread.sleep(1000);
                System.out.print("Godmode wird aktiviert, bitte warten");
                dotText();
                System.out.printf("%nStärke, Verteidigung und Hunger auf 255 gesetzt, Lebenspunkte auf 9999 gesetzt.%n%n");
                Thread.sleep(1000);
                ASCII.javaRitter();
                Thread.sleep(1500);
                System.out.printf("%nHallo! Ich bin ein Javagotchiritter und Ich heiße %s. Du musst mich nicht mehr trainieren, ich bin bereits ein GOTT!%n%n%n", player.getName());

                player.setStr(255);
                player.setDef(255);
                player.setHp(9999);
                player.setHunger(255);

                mainMenu();
            }

            // Twigolu
            case "Twigolu" -> {
                System.out.printf("%nOh, ich heiße wohl wie deine Katzen?!%n%n");
                Thread.sleep(1000);
                ASCII.Katze();
                Thread.sleep(1500);
                System.out.printf("%nHallo! Ich bin ein Javagotchiritter und Ich heiße %s. Trainiere mich und koche für mich, damit ich stärker werde!%n%n%n", player.getName());
                mainMenu();
            }

            // Cyberpunk
            case "V" -> {
                System.out.printf("Cyberpunk?%n%n");
                Thread.sleep(1000);
                ASCII.Cyberpunk();
                Thread.sleep(1500);
                System.out.printf("%nHallo! Ich bin ein Javagotchiritter und Ich heiße %s. Trainiere mich und koche für mich, damit ich stärker werde!%n%n%n", player.getName());
                mainMenu();
            }
            default -> {
                System.out.printf("%nHallo! Ich bin ein Javagotchiritter und Ich heiße %s. Trainiere mich und koche für mich, damit ich stärker werde!%n%n%n", player.getName());
                Thread.sleep(1000);
                ASCII.javaRitter();
                Thread.sleep(1500);
                mainMenu();
            }
        }
    }

    // Hauptmenü
    public static void mainMenu() throws InterruptedException {
        System.out.printf("\n Was möchstest du tun?%n%n");
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
        System.out.printf("\"q\" für Programm beenden%n");
    }

    // Attribute abfragen
    public static void printAttributes() {
        System.out.printf("%nMeine Attribute sind:%n");
        System.out.printf("Stärke: %d%n", player.getStr());
        System.out.printf("Verteidigung: %d%n", player.getDef());
        System.out.printf("Lebenspunkte: %d%n", player.getHp());
        System.out.printf("Alter: %d%n", player.getAge());
        System.out.printf("Mein Name ist: %s%n", player.getName());
        System.out.printf("Ich habe %d Gold!%n", player.getGold());
    }

    // Debugmenü
    public static void debugMenu() throws InterruptedException {

        label:
        while (true) {

            System.out.printf("%nWelchen Wert möchtest du bearbeiten?%n%n");
            Thread.sleep(500);
            System.out.println("\"a\" für Alter");
            Thread.sleep(200);
            System.out.println("\"h\" für Hunger");
            Thread.sleep(200);
            System.out.println("\"s\" für Stärke");
            Thread.sleep(200);
            System.out.println("\"v\" für Verteidigung");
            Thread.sleep(200);
            System.out.println("\"l\" für Lebenspunkte");
            Thread.sleep(200);
            System.out.println("\"alle\" für alle Werte (außer Alter)");
            Thread.sleep(200);
            System.out.printf("\"q\" für Hauptmenü%n%n");

            Main.input = sc.nextLine();

            switch (Main.input) {
                case "a":
                    System.out.printf("\nAuf welchen Wert soll das Alter geändert werden?%n%n");
                    int newAge = sc.nextInt();
                    player.setAge(newAge);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nAlter wurde auf %d gesetzt%n%n", player.getAge());
                    Thread.sleep(500);
                    break;
                case "h":
                    System.out.printf("%nAuf welchen Wert soll der Hunger geändert werden?%n%n");
                    int newHunger = sc.nextInt();
                    player.setHunger(newHunger);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nHunger wurde auf %d gesetzt%n%n", player.getHunger());
                    Thread.sleep(500);
                    break;
                case "s":
                    System.out.printf("%nAuf welchen Wert soll die Stärke geändert werden?%n%n");
                    int newStr = sc.nextInt();
                    player.setStr(newStr);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nStärke wurde auf %d gesetzt%n%n", player.getStr());
                    Thread.sleep(500);
                    break;
                case "v":
                    System.out.printf("%nAuf welchen Wert soll die Verteidigung geändert werden?%n%n");
                    int newDef = sc.nextInt();
                    player.setDef(newDef);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nVerteidigung wurde auf %d gesetzt%n%n", player.getDef());
                    Thread.sleep(500);
                    break;
                case "l":
                    System.out.printf("%nAuf welchen Wert soll die Lebenspunkte geändert werden?%n%n");
                    int newHp = sc.nextInt();
                    player.setHp(newHp);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nLebenspunkte wurde auf %d gesetzt%n%n", player.getHp());
                    Thread.sleep(500);
                    break;
                case "alle":
                    System.out.printf("%nAuf welchen Wert sollen alle Attribute geändert werden?%n%n");
                    int newVariable = sc.nextInt();
                    sc.nextLine();

                    player.setStr(newVariable);
                    player.setDef(newVariable);
                    player.setHp(newVariable);
                    player.setHunger(newVariable);
                    Thread.sleep(200);
                    System.out.printf("%nAlle Werte wurden auf %d gesetzt%n", newVariable);
                    Thread.sleep(500);
                    break;
                case "q":
                    System.out.printf("%nIns Hauptmenü zurückkehren, bitte warten");
                    dotText();
                    Thread.sleep(500);
                    break label;
                default:
                    System.out.println("ungültige Taste");
                    Thread.sleep(500);
                    break;
            }
        }
    }

    // Training
    public static void training() throws InterruptedException {
        System.out.printf("%nIch muss meine Fähigkeiten mit Schwert und Schild trainieren!%n");
        Thread.sleep(500);
        System.out.print("Ein Jahr vergeht");
        Game.dotText();
        player.setAge(player.getAge() + 1);

        int strIncrease = rng.nextInt(1, 5);         // 1 bis 4
        int defIncrease = rng.nextInt(1, 4);         // 1 bis 3
        int hpIncrease = rng.nextInt(15, 26);        // 15 bis 25
        int hungerDecrease = rng.nextInt(-4, 0);     // -1 bis -4

        player.setStr(player.getStr() + strIncrease);
        player.setDef(player.getDef() + defIncrease);
        player.setHp(player.getHp() + hpIncrease);
        player.setHunger(player.getHunger() + hungerDecrease);

        player.setPunkte(player.getPunkte() + strIncrease + defIncrease + hpIncrease);

        Thread.sleep(1000);
        System.out.printf("%nIch bin um ein Jahr gealtert. Ich bin nun %d Jahre alt.%n", player.getAge());
        Thread.sleep(500);
        System.out.printf("%nIch bin stärker geworden!%n");
        Thread.sleep(200);
        System.out.printf("Stärke: + %d = %d%n", strIncrease, player.getStr());
        System.out.printf("Verteidigung: + %d = %d%n", defIncrease, player.getDef());
        System.out.printf("Lebenspunkte: + %d = %d%n", hpIncrease, player.getHp());
        System.out.printf("Ich bin hungrig! %d = %d%n", hungerDecrease, player.getHunger());
    }

    // Kampflogik
    public static void kampf() throws InterruptedException {

        String input;

        System.out.printf("%ngegen welchen Gegner möchtest du kämpfen?%n%n");
        Thread.sleep(1000);
        System.out.println("\"1\" für Skelett");
        Thread.sleep(500);
        System.out.println("\"2\" für Oger");
        Thread.sleep(500);
        System.out.println("\"3\" für Drache");
        Thread.sleep(500);
        System.out.printf("\"q\" zurück in Hauptmenü%n");
        input = sc.nextLine();

        if (input.equals("1")) {
            System.out.printf("%s ausgewählt, starte Kampf", enemyWeak.getName());
            dotText();
            System.out.printf("Kampf beginnt gegen %s\n", enemyWeak.getName());
            Thread.sleep(500);

            while (true) {

                player.attack(enemyWeak);
                System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyWeak.getName(), player.calcDamage(enemyWeak));
                Thread.sleep(500);
                System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyWeak.getName(), enemyWeak.getHp());

                if (enemyWeak.getHp() <= 0) {
                    System.out.printf("%s wurde besiegt!%n%n", enemyWeak.getName());
                    Thread.sleep(200);
                    System.out.println("Du hast 100 Punkte erhalten!");
                    player.setPunkte(player.getPunkte() + 100);
                    return;
                }
                enemyWeak.attack(player);
                System.out.printf("%s greift dich an und verursacht %s Schaden.%n", enemyWeak.getName(), enemyWeak.calcDamage(player));
                Thread.sleep(500);
                System.out.printf("Deine Lebenspunkte: %s%n", player.getHp());

                if (player.getHp() <= 0) {
                    System.out.println("%nDu wurdest besiegt!%n");
                    player.setHunger(player.getHunger() - 3);
                    return;
                }
            }
        }
        if (input.equals("2")) {
            System.out.printf("%s ausgewählt, starte Kampf", enemyNormal.getName());
            dotText();
            System.out.printf("Kampf beginnt gegen %s%n", enemyNormal.getName());
            Thread.sleep(500);

            while (true) {

                player.attack(enemyNormal);
                System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyNormal.getName(), player.calcDamage(enemyNormal));
                Thread.sleep(500);
                System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyNormal.getName(), enemyNormal.getHp());

                if (enemyNormal.getHp() <= 0) {
                    System.out.printf("%s wurde besiegt!%n%n", enemyNormal.getName());
                    Thread.sleep(200);
                    System.out.println("Du hast 200 Punkte erhalten!");
                    player.setPunkte(player.getPunkte() + 200);
                    return;
                }
                enemyNormal.attack(player);
                System.out.printf("%s greift dich an und verursacht %s Schaden.%n", enemyNormal.getName(), enemyNormal.calcDamage(player));
                Thread.sleep(500);
                System.out.printf("Deine Lebenspunkte: %s%n", player.getHp());

                if (player.getHp() <= 0) {
                    System.out.println("%nDu wurdest besiegt!%n");
                    player.setHunger(player.getHunger() - 5);
                    return;
                }
            }
        }
        if (input.equals("3")) {
            System.out.printf("%s ausgewählt, starte Kampf", enemyStrong.getName());
            dotText();
            System.out.printf("Kampf beginnt gegen %s%n", enemyStrong.getName());
            Thread.sleep(500);

            while (true) {

                player.attack(enemyStrong);
                System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyStrong.getName(), player.calcDamage(enemyStrong));
                Thread.sleep(500);
                System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyStrong.getName(), enemyStrong.getHp());

                if (enemyStrong.getHp() <= 0) {
                    System.out.printf("%s wurde besiegt!%n%n", enemyStrong.getName());
                    Thread.sleep(200);
                    System.out.println("Du hast 500 Punkte erhalten!");
                    player.setPunkte(player.getPunkte() + 500);
                    return;
                }
                enemyStrong.attack(player);
                System.out.printf("%s greift dich an und verursacht %s Schaden.%n", enemyStrong.getName(), enemyStrong.calcDamage(player));
                Thread.sleep(500);
                System.out.printf("Deine Lebenspunkte: %s%n", player.getHp());

                if (player.getHp() <= 0) {
                    System.out.printf("%nDu wurdest besiegt!%n%n");
                    player.setHunger(player.getHunger() - 9);
                    return;
                }
            }
        }
        if (input.equals("q")) {
            System.out.print("%nIns Hauptmenü zurückkehren, bitte warten");
            dotText();
        }
    }

    // heilen
    public static void heal() throws InterruptedException {
        System.out.println("Ein Heiltrank kostet 5 Goldstücke, möchstest du einen? (\"ja\" oder \"nein\"");

        while (true) {
            if (Main.input.equals("ja")) {
                if (player.getGold() >= 5) {
                    player.setHp(player.getMaxHp());
                    player.setGold(player.getGold() - 5);
                    System.out.println("Du hast dich vollständig geheilt!");
                } else {
                    System.out.println("Nicht genug Gold zum Heilen!");
                }
            } else if (Main.input.equals("nein")) {
                System.out.print("Wer nicht will, der hat schon. He he he");
                dotText();
                return;
            }
        }
    }


    // Attribute resetten
    public static void reset() {
        Game.player.setStr(1);
        Game.player.setDef(1);
        Game.player.setHp(100);
        Game.player.setGold(5);
        Game.player.setAge(1);
        Game.player.setPunkte(0);
        Game.player.setHunger(5);
    }

    // dots verzögert ausgeben
    public static void dotText() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.println(".");
            Thread.sleep(500);
        }
    }
}