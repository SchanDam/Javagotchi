import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static String input;

    public static void main(String[] args) throws Exception {
        boolean running = true;

        Game.einleitung();

        while (running) {
            System.out.printf("%n? für Menüanzeige%n");
            Thread.sleep(200);
            System.out.printf("Erwarte Eingabe:%n");
            input = sc.nextLine();

            // Programm beenden
            if (input.equals("q")) {
                System.out.printf("%nTschüss, bis bald!%n");
                Thread.sleep(200);
                System.out.printf("Du hast %s Punkte erreicht!%n", Game.player.getPunkte());
                Thread.sleep(500);
                break;
            }

            // Punktestand abfragen
            else if (input.equals("p")) {
                System.out.printf("%nDein aktueller Punktestand ist %s.%n", Game.player.getPunkte());
            }

            // Attribute abfragen
            else if (input.equals("a")) {
                Game.printAttributes();
            }

            // Essen
            else if (input.equals("e")) {
                if (Game.player.getHunger() < 10) {
                    Game.player.setHunger(Game.player.getHunger() + 1);
                    System.out.printf("%nDanke für das Essen!%n");
                    Thread.sleep(200);
                    System.out.printf("Meine Sättigung ist: %d%n", Game.player.getHunger());
                }
                else {
                    System.out.printf("Ich bin satt%n%n");
                }
            }

            // heilen
            else if (input.equals("h")) {
                Game.heal();
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
                System.out.printf("%nLade Debugmenü, bitte warten");
                Game.dotText();
                Game.debugMenu();
            }

            // Neustart
            else if (input.equals("n")) {
                System.out.printf("%nDas Spiel wird neu gestartet, resette Attribute");
                Game.dotText();
                Game.reset();
                System.out.println();
                continue;
            }

            // Auflisten
            else if (input.equals("?")) {
                Game.mainMenu();
            }

            // falsche Taste
            else {
                System.out.printf("%nungültige Taste%n");
                Thread.sleep(200);
            }

            // Hunger tracken
            if (Game.player.getHunger() < 1) {
                Thread.sleep(1000);
                System.out.print("Ich bin verhungert");
                Game.dotText();
                System.out.printf("%nDas Spiel ist vorbei.%n");
                Thread.sleep(500);
                ASCII.ritterTot();
                Thread.sleep(1000);
                System.out.printf("Du hast %s Punkte erreicht!", Game.player.getPunkte());
                running = false;
            }

            // Alter tracken
            if (Game.player.getAge() > 9) {
                Thread.sleep(1000);
                System.out.printf("%nIch bin nun 10 Jahre alt, von nun an bin ich stark genug, um mich selbst durchzuschlagen.%nVielen Dank für deine Hilfe!%n%n");
                Thread.sleep(1000);
                System.out.println("Du hast das Spiel gewonnen!");
                Thread.sleep(200);
                System.out.printf("Du hast %s Punkte erreicht!", Game.player.getPunkte());
                running = false;
            }
        }
    }
}