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
public class tipoChamado {
    private int id_tipochamado;
    String descricao;

    public tipoChamado(int id_tipochamado, String descricao) {
        this.id_tipochamado = id_tipochamado;
        this.descricao = descricao;
    }
    
    public tipoChamado(){
        
    }

    public int getId_tipochamado() {
        return id_tipochamado;
    }

    public void setId_tipochamado(int id_tipochamado) {
        this.id_tipochamado = id_tipochamado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
