/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import biblioteca.Livros;
import biblioteca.Usuario;

/**
 *
 * @author Rocha
 */
public interface IFuncoesUSER {
 
    void adicionarPedidoDeEmprestimo(Livros l, Usuario u);
    
}
