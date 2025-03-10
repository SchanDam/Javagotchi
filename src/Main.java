import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String input;

    public static void main(String[] args) throws Exception {

        Game.einleitung();

        // Funktionen
        while (true) {
            System.out.println("für Auflistung der Möglichkeiten Enter drücken");
            Thread.sleep(200);
            System.out.println("Erwarte Eingabe:");
            input = sc.nextLine();

            // Programm beenden
            if (input.equals("q")) {
                System.out.println("\nAuf wiedersehen! Bis bald!");
                Thread.sleep(100);
                System.out.println("Du hast " + Game.player.getPunkte() + " Punkte erreicht!");
                break;
            }

            // Punktestand abfragen
            else if (input.equals("p")) {
                System.out.println("\ndein aktueller Punktestand ist " + Game.player.getPunkte() + ".\n");
            }

            // Attribute abfragen
            else if (input.equals("a")) {
                Game.att();
            }

            // Essen
            else if (input.equals("e")) {
                if (Game.player.getHunger() < 10) {
                    Game.player.setHunger(Game.player.getHunger() + 1);
                    System.out.println("Danke für das Essen! Mein Hungerlevel ist: " + Game.player.getHunger() + "\n");
                }
                else {
                    System.out.println("Ich bin satt\n");
                }
            }

            // Hungerlevel abfragen
            else if (input.equals("h")) {
                System.out.println("\nMein Hungerlevel ist: " + Game.player.getHunger() + "\n");
            }

            // trainieren
            else if (input.equals("t")) {
                Game.training();
            }

            // kämpfen
            else if (input.equals("k")) {
                Game.kampf();
            }

            // Debugmenü
            else if (input.equals("debug")) {
                System.out.print("\nLade Debugmenü, bitte warten");
                Game.dotText();
                Game.debugMenu();
            }

            // Neustart
            else if (input.equals("n")) {
                System.out.print("\nDas Spiel wird neu gestartet, resette Attribute");
                Game.player.setStr(1);
                Game.player.setDef(1);
                Game.player.setHp(100);
                Game.player.setAge(1);
                Game.player.setPunkte(1);
                Game.player.setHunger(5);
                Game.dotText();
                System.out.println("\n\n");
                main(null);
            }

            // Auflisten
            else if (input.isBlank()) {
                Game.mainMenu();
            }

            // falsche Taste
            else {
                System.out.println("\nungültige Taste");
                Thread.sleep(200);
                Game.mainMenu();
            }

            // Hunger tracken
            if (Game.player.getHunger() < 1) {
                Thread.sleep(1000);
                System.out.print("Ich bin verhungert");
                Game.dotText();
                System.out.println("\nDas Spiel ist vorbei.\n");
                Thread.sleep(1000);
                ASCII.ritterTot();
                Thread.sleep(200);
                System.out.println("Du hast " + Game.player.getPunkte() + " Punkte erreicht!");
                return;
            }

            // Alter tracken
            if (Game.player.getAge() > 9) {
                Thread.sleep(1000);
                System.out.println("\nIch bin nun 10 Jahre alt, von nun an bin ich stark genug um mich selbst durchzuschlagen.\nVielen Dank für deine Hilfe!\n");
                Thread.sleep(1000);
                System.out.println("Du hast das Spiel gewonnen!");
                Thread.sleep(200);
                System.out.println("Du hast " + Game.player.getPunkte() + " Punkte erreicht!");
                return;
            }
        }
    }
}