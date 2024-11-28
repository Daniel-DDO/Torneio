package faseliga;

import java.util.ArrayList;
import java.util.List;

public class Rodada {
    private int numero;
    private List<String> jogos;

    public Rodada(int numero) {
        this.numero = numero;
        this.jogos = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public List<String> getJogos() {
        return jogos;
    }

    public void addJogo(String jogo) {
        jogos.add(jogo);
    }
}
