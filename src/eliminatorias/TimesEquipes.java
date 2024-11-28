package eliminatorias;

public class TimesEquipes {
    private String nome;
    private String pais;
    private String jogador;
    private int pote;

    public TimesEquipes() {

    }

    public TimesEquipes(String nome, String pais, String jogador, int pote) {
        this.nome = nome;
        this.pais = pais;
        this.jogador = jogador;
        this.pote = pote;
    }

    public TimesEquipes(String nome, String pais, String jogador) {
        this.nome = nome;
        this.pais = pais;
        this.jogador = jogador;
    }

    public int getPote() {
        return pote;
    }

    public void setPote(int pote) {
        this.pote = pote;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    @Override
    public String toString() {
        return nome + " " + jogador;
    }
}
