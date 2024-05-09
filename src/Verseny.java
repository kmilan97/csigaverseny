import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Verseny {
    private List<Csiga> Csigak;
    private Random random;

    public Verseny() {
        Csigak = new ArrayList<>();
        Csigak.add(new Csiga("piros"));
        Csigak.add(new Csiga("zold"));
        Csigak.add(new Csiga("kek"));
        random = new Random();
    }

    public Csiga runRound() {
        Csiga korGyoztes = null;
        int boostIndex = random.nextInt(Csigak.size()); // Véletlenszerűen választunk egy csigát a boosthoz
        boolean boostotKap = random.nextDouble() < 0.2;  // 20% esély a boost-ra

        for (int i = 0; i < Csigak.size(); i++) {
            int move = random.nextInt(4);
            Csigak.get(i).move(move, boostotKap && i == boostIndex);
        }

        for (Csiga csiga : Csigak) {
            if (csiga.getTavolsag() >= 10) {
                csiga.gyozelemNoveles();
                korGyoztes = csiga;
                Csigak.forEach(Csiga::resetForNextRound); // Nullázzuk a távolságot és a boost állapotot
                break;
            }
        }

        return korGyoztes; // Visszaadjuk a kör győztesét
    }

    public List<Csiga> getCsigak() {
        return Csigak;
    }
}
