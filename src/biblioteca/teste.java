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

        Conectar n = new Conectar();
        n.conect();

        PessoasDAO pesDAO = new PessoasDAO() {
        };

        Pessoas a = pesDAO.tipoPessoa("WALI20", "456");
        Administrador b = null;
        Usuario c = null;

        if (a instanceof Administrador) {
            b = (Administrador) a;

        } else if (a instanceof Usuario) {
            c = (Usuario) a;

        }

        System.out.println(b.getTipo());

    }

}
