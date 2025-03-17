//import java.util.Random;
//
//public class Combatsys {
//
//    private Random rng = new Random();
//
//    private Combatsys() {}
//
//    public static int calcDamage(Character character) {
//
//        if (!character.isEscaping()) {
//            if (!character.isBlocking()) {
//                int baseDamage = Math.max(0, this.str - character.getDef());
//                character.setIsCritical(rng.nextInt(100) < 10);
//                return isCritical ? baseDamage * 2 : baseDamage;
//            }
//            else {
//                int baseDamage = Math.max(0, this.str - character.getDef());
//                character.setIsCritical(rng.nextInt(100) < 10);
//                character.setIsBlocking(false);
//                return isCritical ? baseDamage * 2 / 2 : baseDamage / 2;
//            }
//            return 0;
//        }
//        else {
//            escapeFight();
//        }
//        return 0;
//    }
//
//    public static void attack(Character attacker, Character attacked) {
//        character.setFinalDamage(calcDamage(character));
//        character.setHp(character.getHp() - character.getFinalDamage());
//    }
//
//    public static void block() {
//        block = true;
//    }
//
//    public static String showCritString() {
//        if (isCritical) {
//            return "*kritischer Treffer!*";
//        }
//        return "";
//    }
//
//    public static void escapeFight() {
//        if (escape == true) {
//            boolean escapeChance = (rng.nextInt (100) < 70);
//            if (escapeChance == true) {
//                System.out.println("Du bist geflüchtet");
//            }
//            else {
//                System.out.println("Du konntest nicht flüchten");
//            }
//        }
//    }
//}
