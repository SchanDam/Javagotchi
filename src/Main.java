import audio.SoundFiles;
import audio.Sounds;

public class Main {

    static String input;
    static Sounds output = new Sounds();

    public static void main(String[] args) throws Exception {
        boolean running = true;

        //Game.einleitung();

        while (running) {
            System.out.printf("%n? für Menüanzeige%n");
            Thread.sleep(200);
            System.out.printf("Erwarte Eingabe:%n");
            input = Utils.getSoundInput();

            // Attribute abfragen
            if (input.equals("a")) {
                Game.printAttributes();
            }

            // Essen
            else if (input.equals("e")) {
                Game.eat();
            }

            // trainieren
            else if (input.equals("t")) {
                Game.training();
            }

            // kämpfen
            else if (input.equals("k")) {
                Game.fight();
            }

            // heilen
            else if (input.equals("h")) {
                Game.heal();
            }

            // Punktestand abfragen
            else if (input.equals("p")) {
                System.out.printf("%nDein aktueller Punktestand ist %s.%n", Game.player.getPunkte());
            }

            // Neustart
            else if (input.equals("n")) {
                Game.reset();
                continue;
            }

            // Programm beenden
            else if (input.equals("q")) {
                System.out.printf("%nTschüss, bis bald!%n");
                Thread.sleep(200);
                System.out.printf("Du hast %s Punkte erreicht!%n", Game.player.getPunkte());
                Thread.sleep(500);
                break;
            }

            // Debugmenü
            else if (input.equals("debug")) {
                System.out.printf("%nLade Debugmenü, bitte warten");
                Utils.dotText();
                Game.debugMenu();
            }

            // Auflisten
            else if (input.equals("?")) {
                Game.mainMenu();
            }

            // falsche Taste
            else {
                Thread.sleep(500);
                System.out.printf("%nungültige Taste%n");
                output.playSound(SoundFiles.FAIL.getFileName());
                Thread.sleep(300);
            }

            // Hunger tracken
            if (Game.player.getHunger() < 1) {
                Thread.sleep(1000);
                System.out.print("Ich bin verhungert");
                Utils.dotText();
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

