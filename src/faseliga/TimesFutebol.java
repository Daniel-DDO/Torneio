package faseliga;

public class TimesFutebol {
    private String nome;
    private String estadio;
    private String jogador;

    public TimesFutebol(String nome, String estadio, String jogador) {
        this.nome = nome;
        this.estadio = estadio;
        this.jogador = jogador;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEstadio() {
        return estadio;
    }

    public String getJogador() {
        return jogador;
    }

    @Override
    public String toString() {
        return nome + " (" + estadio + ") com jogador " + jogador;
    }
}
