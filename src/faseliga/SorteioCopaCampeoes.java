package faseliga;

import java.util.*;

public class SorteioCopaCampeoes {
    public static void main(String[] args) {
        List<TimesFutebol> times = new ArrayList<>(Arrays.asList(
                new TimesFutebol("Real Madrid", "Santiago Bernabéu", "@danielddo"),
                new TimesFutebol("Manchester City", "Etihad Stadium", "@vinimontelo"),
                new TimesFutebol("Real Madrid", "Santiago Bernabéu", "@indiomala"),
                new TimesFutebol("Manchester City", "Etihad Stadium", "@toynho96"),
                new TimesFutebol("Bayern de Munique", "Allianz Arena", "@luishenriquexz"),
                new TimesFutebol("Barcelona", "Camp Nou", "@silva_osk89"),
                new TimesFutebol("Liverpool", "Anfield", "@pewternine"),
                new TimesFutebol("Liverpool", "Anfield", "@silva99_"),
                new TimesFutebol("Barcelona", "Camp Nou", "@clecio69"),
                new TimesFutebol("Bayern de Munique", "Allianz Arena", "@marangoni014"),
                new TimesFutebol("Atlético de Madrid", "Wanda Metropolitano", "@garentgamer2042"),
                new TimesFutebol("Arsenal", "Emirates Stadium", "@deatchscorpion"),
                new TimesFutebol("Arsenal", "Emirates Stadium", "@astakun1206"),
                new TimesFutebol("Manchester United", "Old Trafford", "@sueldoqueiroz"),
                new TimesFutebol("Bayer Leverkusen", "BayArena", "@ge.kk"),
                new TimesFutebol("Borussia Dortmund", "Signal Iduna Park", "@arthurzinn_corinthiano_13048"),
                new TimesFutebol("Tottenham Hotspur", "Tottenham Hotspur Stadium", "@sennaaveryput0"),
                new TimesFutebol("Sport Recife", "Ilha do Retiro", "@j_ruan77"),
                new TimesFutebol("Tottenham Hotspur", "Tottenham Hotspur Stadium", "@renan.fxpp"),
                new TimesFutebol("Aston Villa", "Villa Park", "@thzinnn22k"),
                new TimesFutebol("Inter de Milão", "San Siro", "@luizin006"),
                new TimesFutebol("Inter de Milão", "San Siro", "@joazindograudemotodarandaran"),
                new TimesFutebol("PSG", "Parc des Princes", "@job_cleitiin"),
                new TimesFutebol("PSG", "Parc des Princes", "@zapzap.yh"),
                new TimesFutebol("Corinthians", "Neo Química Arena", "@junior_44107"),
                new TimesFutebol("Corinthians", "Neo Química Arena", "@thomasjr007"),
                new TimesFutebol("Atlético de Madrid", "Wanda Metropolitano", "@lanzzo"),
                new TimesFutebol("Palmeiras", "Allianz Parque", "@jotace1431_10211"),
                new TimesFutebol("Manchester United", "Old Trafford", "@salvee_kzinn"),
                new TimesFutebol("Flamengo", "Maracanã", "@jpmesquita12"),
                new TimesFutebol("Flamengo", "Maracanã", "@danielmods17"),
                new TimesFutebol("Fluminense", "Maracanã", "@glauber760"),
                new TimesFutebol("Bayer Leverkusen", "BayArena", "@gomez_82095"),
                new TimesFutebol("Atlético de Madrid", "Wanda Metropolitano", "@fabriciorp")
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