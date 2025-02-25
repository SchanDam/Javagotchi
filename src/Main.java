import java.util.Scanner;

public class Main {

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
                System.out.println("Du hast " + Functions.att.getPunkte() + " Punkte erreicht!");
                System.exit(0);
            }

            // Punktestand abfragen
            else if (input.equals("p")) {
                System.out.println("\ndein aktueller Punktestand ist " + Functions.att.getPunkte() + ".\n");
            }

            // Attribute abfragen
            else if (input.equals("a")) {
                Functions.att();
            }

            // Essen
            else if (input.equals("e")) {
                if (Functions.att.getHunger() < 10) {
                    Functions.att.setHunger(Functions.att.getHunger() + 1);
                    System.out.println("Danke für das Essen! Mein Hungerlevel ist: " + Functions.att.getHunger() + "\n");
                }
                else {
                    System.out.println("Ich bin satt\n");
                }
            }

            // Hungerlevel abfragen
            else if (input.equals("h")) {
                System.out.println("\nMein Hungerlevel ist: " + Functions.att.getHunger() + "\n");
            }

            // trainieren
            else if (input.equals("t")) {
                Functions.training();
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
            if (Functions.att.getHunger() < 1) {
                Thread.sleep(1000);
                System.out.print("Ich bin verhungert");
                Functions.dotText();
                System.out.println("\nDas Spiel ist vorbei.\n");
                Thread.sleep(1000);
                ASCII.ritterTot();
                Thread.sleep(200);
                System.out.println("Du hast " + Functions.att.getPunkte() + " Punkte erreicht!");
                System.exit(0);
            }

            // Alter tracken
            if (Functions.att.getAge() > 9) {
                Thread.sleep(1000);
                System.out.println("\nIch bin nun 10 Jahre alt, von nun an bin ich stark genug um mich selbst durchzuschlagen.\nVielen Dank für deine Hilfe!\n");
                Thread.sleep(1000);
                System.out.println("Du hast das Spiel gewonnen!");
                Thread.sleep(200);
                System.out.println("Du hast " + Functions.att.getPunkte() + " Punkte erreicht!");
                System.exit(0);
            }
        }
    }
}