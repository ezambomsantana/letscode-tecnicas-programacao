package exemplo6.modo2;

public class Pessoa {

    private String nome;
    private Integer salario;
    private String cpf;
    private String cidade;

    public Pessoa(String nome, Integer salario, String cpf, String cidade) {
        this.nome = nome;
        this.salario = salario;
        this.cpf = cpf;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", salario=" + salario +
                ", cpf='" + cpf + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
