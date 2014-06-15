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
public class Chamados {
    private int id_chamados;
    String titulo;
    String descricao;
    private tipoChamado tipochamado;
    private Classificacao classificacao;
    private Atendente atendente;
    private Usuario usuario;

    public Chamados(int id_chamados, String titulo, String descricao, tipoChamado tipochamado, Classificacao classificacao, Atendente atendente, Usuario usuario) {
        this.id_chamados = id_chamados;
        this.titulo = titulo;
        this.descricao = descricao;
        this.tipochamado = tipochamado;
        this.classificacao = classificacao;
        this.atendente = atendente;
        this.usuario = usuario;
    }
    
    public Chamados(){
        
    }

    public int getId_chamados() {
        return id_chamados;
    }

    public void setId_chamados(int id_chamados) {
        this.id_chamados = id_chamados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public tipoChamado getTipochamado() {
        return tipochamado;
    }

    public void setTipochamado(tipoChamado tipochamado) {
        this.tipochamado = tipochamado;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    
}
