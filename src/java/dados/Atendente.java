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
public class Atendente {
    private int id_atendente;
    String nome;
    
    

    public Atendente(int id_atendente, String nome) {
        this.id_atendente = id_atendente;
        this.nome = nome;
    }
    
    public Atendente(){
        
    }

    public int getId_atendente() {
        return id_atendente;
    }

    public void setId_atendente(int id_atendente) {
        this.id_atendente = id_atendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    
    
}
