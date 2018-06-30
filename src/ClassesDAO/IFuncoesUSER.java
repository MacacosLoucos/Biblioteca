/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import biblioteca.Exemplar;
import biblioteca.Livros;
import biblioteca.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Rocha
 */
public interface IFuncoesUSER {
 
    void adicionarPedidoDeEmprestimo(ArrayList<Livros> l, Usuario u);
    
}
