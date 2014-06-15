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
public class Classificacao {
    private int id_classificacao;
    String descricao;

    public Classificacao(int id_classificacao, String descricao) {
        this.id_classificacao = id_classificacao;
        this.descricao = descricao;
    }
    
    public Classificacao(){
        
    }

    public int getId_classificacao() {
        return id_classificacao;
    }

    public void setId_classificacao(int id_classificacao) {
        this.id_classificacao = id_classificacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
