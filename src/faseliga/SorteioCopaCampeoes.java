package faseliga;

import java.util.*;

public class SorteioCopaCampeoes {
    public static void main(String[] args) {
        List<TimesFutebol> times = new ArrayList<>(Arrays.asList(
                new TimesFutebol("Real Madrid", "Santiago Bernabéu", "@deatchscorpion"),
                new TimesFutebol("Liverpool", "Anfield", "@silva99_"),
                new TimesFutebol("Manchester City", "Etihad Stadium", "@indiomala"),
                new TimesFutebol("Manchester City", "Etihad Stadium", "@vinimontelo"),
                new TimesFutebol("Real Madrid", "Santiago Bernabéu", "@marangoni014"),
                new TimesFutebol("Barcelona", "Camp Nou", "@luishenriquexz"),
                new TimesFutebol("Bayern München", "Allianz Arena", "@luishenriquexz"),
                new TimesFutebol("Arsenal", "Emirates Stadium", "@jhonathan_._"),
                new TimesFutebol("Arsenal", "Emirates Stadium", "@toynho96"),
                new TimesFutebol("Barcelona", "Camp Nou", "@pewternine"),
                new TimesFutebol("Sport Recife", "Ilha do Retiro", "@j_ruan77"),
                new TimesFutebol("Corinthians", "Neo Química Arena", "@thomasjr007"),
                new TimesFutebol("Bayern München", "Allianz Arena", "@glauber760"),
                new TimesFutebol("Inter de Milão", "San Siro", "@danielmods17"),
                new TimesFutebol("Corinthians", "Neo Química Arena", "@ge.kk"),
                new TimesFutebol("Manchester United", "Old Trafford", "@sueldoqueiroz"),
                new TimesFutebol("PSG", "Parc des Princes", "@salvee_kzinn"),
                new TimesFutebol("Flamengo", "Maracanã", "@jpmesquita12"),
                new TimesFutebol("Chelsea", "Stamford Bridge", "@guizin_1323"),
                new TimesFutebol("Palmeiras", "Allianz Parque", "@jotace1431_10211"),
                new TimesFutebol("Palmeiras", "Allianz Parque", "@astakun1206"),
                new TimesFutebol("Napoli", "Diego Armando Maradona", "@supremo5478"),
                new TimesFutebol("Milan", "San Siro", "@inoccent_zero_39543"),
                new TimesFutebol("Liverpool", "Anfield", "@Lanzzo")
                ));

        Map<String, Integer> jogosEmCasa = new HashMap<>();
        Map<String, Integer> jogosFora = new HashMap<>();
        for (TimesFutebol time : times) {
            String chave = time.getNome() + " (" + time.getJogador() + ")";
            jogosEmCasa.put(chave, 0);
            jogosFora.put(chave, 0);
        }

        List<Rodada> rodadas = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            rodadas.add(new Rodada(i));
        }

        Set<String> confrontosRealizados = new HashSet<>();
        Random aleatorio = new Random();

        for (Rodada rodada : rodadas) {
            Set<String> timesNaRodada = new HashSet<>();

            while (rodada.getJogos().size() < times.size() / 2) {
                TimesFutebol timeCasa = times.get(aleatorio.nextInt(times.size()));
                TimesFutebol timeFora = times.get(aleatorio.nextInt(times.size()));

                if (timeCasa.equals(timeFora)) continue;

                String chaveCasa = timeCasa.getNome() + " (" + timeCasa.getJogador() + ")";
                String chaveFora = timeFora.getNome() + " (" + timeFora.getJogador() + ")";
                String confronto = chaveCasa + " x " + chaveFora;
                String confrontoInvertido = chaveFora + " x " + chaveCasa;

                if (confrontosRealizados.contains(confronto) || confrontosRealizados.contains(confrontoInvertido)) continue;

                if (jogosEmCasa.get(chaveCasa) >= 2 || jogosFora.get(chaveFora) >= 2) continue;

                if (timesNaRodada.contains(chaveCasa) || timesNaRodada.contains(chaveFora)) continue;

                confrontosRealizados.add(confronto);
                rodada.addJogo(confronto);

                jogosEmCasa.put(chaveCasa, jogosEmCasa.get(chaveCasa) + 1);
                jogosFora.put(chaveFora, jogosFora.get(chaveFora) + 1);

                timesNaRodada.add(chaveCasa);
                timesNaRodada.add(chaveFora);
            }
        }

        System.out.println("\nJogos por Rodada:");
        for (Rodada rodada : rodadas) {
            System.out.println("\nRodada " + rodada.getNumero() + ":");
            for (String jogo : rodada.getJogos()) {
                System.out.println(jogo);
            }
        }

        System.out.println("\nResumo de jogos:");
        for (TimesFutebol time : times) {
            String chave = time.getNome() + " (" + time.getJogador() + ")";
            System.out.println("\nJogos do " + chave + ":");
            for (Rodada rodada : rodadas) {
                for (String jogo : rodada.getJogos()) {
                    if (jogo.contains(chave)) {
                        System.out.println(jogo);
                    }
                }
            }
        }
    }
}

/*
package faseliga;

import java.util.*;

public class SorteioCopaCampeoes {
    public static void main(String[] args) {
        List<TimesFutebol> times = new ArrayList<>(Arrays.asList(
                new TimesFutebol("Real Madrid", "Santiago Bernabéu", "@deatchscorpion"),
                new TimesFutebol("Liverpool", "Anfield", "@silva99_"),
                new TimesFutebol("Manchester City", "Etihad Stadium", "@indiomala"),
                new TimesFutebol("Manchester City", "Etihad Stadium", "@vinimontelo"),
                new TimesFutebol("Real Madrid", "Santiago Bernabéu", "@marangoni014"),
                new TimesFutebol("Barcelona", "Camp Nou", "@luishenriquexz"),
                new TimesFutebol("Bayern de Munique", "Allianz Arena", "@luishenriquexz"),
                new TimesFutebol("Arsenal", "Emirates Stadium", "@jhonathan_._"),
                new TimesFutebol("Arsenal", "Emirates Stadium", "@toynho96"),
                new TimesFutebol("Barcelona", "Camp Nou", "@pewternine"),
                new TimesFutebol("Sport Recife", "Aflitos", "@j_ruan77"),
                new TimesFutebol("Corinthians", "Arena Corinthians", "@thomasjr007"),
                new TimesFutebol("Bayer Leverkusen", "BayArena", "@glauber760"),
                new TimesFutebol("Inter de Milão", "Giuseppe Meazza", "@danielmods17"),
                new TimesFutebol("Corinthians", "Arena Corinthians", "@ge.kk"),
                new TimesFutebol("Manchester United", "Old Trafford", "@sueldoqueiroz"),
                new TimesFutebol("PSG", "Parc des Princes", "@salvee_kzinn"),
                new TimesFutebol("Flamengo", "Maracanã", "@jpmesquita12"),
                new TimesFutebol("Chelsea", "Stamford Bridge", "@guizin_1323"),
                new TimesFutebol("Palmeiras", "Allianz Parque", "@jotace1431_10211"),
                new TimesFutebol("Palmeiras", "Allianz Parque", "@astakun1206"),
                new TimesFutebol("Napoli", "Stadio Diego Armando Maradona", "@supremo5478"),
                new TimesFutebol("Milan", "San Siro", "@inoccent_zero_39543")
        ));

        Map<String, List<String>> jogos = new HashMap<>();
        for (TimesFutebol time : times) {
            jogos.put(time.getNome() + " (" + time.getJogador() + ")", new ArrayList<>());
        }

        Set<String> confrontosRealizados = new HashSet<>();
        List<Rodada> rodadas = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            rodadas.add(new Rodada(i));
        }

        Map<String, Integer> jogosEmCasa = new HashMap<>();
        Map<String, Integer> jogosFora = new HashMap<>();
        for (TimesFutebol time : times) {
            jogosEmCasa.put(time.getNome() + " (" + time.getJogador() + ")", 0);
            jogosFora.put(time.getNome() + " (" + time.getJogador() + ")", 0);
        }

        Random aleatorio = new Random();
        for (Rodada rodada : rodadas) {
            Set<String> timesNaRodada = new HashSet<>();
            while (rodada.getJogos().size() < times.size() / 2) {
                TimesFutebol timeCasa = times.get(aleatorio.nextInt(times.size()));
                TimesFutebol timeFora = times.get(aleatorio.nextInt(times.size()));

                if (timeCasa.equals(timeFora) ||
                        timesNaRodada.contains(timeCasa.getJogador()) ||
                        timesNaRodada.contains(timeFora.getJogador()) ||
                        jogosEmCasa.get(timeCasa.getNome() + " (" + timeCasa.getJogador() + ")") >= 3 ||
                        jogosFora.get(timeFora.getNome() + " (" + timeFora.getJogador() + ")") >= 3) {
                    continue;
                }

                String confronto = timeCasa.getNome() + " (" + timeCasa.getJogador() + ") x " + timeFora.getNome() + " (" + timeFora.getJogador() + ")";
                String confrontoInvertido = timeFora.getNome() + " (" + timeFora.getJogador() + ") x " + timeCasa.getNome() + " (" + timeCasa.getJogador() + ")";

                if (confrontosRealizados.contains(confronto) || confrontosRealizados.contains(confrontoInvertido)) {
                    continue;
                }

                confrontosRealizados.add(confronto);
                rodada.addJogo(confronto);

                jogosEmCasa.put(timeCasa.getNome() + " (" + timeCasa.getJogador() + ")", jogosEmCasa.get(timeCasa.getNome() + " (" + timeCasa.getJogador() + ")") + 1);
                jogosFora.put(timeFora.getNome() + " (" + timeFora.getJogador() + ")", jogosFora.get(timeFora.getNome() + " (" + timeFora.getJogador() + ")") + 1);

                jogos.get(timeCasa.getNome() + " (" + timeCasa.getJogador() + ")").add(confronto);
                jogos.get(timeFora.getNome() + " (" + timeFora.getJogador() + ")").add(confronto);

                timesNaRodada.add(timeCasa.getJogador());
                timesNaRodada.add(timeFora.getJogador());
            }
        }

        for (Rodada rodada : rodadas) {
            System.out.println("\nfaseliga.Rodada " + rodada.getNumero() + ":");
            for (String jogo : rodada.getJogos()) {
                System.out.println(jogo);
            }
        }

        for (TimesFutebol time : times) {
            String chave = time.getNome() + " (" + time.getJogador() + ")";
            System.out.println("\nJogos do " + chave + ":");
            for (String jogo : jogos.get(chave)) {
                System.out.println(jogo);
            }
        }
    }
}
 */