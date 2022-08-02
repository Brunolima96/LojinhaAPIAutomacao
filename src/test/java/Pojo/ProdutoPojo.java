package Pojo;

import java.util.List;

public class ProdutoPojo {

    private String produtoNome;
    private double produtoValor;
    private List produtoCores;
    private String produtoUrlMock;
    private List<ComponentePojo> produtoComponente;

    public ProdutoPojo(String produtoNome, double produtoValor){
        this.produtoNome = produtoNome;
        this.produtoValor = produtoValor;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public List getProdutoCores() {
        return produtoCores;
    }

    public void setProdutoCores(List produtoCores) {
        this.produtoCores = produtoCores;
    }

    public String getProdutoUrlMock() {
        return produtoUrlMock;
    }

    public void setProdutoUrlMock(String produtoUrlMock) {
        this.produtoUrlMock = produtoUrlMock;
    }

    public List<ComponentePojo> getProdutoComponente() {
        return produtoComponente;
    }

    public void setProdutoComponente(List<ComponentePojo> produtoComponente) {
        this.produtoComponente = produtoComponente;
    }
}
