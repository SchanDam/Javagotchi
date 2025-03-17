import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Sounds {

    public void playSound(String fileName) {
        try {
            // Sound aus dem resources-Ordner laden
            InputStream audioSrc = getClass().getResourceAsStream("/sounds/" + fileName);
            if (audioSrc == null) {
                throw new IllegalArgumentException("Datei nicht gefunden: " + fileName);
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioSrc);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // Optional: Wartezeit, damit der Sound abgespielt wird
            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void playSoundAsync(String fileName) {
        new Thread(() -> {
            try {
                InputStream audioSrc = getClass().getResourceAsStream("/sounds/" + fileName);
                if (audioSrc == null) {
                    throw new IllegalArgumentException("Datei nicht gefunden: " + fileName);
                }

                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioSrc);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();

            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start(); // Neuer Thread, damit das Programm nicht wartet
    }
}