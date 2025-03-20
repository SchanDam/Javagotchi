import Characters.Chars;
import Characters.Enemies;

import java.util.ArrayList;
import java.util.Random;

public class Combatsys {
    static Sounds output = new Sounds();
    static Random rng = new Random();

    private int finalDamage;
    private static boolean isCritical;
    private boolean miss;

    private boolean escape = false;
    private boolean running = true;

    public int getFinalDamage(Game target) {
        return this.finalDamage;
    }

    public boolean isMiss() {
        return miss;
    }

    public void setEscape(boolean escape) {
        this.escape = escape;
    }

    public int calcDamage(Game target) throws InterruptedException {
        if (escape == true) {
            escapeFight();
            return 0;
        }
        int baseDamage = Math.max(0, Game.player.getStr() - Game.target.getDef());
//        miss = (rng.nextInt(100) < 10);
        isCritical = (rng.nextInt(100) < 15);
        finalDamage = isCritical ? baseDamage * 2 : baseDamage;

        if (Game.player.isBlock() == true) {
            finalDamage /= 2;
            Game.player.block(false);
        }
        return finalDamage;
    }

    public void attack(Game target) throws InterruptedException {
        if (running == false || escape == true) return;
        this.finalDamage = calcDamage(target);
        target.setHp(target.getHp() - this.finalDamage);
    }

    public void escapeFight() throws InterruptedException {
        boolean escapeChance = (rng.nextInt(100) < 80);

        if (escapeChance == true) {
            System.out.println("Du bist geflüchtet");
            output.playSound("escape.wav");
            escape = true;
            Game.running = false;
        } else {
            System.out.println("Du konntest nicht flüchten");
            Thread.sleep(200);
            output.playSound("inputFail.wav");
            escape = false;
        }
    }

    public static String showCritAndHitSound (Chars enemy) {
        if (enemy == Game.player && isCritical == true) {
            output.playSound(SoundFiles.CLOUDCRIT.getFileName());
            return "*kritischer Treffer!*";
        } else if (enemy == Game.player) {
            output.playSound("cloudHit.wav");
            return "";
        } else if (enemy == Game.skelett && isCritical == true) {
            output.playSound("normalHit.wav");
            return "*kritischer Treffer!*";
        } else if (enemy == Game.skelett) {
            output.playSound("normalHit.wav");
            return "";
        }
        return "";
    }
}
