/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Rocha
 */
public class Conectar {
    
    private static Connection conexao = null;
    
    
    public void conect ()
    {
        String url = "jdbc:mysql://localhost/db_biblioteca";
        String usuario = "root";
        String senha = "";
        
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi possivel se conectar com o banco de dados", "Atenção!", 2);
            System.exit(0);
        }
    }

    public static Connection getConexao() {
        return conexao;
    }

    public static void setConexao(Connection conexao) {
        Conectar.conexao = conexao;
    }
    
    
    
}
