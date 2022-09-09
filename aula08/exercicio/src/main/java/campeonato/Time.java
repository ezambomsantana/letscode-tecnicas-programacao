package campeonato;

public class Time {

    private String nome;
    private Integer gols;
    private Integer golsTomados;
    private Integer vitorias = 0;
    private Integer derrotas = 0;
    private Integer jogos;

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getJogos() {
        return jogos;
    }

    public void setJogos(Integer jogos) {
        this.jogos = jogos;
    }

    public Integer getGolsTomados() {
        return golsTomados;
    }

    public void setGolsTomados(Integer golsTomados) {
        this.golsTomados = golsTomados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getGols() {
        return gols;
    }

    public void setGols(Integer gols) {
        this.gols = gols;
    }


    @Override
    public String toString() {
        return "Time{" +
                "nome='" + nome + '\'' +
                ", gols=" + gols +
                ", golsTomados=" + golsTomados +
                '}';
    }
}
