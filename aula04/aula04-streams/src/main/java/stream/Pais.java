package stream;

import java.time.LocalDate;
import java.time.YearMonth;

public class Pais {

    private String nome;
    private String continente;
    private Integer populacao;
    private Float porcentagem;
    private YearMonth data;

    public Pais() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    public Float getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(Float porcentagem) {
        this.porcentagem = porcentagem;
    }

    public YearMonth getData() {
        return data;
    }

    public void setData(YearMonth data) {
        this.data = data;
    }
}
