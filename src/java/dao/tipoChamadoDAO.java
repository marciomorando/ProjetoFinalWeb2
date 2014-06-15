/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.Conecta;
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
public class tipoChamadoDAO {
     public String addtipoChamado(tipoChamado tc) {
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {
                String sql = "INSERT INTO mydb.tipochamado (descricao) "
                        + "VALUES ('"+ tc.getDescricao()+"')"; 
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
    
    public List<tipoChamado> gettipoChamados() {
        List<tipoChamado> lista = new ArrayList<tipoChamado>();
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {

                // Vamos preparar o comando SQL:
                String sql = "SELECT id_tipochamado,descricao FROM mydb.tipochamado";

                // Definido o Statement, executamos o comando no banco de dados.
                ResultSet rs;
                    
            try {
                rs = c.getStm().executeQuery(sql);
            

                    int nregistros = 0;

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) {
                        //leitura dos campos da tabela em vari�veis
                        int cod = rs.getInt("id_tipochamado");
                        String nome = rs.getString("descricao");
                      
                   
                        
                        tipoChamado tc = new tipoChamado(cod,nome);
                        
                        lista.add(tc);
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(tipoChamadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
    }
        return lista;
            
    
    }
    
   
    
}
