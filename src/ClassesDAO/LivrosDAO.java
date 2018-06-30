/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import biblioteca.Conectar;
import biblioteca.Conexoes;
import biblioteca.Livros;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Rocha
 */
public class LivrosDAO implements Conexoes {

    PreparedStatement n = null;

    @Override
    public void add(Livros l) {

        String sql = "INSERT INTO livros (titulo, autor, area, editora) VALUES (?, ?, ?, ?)";

        try {
            n = Conectar.getConexao().prepareStatement(sql);

            n.setString(1, l.getTitulo());
            n.setString(2, l.getAutor());
            n.setString(3, l.getArea());
            n.setString(4, l.getEditora());

            n.executeUpdate();
            n.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel adicionar um "
                    + "novo livro banco de dados", "Atenção!", 2);
        }

    }

    @Override
    public ArrayList selecionar() {

        ArrayList<Livros> livros = new ArrayList();

        String sql = "SELECT titulo, autor, area, numero editora FROM livros";

        try {
            n = Conectar.getConexao().prepareStatement(sql);
            ResultSet rs = n.executeQuery();

            while (rs.next()) {
                livros.add(new Livros(rs.getString("titulo"), rs.getString("autor"),
                        rs.getString("area"), rs.getString("editora"), rs.getString("numero")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar procurar livros!", "Atenção!", 2);
        }
        return livros;
    }

    @Override
    public void deletar(int numero) {
        
        String sql = "UPDATE livros SET estado = 0 WHERE estado = ?";
        
        try {
            
            n = Conectar.getConexao().prepareCall(sql);
            
            n.setInt(1, numero);
            
            n.executeUpdate();
            n.close();
                    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar remover livro!", "Atenção!", 2);
        }
        
    }

    @Override
    public void atualizar(Livros l) {
        
        String sql = "UPDATE livros SET titulo = ?, autor = ?, editora = ?, area = ? WHERE numero = ?";
        
        try {
            
            n = Conectar.getConexao().prepareStatement(sql);
            
            n.setString(1, l.getTitulo());
            n.setString(2, l.getAutor());
            n.setString(3, l.getAutor());
            n.setString(4, l.getArea());
            n.setString(5, l.getNumero());
            
            n.executeUpdate();
            n.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar atualizar livro!", "Atenção!", 2);
        }
        
    }

    @Override
    public Livros prucurarNumero(String numero) {
        
        String sql = "SELECT titulo, autor, area, editora FROM livros WHERE numero = ?";
        
        try {
            
            n = Conectar.getConexao().prepareStatement(sql);
            
            n.setString(1, numero);
            
            ResultSet rs = n.executeQuery();
            
            if(rs.next()){
                
               Livros l = new Livros(rs.getString("titulo"), rs.getString("autor"), 
                       rs.getString("area"), rs.getString("editora"));
               
               return l;                
            }                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar encontrar livro!", "Atenção!", 2);
        }
        
        return null;
    }

}
