package dataFactory;

import Pojo.ComponentePojo;
import Pojo.ProdutoPojo;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDataFactory {

    public static ProdutoPojo criarProdutoComumComOValorIgualA(double valor){
        ProdutoPojo produtoNovo = new ProdutoPojo("PlayStation6",valor);
        List Cores = new ArrayList<>();
        Cores.add("Azul");
        Cores.add("Preto");
        produtoNovo.setProdutoCores(Cores);

        List<ComponentePojo> componentes = new ArrayList<>();
        ComponentePojo novoComponente = new ComponentePojo("Controle",2);
        componentes.add(novoComponente);
        produtoNovo.setProdutoComponente(componentes);

        return produtoNovo;
    }
}
