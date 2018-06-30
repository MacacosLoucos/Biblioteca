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
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rocha
 */
public class UsuarioDAO extends PessoasDAO implements IFuncoesUSER {

    
    /*Método que permite ao usuário e administradores vizualizarem todos os livros
    que estão cadastrados e ativos*/
    @Override
    public void adicionarPedidoDeEmprestimo(ArrayList<Livros> l, Usuario u) {

        PreparedStatement n = null;

        String sql = "INSERT INTO tb_predido_emprestimo (tb_pessoas_pes_id, tb_livros_liv_id) "
                + "SELECT pes_id, liv_id FROM tb_livros l "
                + "INNER JOIN tb_pessoas p ON (p.pes_id = ?) "
                + "WHERE l.liv_estado = 0 AND liv_id = ?;";

        try {

            n = Conectar.getConexao().prepareStatement(sql);

            for (Livros x : l) {

                n.setInt(1, u.getId());
                n.setInt(2, x.getId());
                n.execute();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar pedidos de emprestimos \n" + e, "Atenção!", 2);
        }

    }

 
}
