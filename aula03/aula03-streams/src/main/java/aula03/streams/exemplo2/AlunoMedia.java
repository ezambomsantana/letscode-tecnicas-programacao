package aula03.streams.exemplo2;

public class AlunoMedia {

    private String nome;
    private Integer media;

    public AlunoMedia(String nome, Integer media) {
        this.nome = nome;
        this.media = media;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMedia() {
        return media;
    }

    public void setMedia(Integer media) {
        this.media = media;
    }
}
