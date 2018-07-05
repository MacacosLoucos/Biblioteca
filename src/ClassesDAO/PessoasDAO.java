/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import biblioteca.Administrador;
import biblioteca.Conectar;
import biblioteca.Livros;
import biblioteca.Pessoas;
import biblioteca.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rocha
 */
public abstract class PessoasDAO {

    /*Método que permite a visualização dos livro cadastrado e ativos da biblioteca*/
    public ArrayList<Livros> vizualizar() {//Metodo retorna os livros que estão cadastrados tanto para ADM e USER

        ArrayList<Livros> l = new ArrayList();

        String sql = "SELECT liv_titulo, liv_autor, liv_area, liv_editora, "
                + "liv_quantidade FROM tb_livros WHERE liv_estado = 0;";

        PreparedStatement n = null;

        try {
            n = Conectar.getConexao().prepareStatement(sql);

            ResultSet rs = n.executeQuery();

            while (rs.next()) {

                Livros x = new Livros(rs.getString("liv_titulo"),
                        rs.getString("liv_autor"), rs.getString("liv_editora"),
                        rs.getString("liv_area"), rs.getInt("liv_quantidade"));

                l.add(x);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível procurar por livros \n " + e, "Atenção!", 2);
        }

        return l;
    }

    public Pessoas tipoPessoa(Pessoas p) {

        PreparedStatement n = null;

        Administrador a = null;
        Usuario u = null;

        String sql = "SELECT * FROM tb_pessoas p INNER JOIN tb_permissoes e ON"
                + "(p.permissoes_per_id = e.per_id) WHERE p.pes_login = ? AND"
                + "p.pes_senha = ?;";

        try {

            n = Conectar.getConexao().prepareStatement(sql);

            n.setString(1, p.getLogin());
            n.setString(2, p.getSenha());

            ResultSet rs = n.executeQuery();

            if (rs == null) {
                return null;
            }

            if (rs.next()) {
                if (rs.getInt("per_id") == 1) {
                    a = (Administrador) p;
                    return a;
                } else {
                    u = (Usuario) p;
                    return u;
                }

            }

        } catch (SQLException e) {
        }
        return null;
    }

}
