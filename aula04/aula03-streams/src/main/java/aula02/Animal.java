package aula02;


public class Animal {

    private String especie;
    private boolean podeSaltar;
    private boolean podeNadar;
    private boolean podeVoar;
    private boolean podeArrastar;

    public Animal(String especie, boolean podeSaltar, boolean podeNadar, boolean podeVoar, boolean podeArrastar) {
        this.especie = especie;
        this.podeSaltar = podeSaltar;
        this.podeNadar = podeNadar;
        this.podeVoar = podeVoar;
        this.podeArrastar = podeArrastar;
    }

    public boolean isPodeArrastar() {
        return podeArrastar;
    }

    public void setPodeArrastar(boolean podeArrastar) {
        this.podeArrastar = podeArrastar;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isPodeSaltar() {
        return podeSaltar;
    }

    public void setPodeSaltar(boolean podeSaltar) {
        this.podeSaltar = podeSaltar;
    }

    public boolean isPodeNadar() {
        return podeNadar;
    }

    public void setPodeNadar(boolean podeNadar) {
        this.podeNadar = podeNadar;
    }

    public boolean isPodeVoar() {
        return podeVoar;
    }

    public void setPodeVoar(boolean podeVoar) {
        this.podeVoar = podeVoar;
    }
}