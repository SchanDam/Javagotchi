package characters;
import java.util.Random;
import audio.Sounds;
import audio.SoundFiles;


public class Player extends Chars {

    private int age = 1;
    private int hunger = 5;
    private int gold;
    private int punkte = 0;
    private boolean block = false;
    private boolean escape = false;

    Random rng = new Random();
    Sounds output = new Sounds();

    public Player() {
        super("", 1, 1, 100);
    }


    public boolean isBlock() {
        return block;
    }
    public void block(boolean block) {
        this.block = true;
    }

    public void setAge(int age) {
        this.age = Math.max(1, age);
    }
    public int getAge() {
        return age;
    }

    public void setHunger(int hunger) {
        this.hunger = Math.min(255, hunger);
    }
    public int getHunger() {
        return hunger;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    public int getGold() {
        return gold;
    }

    public void setPunkte(int punkte) {
        this.punkte = Math.max(0, punkte);
    }
    public int getPunkte() {
        return punkte;
    }

    public void setEscape(boolean escape) {
        this.escape = escape;
    }
    public void escapeFight() throws InterruptedException {
        boolean escapeChance = (rng.nextInt(100) < 80);


        if (escapeChance == true) {
            System.out.println("Du bist geflüchtet");
            output.playSound(SoundFiles.ESCAPE.getFileName());
            escape = true;
            Game.running = false;
        } else {
            System.out.println("Du konntest nicht flüchten");
            Thread.sleep(200);
            output.playSound("inputFail.wav");
            escape = false;
        }
    }
}