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
public class Livros {

    private String titulo;
    private String autor;
    private String editora;
    private String area;
    private int id;
    private int id_administrador;
    private String data_de_atualizacao;
    private String data_de_cadastro;
    private int quantidade;
    private int estado;

    public Livros(String titulo, String autor, String editora, String area, int quantidade) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.area = area;
        this.quantidade = quantidade;
    }

    public Livros(String titulo, String autor, String editora, String area, int id, int id_administrador, String data_de_atualizacao,
            String data_de_cadastro, int quantidade, int estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.area = area;
        this.id = id;
        this.id_administrador = id_administrador;
        this.data_de_atualizacao = data_de_atualizacao;
        this.data_de_cadastro = data_de_cadastro;
        this.quantidade = quantidade;
        this.estado = estado;
    }

    public Livros() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }

    public String getData_de_atualizacao() {
        return data_de_atualizacao;
    }

    public void setData_de_atualizacao(String data_de_atualizacao) {
        this.data_de_atualizacao = data_de_atualizacao;
    }

    public String getData_de_cadastro() {
        return data_de_cadastro;
    }

    public void setData_de_cadastro(String data_de_cadastro) {
        this.data_de_cadastro = data_de_cadastro;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Livros{" + "titulo=" + titulo + ", autor=" + autor + ", editora=" + editora + ", area=" + area + ", id=" + id + ", id_administrador=" + id_administrador + ", data_de_atualizacao=" + data_de_atualizacao + ", data_de_cadastro=" + data_de_cadastro + ", quantidade=" + quantidade + '}';
    }

}
