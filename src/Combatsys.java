import audio.SoundFiles;
import audio.Sounds;
import characters.Chars;
import characters.Enemies;
import characters.Player;

import java.util.Random;

public class Combatsys {
    static Sounds output = new Sounds();
    static Random rng = new Random();

    public Combatsys(Player player, Enemies enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    private int finalDamage;
    private static boolean isCritical;
    private boolean running = true;

    public int getFinalDamage(Game target) {
        return this.finalDamage;
    }

    public int calcDamage(Game target) throws InterruptedException {
        if (player.escape == true) {
            escapeFight();
            return 0;
        }
        int baseDamage = Math.max(0, player.getStr() - enemy.getDef());
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

    public static String showCritAndHitSound(Chars enemy) {
        if (enemy == Game.player && isCritical == true) {
            output.playSound(SoundFiles.CLOUDCRIT.getFileName());
            return "*kritischer Treffer!*";
        } else if (enemy == Game.player) {
            output.playSound("cloudHit.wav");
            return "";
        } else if (enemy == Game.enemy && isCritical == true) {
            output.playSound("normalHit.wav");
            return "*kritischer Treffer!*";
        } else if (enemy == Game.enemy) {
            output.playSound("normalHit.wav");
            return "";
        }
        return "";
    }
}