/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.Conecta;
import dados.Atendente;
import dados.Chamados;
import dados.Classificacao;
import dados.Usuario;
import dados.tipoChamado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MarcioMorando
 */
public class ChamadosDAO {
    public String addChamados(Chamados ch) {
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {
                String sql = "INSERT INTO mydb.chamados (titulo,descricao,tipochamado_id_tipochamado,"
                        + "classificacao_id_classificacao,atendente_id_atendente,usuario_id_usuario) "
                        + "VALUES ('"+ch.getTitulo()+"','"+ch.getDescricao()+"',"+ch.getTipochamado().getId_tipochamado()+","
                        + ""+ch.getClassificacao().getId_classificacao()+","+ch.getAtendente().getId_atendente()+","+ch.getUsuario().getId_usuario()+")"; 
                try {
                    c.getStm().execute(sql);
                    return "sucesso";
                } catch (SQLException ex) {
                    return ("erro:" + ex.getMessage());
                }
            } else {
                return ("erro:" + c.getMsg());
            }
    }
    
     public String ordem = null;
     public String order = null;
     public String titulo_busca = null;
     public String atendente_busca = null;
    
    public List<Chamados> getChamadoss() {
        List<Chamados> lista = new ArrayList<Chamados>();
        
           if(ordem == null && order == null){
            ordem = "id_chamados";
            order = "DESC";
        }
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {

                // Vamos preparar o comando SQL:
   String sql = "select id_chamados,\n" +
"chamados.titulo,\n" +
"chamados.descricao as ch,\n" +
"tipochamado.id_tipochamado,\n" +
"tipochamado.descricao as t,\n" +
"classificacao.id_classificacao,\n" +
"classificacao.descricao as b,\n" +
"atendente.id_atendente,\n" +
"atendente.nome as atendentenome, \n" +
"usuario.id_usuario,\n" +
"usuario.nome as usuario\n" +
"                from mydb.chamados\n" +
"                inner join tipochamado on chamados.tipochamado_id_tipochamado = tipochamado.id_tipochamado\n" +
"                inner join classificacao on chamados.classificacao_id_classificacao = classificacao.id_classificacao \n" +
"                inner join atendente on chamados.atendente_id_atendente = atendente.id_atendente\n" +
"                inner join usuario on chamados.usuario_id_usuario = usuario.id_usuario order by "+ordem+" "+order ;
           
                 if(titulo_busca != null || atendente_busca != null){
                     sql = "select id_chamados,\n" +
"chamados.titulo,\n" +
"chamados.descricao as ch,\n" +
"tipochamado.id_tipochamado,\n" +
"tipochamado.descricao as t,\n" +
"classificacao.id_classificacao,\n" +
"classificacao.descricao as b,\n" +
"atendente.id_atendente,\n" +
"atendente.nome as atendentenome, \n" +
"usuario.id_usuario,\n" +
"usuario.nome as usuario\n" +
"                from mydb.chamados\n" +
"                inner join tipochamado on chamados.tipochamado_id_tipochamado = tipochamado.id_tipochamado\n" +
"                inner join classificacao on chamados.classificacao_id_classificacao = classificacao.id_classificacao \n" +
"                inner join atendente on chamados.atendente_id_atendente = atendente.id_atendente\n" +
"                inner join usuario on chamados.usuario_id_usuario = usuario.id_usuario where chamados.titulo like '%"+titulo_busca+"%' ORDER BY "+ordem+" "+order ;
                 }   

//"select * from mydb.chamados order by "+ordem+" "+order ;
                //if(titulo_busca != null || atendente_busca != null){
                 //   sql = "select * from mydb.chamados where titulo like '%"+titulo_busca+"%'  ORDER BY "+ordem+" "+order ; 
               // }
 
   /*"select id_chamados,chamados.titulo,chamados.descricao,tipochamado.descricao,classificacao.descricao,\n" +
 
   "atendente.nome as atendente, usuario.nome as usuario\n" +
                "from mydb.chamados\n" +
                "inner join tipochamado on chamados.tipochamado_id_tipochamado = tipochamado.id_tipochamado\n" +
                "inner join classificacao on chamados.classificacao_id_classificacao = classificacao.id_classificacao \n" +
                "inner join atendente on chamados.atendente_id_atendente = atendente.id_atendente\n" +
                "inner join usuario on chamados.usuario_id_usuario = usuario.id_usuario";*/
                // Definido o Statement, executamos o comando no banco de dados.
                ResultSet rs;
                    
            try {
                rs = c.getStm().executeQuery(sql);
            

                    int nregistros = 0;

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) {
                        //leitura dos campos da tabela em vari�veis
                        int cod = rs.getInt("id_chamados");
                        String titulo = rs.getString("titulo");
                        String descricao = rs.getString("ch");
                        
                        int codtipoChamado = rs.getInt("id_tipochamado");
                        tipoChamado tc = new tipoChamado();
                        tc.setId_tipochamado(codtipoChamado);
                        
                        String descricaotipoChamado = rs.getString("t");
                        tc.setDescricao(descricaotipoChamado);
                        
                        int codClassificacao = rs.getInt("id_classificacao");
                        Classificacao cl = new Classificacao();
                        cl.setId_classificacao(codClassificacao);
                        
                        String descricaoClassificacao = rs.getString("b");
                        cl.setDescricao(descricaoClassificacao);
                        
                        int codAtendente = rs.getInt("id_atendente");
                        Atendente at = new Atendente();
                        at.setId_atendente(codAtendente);
                        
                        String nomeAtendente = rs.getString("atendentenome");
                        at.setNome(nomeAtendente);
                        
                        int CodUsuario = rs.getInt("id_usuario");
                        Usuario usu = new Usuario();
                        usu.setId_usuario(CodUsuario);
                        
                        String nomeUsuario = rs.getString("usuario");
                        usu.setNome(nomeUsuario);
                        
                        Chamados ch = new Chamados(cod,titulo,descricao,tc,cl,at,usu);
                        
                        lista.add(ch);
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(ChamadosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
    }
        return lista;
            
    
}}
