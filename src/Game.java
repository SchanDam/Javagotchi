import java.util.Scanner;
import java.util.Random;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static Random rng = new Random();

    static Character player = new Character(1, 1, 100, 0);
    static Character enemyWeak = new Character("Skelett", 10, 5, 100);
    static Character enemyNormal = new Character("Oger", 25, 15, 200);
    static Character enemyStrong = new Character("Drache", 35, 25, 300);
    static Character enemyUnbeatable = new Character("Sephiroth", 177, 167, 3264);

    static String input;

    // Einleitung
    public static void einleitung() throws InterruptedException {

        System.out.printf("%nDas Ziel des Spiels ist es, den Drachen zu besiegen.%n");
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
        System.out.println("\"e\" für Essen kochen");
        Thread.sleep(200);
        System.out.println("\"t\" für trainieren");
        Thread.sleep(200);
        System.out.println("\"k\" für kämpfen");
        Thread.sleep(200);
        System.out.println("\"h\" für Lebenspunkte heilen");
        Thread.sleep(200);
        System.out.println("\"p\" für Punktestand abfragen");
        Thread.sleep(200);
        System.out.println("\"n\" für Programmneustart");
        Thread.sleep(200);
        System.out.printf("\"q\" für Programm beenden%n");
    }

    // Attribute abfragen
    public static void printAttributes() throws InterruptedException {
        System.out.printf("%nMeine Attribute sind:%n");
        Thread.sleep(500);
        System.out.printf("Stärke: %d%n", player.getStr());
        Thread.sleep(200);
        System.out.printf("Verteidigung: %d%n", player.getDef());
        Thread.sleep(200);
        System.out.printf("Lebenspunkte: %d%n", player.getHp());
        Thread.sleep(200);
        System.out.printf("Sättigungslevel: %d%n", player.getHunger());
        Thread.sleep(200);
        System.out.printf("Alter: %d%n", player.getAge());
        Thread.sleep(200);
        System.out.printf("Mein Name ist: %s%n", player.getName());
        Thread.sleep(200);
        System.out.printf("Ich habe %d Gold!%n", player.getGold());
        Thread.sleep(200);
    }

    // Debugmenü
    public static void debugMenu() throws InterruptedException {

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
            System.out.println("\"g\" für Goldmünzen");
            Thread.sleep(200);
            System.out.println("\"alle\" für alle Werte (außer Alter)");
            Thread.sleep(200);
            System.out.printf("\"q\" für Hauptmenü%n%n");

            input = sc.nextLine();

            switch (input) {
                case "a":
                    System.out.printf("\nAuf welchen Wert soll das Alter geändert werden?%n");
                    int newAge = sc.nextInt();
                    player.setAge(newAge);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nAlter wurde auf %d gesetzt%n", player.getAge());
                    Thread.sleep(500);
                    break;
                case "h":
                    System.out.printf("%nAuf welchen Wert soll das Sättigungslevel geändert werden?%n");
                    int newHunger = sc.nextInt();
                    player.setHunger(newHunger);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nHunger wurde auf %d gesetzt%n", player.getHunger());
                    Thread.sleep(500);
                    break;
                case "s":
                    System.out.printf("%nAuf welchen Wert soll die Stärke geändert werden?%n");
                    int newStr = sc.nextInt();
                    player.setStr(newStr);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nStärke wurde auf %d gesetzt%n", player.getStr());
                    Thread.sleep(500);
                    break;
                case "v":
                    System.out.printf("%nAuf welchen Wert soll die Verteidigung geändert werden?%n");
                    int newDef = sc.nextInt();
                    player.setDef(newDef);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nVerteidigung wurde auf %d gesetzt%n", player.getDef());
                    Thread.sleep(500);
                    break;
                case "l":
                    System.out.printf("%nAuf welchen Wert soll die Lebenspunkte geändert werden?%n");
                    int newHp = sc.nextInt();
                    player.setHp(newHp);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nLebenspunkte wurden auf %d gesetzt%n", player.getHp());
                    Thread.sleep(500);
                    break;
                case "g":
                    System.out.printf("%nWie viele Goldmünzen möchtest du erhalten?%n");
                    int newGold = sc.nextInt();
                    player.setGold(newGold);
                    sc.nextLine();
                    Thread.sleep(200);
                    System.out.printf("%nDu hast %d Goldmünzen erhalten%n", player.getGold());
                    Thread.sleep(500);
                    break;
                case "alle":
                    System.out.printf("%nAuf welchen Wert sollen alle Attribute geändert werden?%n");
                    int newVariable = sc.nextInt();
                    sc.nextLine();

                    player.setStr(newVariable);
                    player.setDef(newVariable);
                    player.setHp(newVariable);
                    player.setGold(newVariable);
                    player.setHunger(newVariable);
                    Thread.sleep(200);
                    System.out.printf("%nAlle Werte wurden auf %d gesetzt%n", newVariable);
                    Thread.sleep(500);
                    break;
                case "q":
                    System.out.printf("%nIns Hauptmenü zurückkehren, bitte warten");
                    dotText();
                    System.out.println();
                    Thread.sleep(500);
                    return;
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
        dotText();
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
        System.out.printf("Ich bin hungrig! Neuer Sättigungswert: %d%n", player.getHunger());
    }

    // Kampflogik
    public static void kampf() throws InterruptedException {

        System.out.printf("%nGegen welchen Gegner möchtest du kämpfen?%n%n");
        Thread.sleep(1000);
        System.out.println("\"1\" für Skelett");
        Thread.sleep(500);
        System.out.println("\"2\" für Oger");
        Thread.sleep(500);
        System.out.println("\"3\" für Drache");
        Thread.sleep(500);
        System.out.printf("\"q\" zurück in Hauptmenü%n");
        input = sc.nextLine();

        switch (input) {
            case "1" -> {
                System.out.printf("%n%s ausgewählt, starte Kampf", enemyWeak.getName());
                dotText();
                System.out.printf("%nKampf beginnt gegen %s\n", enemyWeak.getName());
                Thread.sleep(500);

                while (true) {

                    player.attack(enemyWeak);
                    System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyWeak.getName(), player.calcDamage(enemyWeak));
                    Thread.sleep(500);
                    System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyWeak.getName(), enemyWeak.getHp());

                    if (enemyWeak.getHp() <= 0) {
                        System.out.printf("%s wurde besiegt!%n%n", enemyWeak.getName());
                        Thread.sleep(200);
                        System.out.println("Du hast 10 Gold und 100 Punkte erhalten!");
                        player.setGold(player.getGold() + 10);
                        player.setPunkte(player.getPunkte() + 100);
                        return;
                    }
                    if (player.getHp() > 1) {
                        System.out.printf("%n**Nächste Runde**%n");
                        Thread.sleep(500);
                        System.out.println("Was soll ich tun?");
                        Thread.sleep(200);
                        System.out.println("\"1\" für angreifen");
                        System.out.println("\"2\" für blocken");
                        System.out.println("\"3\" für flüchten");
                        input = sc.nextLine();

                        switch (input) {
                            case "1" -> {
                            }
                            case "2" -> {
                                enemyWeak.calcDamage(/2);
                            }
                        }
                    }
                    enemyWeak.attack(player);
                    System.out.printf("%n%s greift dich an und verursacht %s Schaden.%n", enemyWeak.getName(), enemyWeak.calcDamage(player));
                    Thread.sleep(500);
                    System.out.printf("Deine Lebenspunkte: %s%n", player.getHp());

                    if (player.getHp() <= 0) {
                        System.out.println("%nDu wurdest besiegt!%n");
                        Thread.sleep(500);
                        System.out.println("Dein Sättigungslevel ist um 3 gesunken.");
                        player.setHunger(player.getHunger() - 3);
                        return;
                    }
                }
            }
            case "2" -> {
                System.out.printf("%n%s ausgewählt, starte Kampf", enemyNormal.getName());
                dotText();
                System.out.printf("%nKampf beginnt gegen %s%n", enemyNormal.getName());
                Thread.sleep(500);

                while (true) {

                    player.attack(enemyNormal);
                    System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyNormal.getName(), player.calcDamage(enemyNormal));
                    Thread.sleep(500);
                    System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyNormal.getName(), enemyNormal.getHp());

                    if (enemyNormal.getHp() <= 0) {
                        System.out.printf("%s wurde besiegt!%n%n", enemyNormal.getName());
                        Thread.sleep(200);
                        System.out.println("Du hast 20 Gold und 200 Punkte erhalten!");
                        player.setGold(player.getGold() + 20);
                        player.setPunkte(player.getPunkte() + 200);
                        return;
                    }
                    enemyNormal.attack(player);
                    System.out.printf("%n%s greift dich an und verursacht %s Schaden.%n", enemyNormal.getName(), enemyNormal.calcDamage(player));
                    Thread.sleep(500);
                    System.out.printf("Deine Lebenspunkte: %s%n", player.getHp());

                    if (player.getHp() <= 0) {
                        System.out.printf("%nDu wurdest besiegt!%n");
                        Thread.sleep(500);
                        System.out.println("Dein Sättigungslevel ist um 5 gesunken.");
                        player.setHunger(player.getHunger() - 5);
                        return;
                    }
                }
            }
            case "3" -> {
                System.out.printf("%n%s ausgewählt, starte Kampf", enemyStrong.getName());
                dotText();
                System.out.printf("%nKampf beginnt gegen %s%n", enemyStrong.getName());
                Thread.sleep(500);

                while (true) {

                    player.attack(enemyStrong);
                    System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyStrong.getName(), player.calcDamage(enemyStrong));
                    Thread.sleep(500);
                    System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyStrong.getName(), enemyStrong.getHp());

                    if (enemyStrong.getHp() <= 0) {
                        System.out.printf("%s wurde besiegt!%n%n", enemyStrong.getName());
                        Thread.sleep(200);
                        System.out.println("Du hast 50 Gold und 500 Punkte erhalten!");
                        player.setGold(player.getGold() + 50);
                        player.setPunkte(player.getPunkte() + 500);
                        return;
                    }
                    enemyStrong.attack(player);
                    System.out.printf("%n%s greift dich an und verursacht %s Schaden.%n", enemyStrong.getName(), enemyStrong.calcDamage(player));
                    Thread.sleep(500);
                    System.out.printf("Deine Lebenspunkte: %s%n", player.getHp());

                    if (player.getHp() <= 0) {
                        System.out.printf("%nDu wurdest besiegt!%n%n");
                        Thread.sleep(500);
                        System.out.println("Dein Sättigungslevel ist um 9 gesunken.");
                        player.setHunger(player.getHunger() - 9);
                        return;
                    }
                }
            }
            case "q" -> {
                System.out.printf("%nIns Hauptmenü zurückkehren, bitte warten");
                dotText();
                System.out.println();
            }
        }
    }

    // heilen
    public static void heal() throws InterruptedException {
        while (true) {
            
        Thread.sleep(200);
        System.out.printf("%nEin Heiltrank kostet 5 Goldstücke, soll %s einen Trank trinken? (\"ja\" oder \"nein\")%n", player.getName());
        input = sc.nextLine();

            if (input.equals("ja")) {
                if (player.getHp() == player.getMaxHp()) {
                    Thread.sleep(200);
                    System.out.printf("%nDu hast bereits volle Lebenspunkte.");
                }
                if (player.getGold() > 4) {
                    player.setHp(player.getMaxHp());
                    player.setGold(player.getGold() - 5);
                    Thread.sleep(200);
                    System.out.printf("%nDu hast dich vollständig geheilt!%n");
                    Thread.sleep(500);
                    return;
                }
                else {
                    Thread.sleep(200);
                    System.out.printf("%nDu hast nicht genug Gold zum heilen!%n");
                }
                Thread.sleep(500);
                return;
            }
            else if (input.equals("nein")) {
                System.out.printf("%nWer nicht will, der hat schon.%n");
                Thread.sleep(500);
                System.out.println("he! *Hexenlachen*");
                Thread.sleep(500);
                System.out.println("he! *Hexenlachen*");
                Thread.sleep(500);
                System.out.println("he! *Hexenlachen*");
                Thread.sleep(1000);
                return;
            }
            else {
                System.out.printf("%nungültige Taste%n");
                Thread.sleep(300);
            }
        }
    }

    // Attribute resetten
    public static void reset() {
        Game.player.setStr(1);
        Game.player.setDef(1);
        Game.player.setHp(100);
        Game.player.setGold(0);
        Game.player.setAge(1);
        Game.player.setPunkte(0);
        Game.player.setHunger(5);
    }

    // dots verzögert ausgeben
    public static void dotText() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(500);
        }
    }
}