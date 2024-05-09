import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Verseny verseny = new Verseny();
        int osszesTipp = 0;
        int helyesTipp = 0;

        while (true) {
            System.out.println("Melyik csiga nyeri a következő fordulót (piros, zold, kek) or press 'x' a kilépéshez:");
            String guess = scanner.nextLine().trim();

            if (guess.equalsIgnoreCase("x")) {
                System.out.println("Kilépés. Köszi, hogy játszottál!");
                break;
            }

            Csiga forduloGyozetese = verseny.runRound();

            if (forduloGyozetese != null) {
                osszesTipp++;
                System.out.println("Ennek a fordulónak a  " + forduloGyozetese.getSzin() + " csiga!");
                if (forduloGyozetese.getSzin().equalsIgnoreCase(guess)) {
                    System.out.println("Grat, jól tippeltél!");
                    helyesTipp++;
                } else {
                    System.out.println("Rosszul tippeltél.");
                }


                double pontosság = (double) helyesTipp / osszesTipp * 100;
                System.out.printf("Aktuális tipp pontosság %.2f%% (%d -ból %d helyes tipp).\n", pontosság, helyesTipp, osszesTipp);
            } else {
                System.out.println("Nincs győztes.");
            }

            // Kiírjuk, hogy melyik csiga kapott boostot
            for (Csiga csiga : verseny.getCsigak()) {
                System.out.println("A " + csiga.getSzin() + " csiganak van " + csiga.getGyoztes() + " győzelme, jelenleg " + csiga.getTavolsag() + " távolságon áll és " + (csiga.gotBoost() ? "kapott boostot erre a körre." : "nem kapott boostot erre a körre."));
            }

            System.out.println("---- Következő forduló ----");
        }

        scanner.close();
    }
}
