/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.Conecta;
import dados.Atendente;
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
public class AtendenteDAO {
    
     public String addAtendente(Atendente at) {
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {
                String sql = "INSERT INTO mydb.atendente (nome) "
                        + "VALUES ('"+ at.getNome()+"')"; 
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
    
    public List<Atendente> getAtendentes() {
        List<Atendente> lista = new ArrayList<Atendente>();
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {

                // Vamos preparar o comando SQL:
                String sql = "SELECT id_atendente,nome FROM mydb.atendente";

                // Definido o Statement, executamos o comando no banco de dados.
                ResultSet rs;
                    
            try {
                rs = c.getStm().executeQuery(sql);
            

                    int nregistros = 0;

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) {
                        //leitura dos campos da tabela em vari�veis
                        int cod = rs.getInt("id_atendente");
                        String nome = rs.getString("nome");
                      
                   
                       
                        
                    
                        
                        
                        Atendente at = new Atendente(cod,nome);
                        
                        lista.add(at);
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(AtendenteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
    }
        return lista;
            
    
    }
    
   
    
}
