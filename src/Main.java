import java.util.Random;
import java.util.Scanner;

public class Main {

    public static Attribute att = new Attribute();
    static Random rng = new Random();
    static Scanner sc = new Scanner(System.in);
    static String input;

    public static void main(String[] args) throws Exception {

        Functions.einleitung();

        // Funktionen
        while (true) {
            System.out.println("Erwarte Eingabe:");
            Thread.sleep(200);
            System.out.println("für Auflistung der Möglichkeiten Enter drücken");
            input = sc.nextLine();

            // Programm beenden
            if (input.equals("q")) {
                System.out.println("\nAuf wiedersehen! Bis bald!");
                Thread.sleep(100);
                System.out.println("Du hast " + att.getPunkte() + " Punkte erreicht!");
                System.exit(0);
            }

            // Punktestand abfragen
            else if (input.equals("p")) {
                System.out.println("\ndein aktueller Punktestand ist " + att.getPunkte() + ".\n");
            }

            // Attribute abfragen
            else if (input.equals("a")) {
                Functions.att();
            }

            // Essen
            else if (input.equals("e")) {
                if (att.getHunger() < 10) {
                    att.setHunger(att.getHunger() + 1);
                    System.out.println("Danke für das Essen! Mein Hungerlevel ist: " + att.getHunger() + "\n");
                }
                else {
                    System.out.println("Ich bin satt\n");
                }
            }

            // Hungerlevel abfragen
            else if (input.equals("h")) {
                System.out.println("\nMein Hungerlevel ist: " + att.getHunger() + "\n");
            }

            // trainieren
            else if (input.equals("t")) {
                System.out.print("\nIch muss meine Fähigkeiten mit Schwert und Schild trainieren!\nEin Jahr vergeht");
                Functions.dotText();
                att.setAge(att.getAge() + 1);

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

            // Debugmenü
            else if (input.equals("debug")) {
                System.out.print("\nLade Debugmenü, bitte warten");
                Functions.dotText();
                Functions.debugMenu();
            }

            // Neustart
            else if (input.equals("n")) {
                System.out.println("\nDas Spiel wird neu gestartet");
                Thread.sleep(2000);
                main(null);
            }

            // Auflisten
            else if (input.isBlank()) {
                Functions.mainMenu();
            }
            // falsche Taste
            else {
                System.out.println("\nungültige Taste");
                Thread.sleep(200);
                Functions.mainMenu();
            }

            // Hunger tracken
            if (att.getHunger() < 1) {
                Thread.sleep(1000);
                System.out.print("Ich bin verhungert");
                Functions.dotText();
                System.out.println("\nDas Spiel ist vorbei.\n");
                Thread.sleep(1000);
                ASCII.ritterTot();
                Thread.sleep(200);
                System.out.println("Du hast " + att.getPunkte() + " Punkte erreicht!");
                System.exit(0);
            }

            // Alter tracken
            if (att.getAge() > 9) {
                Thread.sleep(1000);
                System.out.println("\nIch bin nun 10 Jahre alt, von nun an bin ich stark genug um mich selbst durchzuschlagen.\nVielen Dank für deine Hilfe!\n");
                Thread.sleep(1000);
                System.out.println("Du hast das Spiel gewonnen!");
                Thread.sleep(200);
                System.out.println("Du hast " + att.getPunkte() + " Punkte erreicht!");
                System.exit(0);
            }
        }
    }
}