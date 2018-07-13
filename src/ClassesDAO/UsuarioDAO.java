/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import biblioteca.Conectar;
import biblioteca.Livros;
import biblioteca.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Rocha
 */
public class UsuarioDAO extends PessoasDAO implements IFuncoesUSER {

    public UsuarioDAO() {
    }

    /*Método que permite ao usuário e administradores vizualizarem todos os livros
    que estão cadastrados e ativos*/
    @Override
    public void adicionarPedidoDeEmprestimo(Livros l, Usuario u) {

        PreparedStatement n = null;

        String sql = "INSERT INTO tb_pedido_emprestimo (tb_pessoas_pes_id, tb_livros_liv_id) "
                + "VALUES (?, ?)";

        try {

            n = Conectar.getConexao().prepareStatement(sql);

            n.setInt(1, u.getId());
            n.setInt(2, l.getId());
            n.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar pedidos de emprestimos \n" + e, "Atenção!", 2);
        }

    }

}
