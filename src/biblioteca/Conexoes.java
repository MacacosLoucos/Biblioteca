/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;

/**
 *
 * @author Rocha
 */
public interface Conexoes {
    
    void add(Livros l);
    ArrayList selecionar();
    void deletar(int numero);
    void atualizar(Livros l);
    Livros prucurarNumero(String numero);
    
}
