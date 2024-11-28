package eliminatorias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorteio2 {
    public static void main(String[] args) {
        List<TimesEquipes> times = new ArrayList<>(Arrays.asList(
                new TimesEquipes("Real Madrid", "RMA", "@danielddo"),
                new TimesEquipes("Liverpool", "LIV", "@pewternine"),
                new TimesEquipes("Liverpool", "LIV", "@luishenriquexz"),
                new TimesEquipes("Bayern", "BAY", "@indiomala"),
                new TimesEquipes("Bayern", "BAY", "@silva_osk89"),
                new TimesEquipes("Man City", "MCI", "@toynho96"),
                new TimesEquipes("PSG", "PSG", "@germuknevida"),
                new TimesEquipes("Real Madrid", "RMA", "@lanzzo")
        ));

        Collections.shuffle(times);

        List<TimesEquipes> confrontos = new ArrayList<>();

        System.out.println("\nSorteio dos confrontos:\n");

        for (int i = 0; i < times.size(); i++) {
            TimesEquipes time1 = times.get(i);
            TimesEquipes adversario = null;

            for (int j = i + 1; j < times.size(); j++) {
                TimesEquipes potencialAdversario = times.get(j);
                if (!time1.getPais().equals(potencialAdversario.getPais())) {
                    adversario = potencialAdversario;
                    confrontos.add(time1);
                    confrontos.add(adversario);
                    times.remove(adversario);
                    break;
                }
            }

            if (adversario != null) {
                System.out.println(time1 + " X " + adversario);
            } else {
                System.out.println("Não há adversário válido para " + time1.getNome());
            }
        }
    }
}
