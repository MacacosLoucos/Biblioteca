/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import biblioteca.Usuario;

/**
 *
 * @author walis
 */
public class TelaUsuario extends javax.swing.JFrame {

    /**
     * Creates new form TelaUsuario
     *
     * @param user
     */
    public TelaUsuario(Usuario user) {
        initComponents();
        super.setLocationRelativeTo(null);
        this.user = user;
    }

    Usuario user;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pedidoEmprestimo = new javax.swing.JButton();
        procurar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("OLÁ, SELECIONE UMA OPÇÃO ABAIXO PARA PROSSEGUIRMOS");

        pedidoEmprestimo.setText("Realizar pedido de emprestimo");
        pedidoEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidoEmprestimoActionPerformed(evt);
            }
        });

        procurar.setText("Procurar livro");
        procurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procurarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(procurar)
                    .addComponent(pedidoEmprestimo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(pedidoEmprestimo)
                .addGap(18, 18, 18)
                .addComponent(procurar)
                .addContainerGap(265, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pedidoEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidoEmprestimoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_pedidoEmprestimoActionPerformed

    private void procurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procurarActionPerformed
        // TODO add your handling code here:
        Procurar p = new Procurar(user);
        p.setVisible(true);
        
    }//GEN-LAST:event_procurarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton pedidoEmprestimo;
    private javax.swing.JButton procurar;
    // End of variables declaration//GEN-END:variables
}
