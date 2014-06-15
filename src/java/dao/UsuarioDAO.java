/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import conexao.Conecta;
import dados.Departamento;
import dados.Usuario;
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
public class UsuarioDAO {
     public String addUsuario(Usuario usu) {
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {
                String sql = "INSERT INTO mydb.usuario (nome,departamento_id_departamento) "
                        + "VALUES ('"+ usu.getNome()+"',"+usu.getDepartamento().getId_departamento()+")"; 
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
    
    public List<Usuario> getUsuarios() {
        List<Usuario> lista = new ArrayList<Usuario>();
        
        Conecta c = new Conecta();

            if ("sucesso".equals(c.getMsg())) {

                // Vamos preparar o comando SQL:
                String sql ="select * from mydb.usuario"; //"SELECT usuario.nome,departamento.nome from mydb.usuario inner join\n" +
//"                 departamento on usuario.departamento_id_departamento = departamento.id_departamento";

                // Definido o Statement, executamos o comando no banco de dados.
                ResultSet rs;
                    
            try {
                rs = c.getStm().executeQuery(sql);
            

                    int nregistros = 0;

                    // caso existir resultados, percorremos a lista.
                    while (rs.next()) {
                        //leitura dos campos da tabela em vari�veis
                        int cod = rs.getInt("id_usuario");
                        String nome = rs.getString("nome");
                        
                        int codDepartamento = rs.getInt("departamento_id_departamento");
                        Departamento dp = new Departamento();
                        dp.setId_departamento(codDepartamento);
                        
                        String nomeDepartamento = rs.getString("nome");
                        dp.setNome(nomeDepartamento);
                        
                        Usuario usu = new Usuario(cod,nome,dp);
                        
                        lista.add(usu);
                    }
                
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return lista;
    }
        return lista;
            
    
    }
    
   
}
