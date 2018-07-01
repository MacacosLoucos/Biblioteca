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
public class Exemplar extends Livros {

    private String numero;
    private int disponibilidade;

    public Exemplar(String numero, String titulo, String autor, String editora, String area, int quantidade) {
        super(titulo, autor, editora, area, quantidade);
        this.numero = numero;
        this.disponibilidade = 1;
    }

    public Exemplar(String numero) {
        this.numero = numero;
        this.disponibilidade = 1;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

}
