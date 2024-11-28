package eliminatorias;

import java.util.*;

public class SorteioEliminatoria {
    public static void main(String[] args) {
        List<TimesEquipes> times = new ArrayList<>(Arrays.asList(
                new TimesEquipes("REAL MADRID", "ESP", "@danielddo", 1),
                new TimesEquipes("LIVERPOOL", "ING", "@pewternine", 1),
                new TimesEquipes("REAL MADRID", "ESP", "@indiomala", 1),
                new TimesEquipes("LIVERPOOL", "ING", "@luishenriquexz", 1),
                new TimesEquipes("MAN CITY", "ING", "@toynho96", 1),
                new TimesEquipes("INTER MIAMI", "EUA", "@danielmods", 1),
                new TimesEquipes("ATLÉTICO MADRID", "ESP", "@freitas777", 1),
                new TimesEquipes("MAN CITY", "ING", "@ukamuni", 1),
                new TimesEquipes("MAN CITY", "ING", "@deatchscorpion", 2),
                new TimesEquipes("BARCELONA", "ESP", "@astakun", 2),
                new TimesEquipes("ARSENAL", "ING", "@vinimontelo.", 2),
                new TimesEquipes("FLAMENGO", "BRA", "@sueldoqueiroz", 2),
                new TimesEquipes("BAYERN MÜNCHEN", "ALE", "@lanzzo", 2),
                new TimesEquipes("INTER MILÃO", "ITA", "@mardempc", 2),
                new TimesEquipes("BORUSSIA DORTMUND", "ALE", "@nerd", 2),
                new TimesEquipes("BARCELONA", "ESP", "@luquinhaa", 2)
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
}
