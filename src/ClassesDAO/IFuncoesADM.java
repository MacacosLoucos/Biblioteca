/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import biblioteca.Administrador;
import biblioteca.Exemplar;
import biblioteca.Livros;
import biblioteca.Usuario;

/**
 *
 * @author Rocha
 */
public interface IFuncoesADM {
    
    void cadastrar(Livros l, Administrador a);
    void atualizar(Livros l, Administrador a);
    void deletar(Livros l, Administrador a);
    void emprestar(Exemplar l, Usuario u);
    void devolverLivro(Exemplar x, Usuario u);
}
