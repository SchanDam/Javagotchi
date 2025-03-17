public enum SoundFiles {
    ATTACKMISS("attackMiss.wav"),
    CHOCOBO("chocobo.wav"),
    CLOUDCRIT("cloudCrit.wav"),
    CLOUDHIT("cloudHit.wav"),
    ENEMYDEADSHORT("enemyDeadShort.wav"),
    ENEMYDEADLONG("enemyDeadLong.wav"),
    ESCAPE("escape.wav"),
    FAIL("inputFail.wav"),
    GETCOIN("getCoin.wav"),
    HEAL("heal.wav"),
    HEARTBUMP("heartbump.wav"),
    INPUT("input.wav"),
    LAUGH("laugh.wav"),
    NEXTROUND("nextRound.wav"),
    NORMALHIT("normalHit.wav"),
    SEPH("seph.wav"),
    STARTFIGHT("startFight.wav");
    private final String fileName;

    SoundFiles(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
