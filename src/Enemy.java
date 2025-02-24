public class Enemy {

    private int str;
    private int def;
    private int hp;

    private String name;

    public Enemy(String name, int str, int def, int hp) {
        this.name = name;
        this.str = str;
        this.def = def;
        this.hp = hp;
    }

    // Auslesen von geschützen Variabeln
    public void setStr(int str) {
        this.str = str;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setname(String name) {
        this.name = name;
    }
    public int getStr() {
        return str;
    }
    public int getDef() {
        return def;
    }
    public int getHp() {
        return hp;
    }
    public String getName() {
        return name;
    }

    // Kalkulation Angriffswert Gegner
    public int damageToPlayer() {
        return Math.max(0, this.str - def);
    }

    // Kalkulation Angriffswert Spieler
    public int damageToEnemy() {
        return Math.max(0, str - this.def);
    }

    // Kalkulation Lebenspunkteverlust Gegner
    public void attackEnemy() {
        int damage = damageToEnemy();
        this.hp -= damage;
    }

    // Kalkulation Lebenspunkteverlust Spieler
    public void attackPlayer() {
        int damage = damageToPlayer();
        hp -= damage;
    }
}
