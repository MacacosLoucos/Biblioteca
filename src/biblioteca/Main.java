/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import ClassesDAO.AdministradoresDAO;
import ClassesDAO.UsuarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Rocha
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Conectar  c = new Conectar();
        c.conect();
       
        AdministradoresDAO u = new AdministradoresDAO();
        
        Administrador n = new Administrador("", "", "", 1);
        
        Livros f = new Livros();
        f.setId(7);
       
       Livros l = new Livros();
       
       u.atualizar(l, n);
        
    }
    
}
