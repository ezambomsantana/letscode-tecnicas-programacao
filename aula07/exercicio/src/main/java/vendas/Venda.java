package vendas;

import java.time.LocalDateTime;

public class Venda {

    private String comprador;
    private Integer numeroItens;
    private Float preco;
    private Integer caixa;
    private LocalDateTime dataCompra;

    public Venda() {

    }

    public Venda(String comprador, Integer numeroItens, Float preco, Integer caixa, LocalDateTime dataCompra) {
        this.comprador = comprador;
        this.numeroItens = numeroItens;
        this.preco = preco;
        this.caixa = caixa;
        this.dataCompra = dataCompra;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public Integer getNumeroItens() {
        return numeroItens;
    }

    public void setNumeroItens(Integer numeroItens) {
        this.numeroItens = numeroItens;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getCaixa() {
        return caixa;
    }

    public void setCaixa(Integer caixa) {
        this.caixa = caixa;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }
}
