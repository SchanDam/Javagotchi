import java.util.Random;

@SuppressWarnings("PointlessBooleanExpression")
public class Character {
    static Random rng = new Random();
    static Sounds output = new Sounds();

    private int str;
    private int def;
    private int hp;
    @SuppressWarnings("FieldMayBeFinal")
    private int maxHp;

    private int gold;
    private int age = 1;
    private int hunger = 5;
    private int punkte = 0;
    private String name;

    private boolean block = false;
    private static boolean isCritical;
    static boolean escape = false;
    private int finalDamage;
    static boolean running = true;

    public Character(int getStr, int getDef, int getHp, int getGold) {
        this.str = getStr;
        this.def = getDef;
        this.hp = getHp;
        this.maxHp = hp;
        this.gold = getGold;
    }

    public Character(String name, int getStr, int getDef, int getHp) {
        this.str = getStr;
        this.def = getDef;
        this.hp = getHp;
        this.maxHp = hp;
        this.name = name;
    }

    public void setStr(int str) {
        this.str = Math.min(255, str);
    }

    public int getStr() {
        return str;
    }

    public void setDef(int def) {
        this.def = Math.min(255, def);
    }

    public int getDef() {
        return def;
    }

    public void setHp(int hp) {
        this.hp = Math.min(9999, hp);
    }

    public int getHp() {
        return Math.max(0, hp);
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

    public void setPunkte(int punkte) {
        this.punkte = Math.max(0, punkte);
    }

    public int getPunkte() {
        return punkte;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getFinalDamage(Character enemy) {
        return this.finalDamage;
    }

    public boolean isBlock() {
        return block;
    }

    public int calcDamage(Character enemy) {
        if (running == false) {
            System.out.println("DEBUG: Etwas is schief gelaufen.");
            return 0;
        }
        if (escape == true) {
            escapeFight();
            return 0;
        }
        int baseDamage = Math.max(0, this.str - enemy.getDef());
        isCritical = (rng.nextInt(100) < 15);
        finalDamage = isCritical ? baseDamage * 2 : baseDamage;

        if (enemy.block == true) {
            finalDamage /= 2;
            enemy.block = false;
            return finalDamage;
        }
        return finalDamage;
    }

    public void attack(Character enemy){
        if (running == false || escape == true) return;
        this.finalDamage = calcDamage(enemy);
        enemy.setHp(enemy.getHp() - this.finalDamage);
    }

    public void block() {
        this.block = true;
    }

    public void escapeFight() {
        boolean escapeChance = (rng.nextInt(100) < 80);

            if (escapeChance == true) {
                System.out.println("Du bist geflüchtet");
                output.playSound("escape.wav");
                escape = true;
                Game.running = false;
            } else {
                System.out.println("Du konntest nicht flüchten");
                output.playSound("inputFail.wav");
                escape = false;
            }
        }

    public static String showCritAndHitSound (Character enemy) {
        if (enemy == Game.player && isCritical == true) {
            output.playSound("cloudCrit.wav");
            return "*kritischer Treffer!*";
        } else if (enemy == Game.player) {
            output.playSound("cloudHit.wav");
            return "";
        } else if (enemy == Game.enemyWeak && isCritical == true) {
            output.playSound("normalHit.wav");
            return "*kritischer Treffer!*";
        } else if (enemy == Game.enemyWeak) {
            output.playSound("normalHit.wav");
            return "";
        }
        return "";
    }
}