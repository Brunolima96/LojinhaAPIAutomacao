package Pojo;

public class ComponentePojo {

    private String componenteNome;
    private int componenteValor;

    public ComponentePojo(String nome, int valor){
        this.componenteNome = nome;
        this.componenteValor = valor;
    }
    public String getComponenteNome() {
        return componenteNome;
    }

    public void setComponenteNome(String componenteNome) {
        this.componenteNome = componenteNome;
    }

    public int getComponenteValor() {
        return componenteValor;
    }

    public void setComponenteValor(int componenteValor) {
        this.componenteValor = componenteValor;
    }
}
