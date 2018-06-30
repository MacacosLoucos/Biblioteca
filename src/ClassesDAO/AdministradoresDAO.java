/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import biblioteca.Administrador;
import biblioteca.Conectar;
import biblioteca.Exemplar;
import biblioteca.Livros;
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
public class AdministradoresDAO extends PessoasDAO implements IFuncoesADM {

    private int ultimoIdLivro() {
        PreparedStatement n = null;
        String sql = "SELECT max(liv_id) as id FROM tb_livros;";
        int valorID = 0;
        try {

            n = Conectar.getConexao().prepareStatement(sql);

            ResultSet rs = n.executeQuery();

            if (rs.next()) {
                valorID = rs.getInt("id");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível procurar o id do livro", "Atenção!", 2);
        }
        return valorID;
    }

    private void excluirExemplares(Livros l) {

        PreparedStatement n = null;

        String sql = "DELETE FROM tb_exemplar WHERE exe_numero LIKE '?%';";

        try {
            n = Conectar.getConexao().prepareStatement(sql);

            n.setString(1, l.getId() + "");

            n.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir os livros", "Atenção!", 2);
        }

    }

    private void adicionarExemplares(Livros l) {

        PreparedStatement n = null;

        String sql = "INSERT INTO tb_exemplar (exe_numero, exe_disponibilidade, "
                + "tb_livros_liv_id) VALUES (?, ?, ?);";

        int id = l.getId();

        if (id == 0) {
            id = this.ultimoIdLivro();
        } else {
            this.excluirExemplares(l);
        }

        char letra = 'A';

        try {
            n = Conectar.getConexao().prepareStatement(sql);

            for (int i = 0; i < l.getQuantidade(); i++) {

                n.setString(1, "" + id + "" + letra);
                n.setInt(2, 0);
                n.setInt(3, id);
                letra++;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível adicionar novos exemplares", "Atenção!", 2);
        }

    }

    private void alterarDisponibilidade(Exemplar x) {

        PreparedStatement n = null;

        String sql = "UPDATE tb_exemplar SET exe_disponibilidade = 1 WHERE exe_numero = ?";

        try {

            n = Conectar.getConexao().prepareStatement(sql);

            n.setString(1, x.getNumero());

            n.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a disponibilidade", "Atenção!", 2);
        }

    }

    @Override
    public void cadastrar(Livros l, Administrador a) {
        PreparedStatement n = null;

        String sql = "INSERT INTO tb_livros (liv_titulo, liv_autor, liv_area, "
                + "liv_editora, liv_data_cadastro, liv_data_atualizacao, "
                + "liv_quantidade, tb_pessoas_pes_id) VALUES (?, ?, ?, ?, NOW(), NOW(), ?, ?);";

        try {

            n = Conectar.getConexao().prepareStatement(sql);

            n.setString(1, l.getTitulo());
            n.setString(2, l.getAutor());
            n.setString(3, l.getArea());
            n.setString(4, l.getEditora());
            n.setInt(5, l.getQuantidade());
            n.setInt(6, a.getId());

            n.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar um novo livro", "Atenção!", 2);
        }

        this.adicionarExemplares(l);

    }

    @Override
    public void atualizar(Livros l, Administrador a) {
        PreparedStatement n = null;

        String sql = "UPDATE tb_livros SET liv_titulo = ?, liv_autor = ?,"
                + "liv_area = ?, liv_editora = ?, liv_quantidade, liv_data_atualizacao = NOW(),"
                + "tb_pessoa_pes_id = ? WHERE liv_id = ?;";

        try {
            n = Conectar.getConexao().prepareStatement(sql);

            n.setString(1, l.getTitulo());
            n.setString(2, l.getAutor());
            n.setString(3, l.getArea());
            n.setString(4, l.getEditora());
            n.setInt(5, l.getQuantidade());
            n.setInt(6, a.getId());
            n.setInt(7, l.getId());

            n.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar livro", "Atenção!", 2);
        }

        this.adicionarExemplares(l);

    }

    @Override
    public void deletar(Livros l, Administrador a) {

        PreparedStatement n = null;

        String sql = "UPDATE tb_livros SET liv_estado = 1, tb_pessoas_pes_id = ? WHERE liv_id = ?;";

        try {

            n = Conectar.getConexao().prepareStatement(sql);

            n.setInt(1, a.getId());
            n.setInt(2, l.getId());

            n.executeUpdate();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o livro", "Atenção!", 2);
        }

    }

    @Override
    public void emprestar(ArrayList<Exemplar> l, Usuario u) {

        PreparedStatement n = null;

        String sql = "INSERT INTO tb_emprestimos (tb_pessoas_pes_id, tb_exemplar_numero) "
                + "SELECT pes_id, exe_numero FROM tb_exemplar e "
                + "INNER JOIN tb_pessoas p ON (p.pes_id = ?) "
                + "INNER JOIN tb_livros l ON (l.liv_id = e.tb_livros_liv_id"
                + "AND l.liv_id = ? AND l.liv_estado = 0) "
                + "WHERE e.exe_disponibilidade = 0;";

        try {

            n = Conectar.getConexao().prepareStatement(sql);

            for (Exemplar x : l) {

                n.setInt(1, u.getId());
                n.setInt(2, x.getId());
                n.execute();
                this.alterarDisponibilidade(x);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível realizar emprestimos", "Atenção!", 2);
        }

    }

}
