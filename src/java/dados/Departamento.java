/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dados;

/**
 *
 * @author MarcioMorando
 */
public class Departamento {
    private int id_departamento;
    String nome;
    String descricao;

    public Departamento(int id_departamento, String nome, String descricao) {
        this.id_departamento = id_departamento;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    public Departamento(){
        
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
