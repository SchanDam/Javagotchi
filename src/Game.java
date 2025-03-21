import java.util.Scanner;
import java.util.Random;

@SuppressWarnings("PointlessBooleanExpression")
public class Game {
    static Scanner sc = new Scanner(System.in);
    static Random rng = new Random();
    static Sounds output = new Sounds();

    static Character player = new Character(50, 5, 100, 5);
    static Character enemyWeak = new Character("Skelett", 10, 5, 100);
    static Character enemyNormal = new Character("Oger", 25, 15, 200);
    static Character enemyStrong = new Character("Drache", 35, 25, 300);
    static Character enemyUnbeatable = new Character("Sephiroth", 177, 167, 3264);

    static String input;
    static boolean running = true;

    // Einleitung
    public static void einleitung() throws InterruptedException {

        Utils.souf("%nDas Ziel des Spiels ist es, den Drachen zu besiegen.%n");
        Thread.sleep(1000);
        System.out.println("Wie ist mein Name?");
        player.setName(Utils.getSoundInput());
        Thread.sleep(1000);
        System.out.println("\u001B[31mDas ist roter Text\u001B[0m");
        System.out.println("\u001B[32mDas ist grüner Text\u001B[0m");
        System.out.println("\u001B[34mDas ist blauer Text\u001B[0m");
        // Godmode
        switch (player.getName()) {
            case "Godmode" -> {
                Thread.sleep(500);
                System.out.printf("%nWoher wusstest du, dass es einen Godmode gibt?%n");
                Thread.sleep(1000);
                System.out.print("Godmode wird aktiviert, bitte warten");
                Utils.dotText();
                System.out.printf("%nStärke, Verteidigung und Hunger auf 255 gesetzt, Lebenspunkte auf 9999 gesetzt.%n%n");
                Thread.sleep(1000);
                ASCII.javaRitter();
                Thread.sleep(1500);
                System.out.printf("%nHallo! Ich bin ein Javagotchiritter und Ich heiße %s. Du musst mich nicht mehr trainieren, ich bin bereits ein GOTT!%n%n%n", player.getName());

                player.setStr(255);
                player.setDef(255);
                player.setHp(9999);
                player.setHunger(255);
                //mainMenu();
            }

            // Twigolu
            case "Twigolu" -> {
                System.out.printf("%nOh, ich heiße wohl wie deine Katzen?!%n%n");
                Thread.sleep(1000);
                ASCII.gatos();
                Thread.sleep(1500);
                System.out.printf("%nHallo! Ich bin ein Javagotchiritter und Ich heiße %s. Trainiere mich und koche für mich, damit ich stärker werde!%n%n%n", player.getName());
                mainMenu();
            }

            // Cyberpunk
            case "V" -> {
                System.out.printf("Cyberpunk?%n%n");
                Thread.sleep(1000);
                ASCII.cyberpunk();
                Thread.sleep(1500);
                System.out.printf("%nHallo! Ich bin ein Javagotchiritter und Ich heiße %s. Trainiere mich und koche für mich, damit ich stärker werde!%n%n%n", player.getName());
                mainMenu();
            }

            // Cloud
            case "Cloud Strife" -> {
                System.out.println("Eine gute Wahl! Das Bustersword wird jeden Gegner zerschmettern!");
                Thread.sleep(1000);
                ASCII.cloud();
                Thread.sleep(1500);
                System.out.println("Cloud hat gesteigerte Attribute:");
                player.setStr(20);
                player.setDef(16);
                player.setHp(314);
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

    // Training
    public static void training() throws InterruptedException {
        System.out.printf("%nIch muss meine Fähigkeiten mit Schwert und Schild trainieren!%n");
        Thread.sleep(500);
        System.out.print("Ein Jahr vergeht");
        Utils.dotText();
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
        System.out.printf("%nGegen welchen Gegner soll %s kämpfen?%n", player.getName());
        //Thread.sleep(800);
        System.out.println("\"1\" für Skelett");
        //Thread.sleep(300);
        System.out.println("\"2\" für Oger");
        //Thread.sleep(300);
        System.out.println("\"3\" für Drache");
        //Thread.sleep(300);
        System.out.printf("\"q\" zurück in Hauptmenü%n");

        enemyWeak.setHp(enemyWeak.getMaxHp());
        enemyNormal.setHp(enemyNormal.getMaxHp());
        enemyStrong.setHp(enemyStrong.getMaxHp());
        enemyUnbeatable.setHp(enemyUnbeatable.getMaxHp());

        player.setEscape(false);
        running = true;
        input = Utils.getSoundInput();

        switch (input) {
            case "1" -> {

                // Kampf startet
                enemyWeak.setHp(100);
                System.out.printf("%n%s ausgewählt, starte Kampf", enemyWeak.getName());
                Utils.dotText();
                System.out.printf("%nKampf beginnt gegen %s\n", enemyWeak.getName());
                output.playSound(SoundFiles.STARTFIGHT.getFileName());
                Thread.sleep(500);


                while (running == true) {

                    // Angriff Spieler ⇒ Gegner
                    if (player.isBlock() == false) {
                        if (player.isMiss() == true) {
                            System.out.printf("%nDer Angriff ging daneben.%n");
                            output.playSound(SoundFiles.ATTACKMISS.getFileName());
                        }
                        else {
                            player.attack(enemyWeak);
                            System.out.printf("%n%s greift %s an und verursacht %s Schaden. ", player.getName(), enemyWeak.getName(), player.getFinalDamage(enemyWeak));
                            Thread.sleep(100);
                            System.out.printf("%s%n", Character.showCritAndHitSound(player));
                            Thread.sleep(500);
                            System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyWeak.getName(), enemyWeak.getHp());
                            Thread.sleep(1500);
                        }
                    }

                    // Angriff blocken
                    else if (player.isBlock() == true) {
                        System.out.println("der nächste Angriff wird geblockt");
                        Thread.sleep(1500);
                    }

                    // Gegner besiegt
                    if (enemyWeak.getHp() < 1) {
                        System.out.printf("%n%s wurde besiegt!%n%n", enemyWeak.getName());
                        output.playSound(SoundFiles.ENEMYDEADSHORT.getFileName());
                        Thread.sleep(200);
                        System.out.println("Du hast 10 Gold und 100 Punkte erhalten!");
                        output.playSound(SoundFiles.GETCOIN.getFileName());
                        player.setGold(player.getGold() + 10);
                        player.setPunkte(player.getPunkte() + 100);
                        return;
                    }

                    // Angriff Gegner ⇒ Spieler
                    else {
                        if (enemyWeak.isMiss() == true) {
                            System.out.printf("%nDer Angriff ging daneben.%n");
                            output.playSound(SoundFiles.ATTACKMISS.getFileName());
                        }
                        else {
                            enemyWeak.attack(player);
                            System.out.printf("%n%s greift %s an und verursacht %s Schaden. ", enemyWeak.getName(), player.getName(), enemyWeak.getFinalDamage(player));
                            Thread.sleep(100);
                            System.out.printf("%s%n", Character.showCritAndHitSound(enemyWeak));
                            Thread.sleep(500);
                            System.out.printf("%s's Lebenspunkte: %s%n", player.getName(), player.getHp());
                            Thread.sleep(1500);
                        }
                    }

                    // Auswahl nächste Runde
                    if (player.getHp() > 1) {
                        System.out.printf("%n**Nächste Runde**%n%n");
                        Thread.sleep(100);
                        output.playSound(SoundFiles.NEXTROUND.getFileName());
                        System.out.println("\"1\" für angreifen");
                        System.out.println("\"2\" für blocken");
                        System.out.println("\"3\" für flüchten");
                        input = Utils.getSoundInput();
                        System.out.println();
                        Thread.sleep(500);

                        switch (input) {
                            case "1" -> {}
                            case "2" -> player.block();
                            case "3" -> {
                                player.escapeFight();
                                if (running == false) {
                                    return;
                                }
                            }
                        }
                    }

                    // Spieler besiegt
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
                Utils.dotText();
                System.out.printf("%nKampf beginnt gegen %s%n", enemyNormal.getName());
                Thread.sleep(500);

                while (true) {

                    player.attack(enemyNormal);
                    System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyNormal.getName(), player.calcDamage(enemyNormal));
                    Thread.sleep(500);
                    System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyNormal.getName(), enemyNormal.getHp());

                    if (enemyNormal.getHp() <= 0) {
                        System.out.printf("%s wurde besiegt!%n%n", enemyNormal.getName());
                        output.playSound(SoundFiles.ENEMYDEADSHORT.getFileName());
                        Thread.sleep(200);
                        System.out.println("Du hast 20 Gold und 200 Punkte erhalten!");
                        output.playSound(SoundFiles.GETCOIN.getFileName());
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
                Utils.dotText();
                System.out.printf("%nKampf beginnt gegen %s%n", enemyStrong.getName());
                Thread.sleep(500);

                while (true) {

                    player.attack(enemyStrong);
                    System.out.printf("%nDu greifst %s an und verursacht %s Schaden.%n", enemyStrong.getName(), player.calcDamage(enemyStrong));
                    Thread.sleep(500);
                    System.out.printf("Verbleibende Lebenspunkte von %s: %s%n", enemyStrong.getName(), enemyStrong.getHp());

                    if (enemyStrong.getHp() <= 0) {
                        System.out.printf("%s wurde besiegt!%n%n", enemyStrong.getName());
                        output.playSound(SoundFiles.ENEMYDEADLONG.getFileName());
                        Thread.sleep(200);
                        System.out.println("Du hast 50 Gold und 500 Punkte erhalten!");
                        output.playSound(SoundFiles.GETCOIN.getFileName());
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
                Utils.dotText();
                System.out.println();
            }
        }
    }

    // heilen
    public static void heal() throws InterruptedException {
        while (true) {

        Thread.sleep(200);
        System.out.printf("%nEin Heiltrank kostet 5 Goldstücke, soll %s einen Trank trinken? (\"ja\" oder \"nein\")%n", player.getName());
        input = Utils.getSoundInput();

            if (input.equals("ja")) {
                if (player.getHp() == player.getMaxHp() && player.getGold() > 4) {
                    Thread.sleep(200);
                    System.out.printf("%nDu hast bereits volle Lebenspunkte.%n%n");
                    Utils.laugh();
                    return;
                }
                else if (player.getGold() > 4) {
                    player.setHp(player.getMaxHp());
                    player.setGold(player.getGold() - 5);
                    Thread.sleep(200);
                    System.out.printf("%nDu hast dich vollständig geheilt!%n");
                    output.playSound(SoundFiles.HEAL.getFileName());
                    Thread.sleep(500);
                    return;
                }
                else {
                    Thread.sleep(200);
                    System.out.printf("%nDu hast nicht genug Gold zum heilen!%n");
                    Utils.laugh();
                    return;
                }
            }
            else if (input.equals("nein")) {
                System.out.printf("%nWer nicht will, der hat schon.%n%n");
                Utils.laugh();
                return;
            }
            else {
                Thread.sleep(500);
                System.out.printf("%nungültige Taste%n");
                output.playSound(SoundFiles.FAIL.getFileName());
                Thread.sleep(300);
            }
        }
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

            input = Utils.getSoundInput();

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
                    Utils.dotText();
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
}