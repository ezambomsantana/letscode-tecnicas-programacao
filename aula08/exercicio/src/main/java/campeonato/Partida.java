package campeonato;

import java.time.LocalDate;

public class Partida {

    private LocalDate dataPartida;
    private Integer placarMandante;
    private Integer placarVisitante;
    private Integer golTotal;
    private String mandante;
    private String visitante;
    private String tipoVencedor;
    private String vencedor;

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getTipoVencedor() {
        return tipoVencedor;
    }

    public void setTipoVencedor(String tipoVencedor) {
        this.tipoVencedor = tipoVencedor;
    }

    public String getMandante() {
        return mandante;
    }

    public void setMandante(String mandante) {
        this.mandante = mandante;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public Integer getPlacarMandante() {
        return placarMandante;
    }

    public void setPlacarMandante(Integer placarMandante) {
        this.placarMandante = placarMandante;
    }

    public Integer getPlacarVisitante() {
        return placarVisitante;
    }

    public void setPlacarVisitante(Integer placarVisitante) {
        this.placarVisitante = placarVisitante;
    }

    public Integer getGolTotal() {
        return golTotal;
    }

    public void setGolTotal(Integer golTotal) {
        this.golTotal = golTotal;
    }

    public LocalDate getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(LocalDate dataPartida) {
        this.dataPartida = dataPartida;
    }
}
