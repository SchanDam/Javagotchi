package audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Sounds {

    private float volume = -10.0f; // Standard-Lautstärke (dB), 0.0f = Original, -20.0f = leiser

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void playSound(String fileName) {
        try {
            InputStream audioSrc = getClass().getResourceAsStream("/sounds/" + fileName);
            if (audioSrc == null) {
                throw new IllegalArgumentException("Datei nicht gefunden: " + fileName);
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioSrc);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Lautstärke anpassen
            setClipVolume(clip, volume);

            clip.start();
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

                // Lautstärke anpassen
                setClipVolume(clip, volume);

                clip.start();
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void setClipVolume(Clip clip, float volume) {
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(volume); // Negative Werte machen den Sound leiser
    }
}