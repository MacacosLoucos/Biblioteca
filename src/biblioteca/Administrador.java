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
public class Administrador extends Pessoas{
    
    private final String tipo = "ADM";
    
    public Administrador(String nome, String login, String senha, int id) {
        super(nome, login, senha, id);
    }

    public Administrador(String login, String senha) {
        super(login, senha);
    }
    

    public String getTipo() {
        return tipo;
    }
    
}
