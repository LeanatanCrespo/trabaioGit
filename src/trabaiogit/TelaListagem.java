package trabaiogit;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TelaListagem extends JFrame{



    private static final long serialVersionUID = 1L;

    private JTable tblProdutos;

    public TelaListagem() {
        super("Listagem de Produtos");

        // Criar tabela
        tblProdutos = new JTable();
        JScrollPane scrollPane = new JScrollPane(tblProdutos);
        scrollPane.setBounds(10, 10, 370, 150);

        // Popular tabela com dados da lista de produtos
        popularTabela();

        // Layout
        getContentPane().setLayout(null);

        // Adicionar tabela ao JFrame
        getContentPane().add(scrollPane);

        // Configurações do JFrame
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar ao invés de sair
        setSize(400, 220);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void popularTabela() {
        List<Produto> produtos = Produto.getProdutos();

        String[][] dados = new String[produtos.size()][2];
        for (int i = 0; i < produtos.size(); i++) {
            Produto produto = produtos.get(i);
        try {
            dados[i][0] = produto.getNome();
        } catch (Exception e) {
            System.err.println("Erro ao formatar data de validade do produto: " + produto.getNome() + " - " + e.getMessage());
        }
    }

    String[] colunas = {"Nome", "Data de Validade"};

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    tblProdutos.setModel(model);
}
   
     public static void main(String[] args) {
        new TelaListagem();
    }
}
