import java.util.Random;

public class Utils {

    public static void sout(String text) {
        Random rng = new Random();
        try {
            for (char c : text.toCharArray()) {
                System.out.print(c);

                // zufällige Geschwindigkeit zwischen 30 und 150 ms für Retro-Effekt
                Thread.sleep(rng.nextInt(40, 120));
            }
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // Methode für formatierte Texte
    public static void souf(String text, Object... args) {
        sout(String.format(text, args));
    }
}