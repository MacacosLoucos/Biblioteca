/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import ClassesDAO.AdministradoresDAO;
import ClassesDAO.PessoasDAO;

/**
 *
 * @author walis
 */
public class teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       Administrador ad = new Administrador("WALI20", "456");
       PessoasDAO pesDAO = new AdministradoresDAO();
       pesDAO.tipoPessoa(ad);
       System.out.println(ad.getTipo());
       
    }
    
}
