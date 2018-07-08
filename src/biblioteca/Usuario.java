/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

/**
 *
 * @author Rocha
 */
public class Usuario extends Pessoas{
    
    private final String tipo = "USER";
    
    public Usuario(String nome, String login, String senha, int id) {
        super(nome, login, senha, id);
    }
    
    public Usuario(int id){
        super(id);
    }
    
}
