import java.util.Random;

public class Character {

    private int str;
    private int def;
    private int hp;
    private int maxHp;

    private int gold = 0;
    private int age = 1;
    private int hunger = 5;
    private int punkte = 0;
    private String name;


    public Character(int getStr, int getDef, int getHp, int getGold) {
        this.str = getStr;
        this.def = getDef;
        this.hp = getHp;
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

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int calcDamage(Character enemy) {
        Random rng = new Random();

        int baseDamage = Math.max(0, this.str - enemy.getDef());
        boolean isCritical = (rng.nextInt(100) < 10);
        return isCritical ? baseDamage * 2 : baseDamage;
    }

    public int attack(Character enemy) {
        int finalDamage = this.calcDamage(enemy);
        enemy.setHp(enemy.getHp() - finalDamage);
        return finalDamage;
    }
}