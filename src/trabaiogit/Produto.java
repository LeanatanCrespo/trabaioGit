package trabaiogit;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Produto {

    private String nome;
    private int dataValidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(int dataValidade) {
        this.dataValidade = dataValidade;
    }


    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static void setProdutos(List<Produto> produtos) {
        Produto.produtos = produtos;
    }
    
    
    private static List<Produto> produtos = new ArrayList<>();

   
}
