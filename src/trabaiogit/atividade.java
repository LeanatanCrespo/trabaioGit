package trabaiogit;
   import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class atividade extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JLabel lblNome, lblDataValidade;
    private JTextField txtNome, txtDataValidade;
    private JButton btnCadastrar;
   
    private JTable tblProdutos;

    public atividade() {
        super("Cadastro de Produto");

        // Criar labels
        lblNome = new JLabel("Nome:");
        lblDataValidade = new JLabel("Data de Validade (YYYY-MM-DD):");

        // Criar campos de texto
        txtNome = new JTextField(20);
        txtDataValidade = new JTextField(10);

        // Criar botão
        btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(this);

        // Layout (gerenciador de disposição)
        getContentPane().setLayout(null); // Layout livre (ajuste manualmente)

        // Posicionamento dos componentes
        lblNome.setBounds(10, 10, 100, 20);
        txtNome.setBounds(120, 10, 200, 20);

        lblDataValidade.setBounds(10, 40, 200, 20);
        txtDataValidade.setBounds(220, 40, 100, 20);

        btnCadastrar.setBounds(150, 70, 100, 20);

        // Adicionar componentes ao JFrame
        getContentPane().add(lblNome);
        getContentPane().add(txtNome);
        getContentPane().add(lblDataValidade);
        getContentPane().add(txtDataValidade);
        getContentPane().add(btnCadastrar);

        // Configurações do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150); // Tamanho da janela
        setLocationRelativeTo(null); // Centralizar a janela
        setResizable(false); // Desabilitar redimensionamento
        setVisible(true);
    }
   
    private void popularTabela() {
    List<Produto> produtos = Produto.getProdutos();

    String[][] dados = new String[produtos.size()][2];
    for (int i = 0; i < produtos.size(); i++) {
        Produto produto = produtos.get(i);
        dados[i][0] = produto.getNome();
    }

    String[] colunas = {"Nome", "Data de Validade"};

        DefaultTableModel model = new DefaultTableModel(dados, colunas);
    tblProdutos.setModel(model);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCadastrar) {
            String nome = txtNome.getText();
            String dataValidadeStr = txtDataValidade.getText();

            // Validação de entrada (simplificada)
            if (nome.isEmpty() || dataValidadeStr.isEmpty()) {
                // Exibir mensagem de erro
                System.out.println("Preencha todos os campos!");
                return;
            }

            // Converter data de validade (tratamento de erro omitido)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dataValidade = LocalDate.parse(dataValidadeStr, formatter);

         
            txtNome.setText("");
            txtDataValidade.setText("");
        }
    }

    public static void main(String[] args) {
        new atividade();
    }
}
