/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabaiogit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class atividade extends JFrame implements ActionListener {

    JButton btnOK = new JButton("Click");
   
    public atividade() {
        setLayout(null);
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Atividade Git");
       
        btnOK.setBounds(300, 250, 100, 50);
       
        add(btnOK);
       
        btnOK.addActionListener(this);
    }

        public static void main(String[] args) {
             atividade teste = new atividade();
             teste.setVisible(true);
         }

     @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnOK)) {
            JOptionPane.showMessageDialog(this, "mensagem");
        } else {
            System.exit(0);
        }
    }
}
