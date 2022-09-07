package campeonato;

public class Partida {

    private String mandante;
    private String visitante;
    private Integer golMandante;
    private Integer golVisitante;

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

    public Integer getGolMandante() {
        return golMandante;
    }

    public void setGolMandante(Integer golMandante) {
        this.golMandante = golMandante;
    }

    public Integer getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(Integer golVisitante) {
        this.golVisitante = golVisitante;
    }
}
