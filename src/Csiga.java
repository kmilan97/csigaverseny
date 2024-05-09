public class Csiga {
    private String szin;
    private int tavolsag;
    private int gyoztes;
    private boolean kapottBoostot;

    public Csiga(String color) {
        this.szin = color;
        this.tavolsag = 0;
        this.gyoztes = 0;
        this.kapottBoostot = false;
    }

    public String getSzin() {
        return szin;
    }

    public int getTavolsag() {
        return tavolsag;
    }

    public int getGyoztes() {
        return gyoztes;
    }

    public boolean gotBoost() {
        return kapottBoostot;
    }

    public void move(int units, boolean boost) {
        if (boost) {
            units *= 2;
            kapottBoostot = true;
        }
        tavolsag += units;
    }

    public void resetForNextRound() {
        tavolsag = 0;
        kapottBoostot = false;
    }

    public void gyozelemNoveles() {
        gyoztes++;
    }
}
