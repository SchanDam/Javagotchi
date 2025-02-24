public class Attribute {

        private int playerStr = 1;
        private int playerDef = 1;
        private int playerHp = 100;
        private int age = 1;
        private int hunger = 5;
        private int punkte = 0;
        private String playerName;

        public void setPlayerStr(int playerStr) {
            this.playerStr = playerStr;
        }
        public int getPlayerStr() {
            return playerStr;
        }
        public void setPlayerDef(int playerDef) {
            this.playerDef = playerDef;
        }
        public int getPlayerDef() {
            return playerDef;
        }
        public void setPlayerHp(int playerHp) {
            this.playerHp = playerHp;
        }
        public int getPlayerHp() {
            return playerHp;
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
        public void setPlayerName(String playerName) {
            this.playerName = playerName;
        }
        public String getPlayerName() {
            return playerName;
        }
}
