/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import ClassesDAO.AdministradoresDAO;
import ClassesDAO.UsuarioDAO;
import biblioteca.Livros;
import biblioteca.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author walis
 */
public class PedidoDeEmprestimo extends javax.swing.JFrame {

    /**
     * Creates new form PedidoDeEmprestimo
     */
    public PedidoDeEmprestimo(Usuario user) {
        initComponents();
        super.setLocationRelativeTo(null);
        this.user = user;
    }
    
    Usuario user;
    Livros liv;
    UsuarioDAO userDAO = new UsuarioDAO();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        idLivro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        verificarDados = new javax.swing.JButton();
        jLabeLNomeLivro = new javax.swing.JLabel();
        jLabelAutorLivro = new javax.swing.JLabel();
        cancelar = new javax.swing.JButton();
        emprestarLivro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Por favor digite o id do livro");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID DO LIVRO:");

        verificarDados.setText("Verificar Dados");
        verificarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verificarDadosActionPerformed(evt);
            }
        });

        jLabeLNomeLivro.setFont(new java.awt.Font("HP Simplified", 0, 14)); // NOI18N
        jLabeLNomeLivro.setText("NOME DO LIVRO");

        jLabelAutorLivro.setFont(new java.awt.Font("HP Simplified", 0, 14)); // NOI18N
        jLabelAutorLivro.setText("AUTOR DO LIVRO");

        cancelar.setText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        emprestarLivro.setText("Emprestar");
        emprestarLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emprestarLivroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(verificarDados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabeLNomeLivro)
                                .addComponent(jLabelAutorLivro))
                            .addComponent(emprestarLivro))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(verificarDados)
                .addGap(18, 18, 18)
                .addComponent(jLabeLNomeLivro)
                .addGap(18, 18, 18)
                .addComponent(jLabelAutorLivro)
                .addGap(18, 18, 18)
                .addComponent(cancelar)
                .addGap(18, 18, 18)
                .addComponent(emprestarLivro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void verificarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verificarDadosActionPerformed
        // TODO add your handling code here:
        liv = new Livros(Integer.parseInt(idLivro.getText()));
        liv = userDAO.procurarLivro(liv);
        
        jLabeLNomeLivro.setText(liv.getTitulo());
        jLabelAutorLivro.setText(liv.getAutor());
    }//GEN-LAST:event_verificarDadosActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // TODO add your handling code here:
       idLivro.setText("");
       jLabeLNomeLivro.setText("Nome do livro");
       jLabelAutorLivro.setText("Nome do autor do livro");
       
    }//GEN-LAST:event_cancelarActionPerformed

    private void emprestarLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emprestarLivroActionPerformed
        // TODO add your handling code here:
        userDAO.adicionarPedidoDeEmprestimo(liv, user);
        JOptionPane.showMessageDialog(null, "Atenção!\nO pedido foi adicionado!");
    }//GEN-LAST:event_emprestarLivroActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelar;
    private javax.swing.JButton emprestarLivro;
    private javax.swing.JTextField idLivro;
    private javax.swing.JLabel jLabeLNomeLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAutorLivro;
    private javax.swing.JButton verificarDados;
    // End of variables declaration//GEN-END:variables
}
