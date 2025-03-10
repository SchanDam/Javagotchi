public class Character {

    private int str;
    private int def;
    private int hp;

    private int age = 1;
    private int hunger = 5;
    private int punkte = 0;
    private String name;


    public Character(int getStr, int getDef, int getHp) {
        this.str = getStr;
        this.def = getDef;
        this.hp = getHp;
    }

    public Character(String name, int getStr, int getDef, int getHp) {
        this.str = getStr;
        this.def = getDef;
        this.hp = getHp;
        this.name = name;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getStr() {
        return str;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getDef() {
        return def;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getHunger() {
        return hunger;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
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

    public void attack(Character enemy) {
            int damage = Math.max(0, this.str - enemy.getDef()); // Schaden berechnen

            System.out.println(this.name + " greift " + enemy.getName() + " an!");
            System.out.println("Berechneter Schaden: " + damage);

            if (damage > 0) {
                int newHp = Math.max(0, enemy.getHp() - damage); // Sicherstellen, dass HP nicht negativ wird
                enemy.setHp(newHp);
                System.out.println(enemy.getName() + " hat jetzt " + enemy.getHp() + " HP.");
            } else {
                System.out.println("Angriff zu schwach, kein Schaden verursacht.");
            }
        }

        }

//        int damage = Math.max(0, this.str - enemy.getDef());
//        enemy.setHp(enemy.getHp() - damage);

