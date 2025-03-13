import java.util.Random;

public class Character {
    static Random rng = new Random();

    private int str;
    private int def;
    private int hp;
    private int maxHp;

    private int gold = 0;
    private int age = 1;
    private int hunger = 5;
    private int punkte = 0;
    private String name;

    private boolean block = false;
    static boolean isCritical = false;
    static boolean escape = false;
    private int finalDamage;

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

    public int getFinalDamage() {
        return finalDamage;
    }

    public int calcDamage(Character enemy) {

        if (escape == false) {
            if (block == false) {
                int baseDamage = Math.max(0, this.str - enemy.getDef());
                boolean isCritical = (rng.nextInt(100) < 10);
                return isCritical ? baseDamage * 2 : baseDamage;
            } else if (block == true) {
                int baseDamage = Math.max(0, this.str - enemy.getDef());
                isCritical = (rng.nextInt(100) < 10);
                block = false;
                return isCritical ? baseDamage * 2 / 2 : baseDamage / 2;
            }
            return 0;
        } else if (escape == true) {
            escapeFight();
        }
        return 0;
    }

    public void attack(Character enemy) {
        finalDamage = this.calcDamage(enemy);
        enemy.setHp(enemy.getHp() - finalDamage);
    }

    public void block() {
        block = true;
    }

    public static String showCritString() {
        if (isCritical) {
            return "*kritischer Treffer!*";
        }
        return "";
    }

    public void escapeFight() {
        if (escape == true) {
            boolean escapeChance = (rng.nextInt (100) < 70);
            if (escapeChance == true) {
                System.out.println("Du bist geflüchtet");
            }
            else {
                System.out.println("Du konntest nicht flüchten");
            }
        }
    }
}