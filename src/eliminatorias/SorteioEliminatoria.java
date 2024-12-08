package eliminatorias;

import java.util.*;

public class SorteioEliminatoria {
    public static void main(String[] args) {
        List<TimesEquipes> times = new ArrayList<>(Arrays.asList(
                new TimesEquipes("BAYERN DE MUNIQUE", "ALE", "@marangoni014", 1),
                new TimesEquipes("MANCHESTER CITY", "ING", "@toynho96", 1),
                new TimesEquipes("REAL MADRID", "ESP", "@danielddo", 1),
                new TimesEquipes("LIVERPOOL", "ING", "@pewternine", 1),
                new TimesEquipes("MILAN", "ITA", "@glauber760", 1),
                new TimesEquipes("ARSENAL", "ING", "@astakun1206", 1),
                new TimesEquipes("REAL MADRID", "ESP", "@indiomala", 1),
                new TimesEquipes("ATLÉTICO DE MADRID", "ESP", "@jwlas.0.__", 1),
                new TimesEquipes("MANCHESTER CITY", "ING", "@vinimontelo.", 2),
                new TimesEquipes("ASTON VILLA", "ING", "@thzinnn22k", 2),
                new TimesEquipes("BAYERN DE MUNIQUE", "ALE", "@luishenriquexz", 2),
                new TimesEquipes("MANCHESTER UNITED", "ING", "@sueldoqueiroz", 2),
                new TimesEquipes("BARCELONA", "ESP", "@silva_osk89", 2),
                new TimesEquipes("PALMEIRAS", "BRA", "@jotace1431_10211", 2),
                new TimesEquipes("LIVERPOOL", "ING", "@silva99_", 2),
                new TimesEquipes("FLAMENGO", "BRA", "@danielmods17", 2)
                ));

        List<TimesEquipes> pote1 = new ArrayList<>();
        List<TimesEquipes> pote2 = new ArrayList<>();

        for (TimesEquipes time : times) {
            if (time.getPote() == 1){
                pote1.add(time);
            } else {
                pote2.add(time);
            }
        }

        shuffleTimes(pote1);
        shuffleTimes(pote2);

        Collections.shuffle(pote1);
        Collections.shuffle(pote2);

        System.out.println("\nSorteio dos confrontos:\n");
        for (TimesEquipes timePote1 : pote1) {
            TimesEquipes adversario = null;
            for (TimesEquipes timePote2 : pote2) {
                if (!timePote1.getPais().equals(timePote2.getPais())) {
                    adversario = timePote2;
                    break;
                }
            }

            if (adversario != null) {
                System.out.println(adversario +" X "+ timePote1);
                pote2.remove(adversario);
            } else {
                System.out.println("Não há adversário válido para " + timePote1.getNome());
            }
        }
    }

    private static void shuffleTimes(List<TimesEquipes> times) {
        System.out.println("Embaralhando times...");
        Collections.shuffle(times);
    }

}
