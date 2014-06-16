<%-- 
    Document   : mostraChamados1
    Created on : 15/06/2014, 21:53:01
    Author     : MarcioMorando
--%>

<%@page import="dados.Chamados"%>
<%@page import="dao.ChamadosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>A1/1</title>        
    </head>
    <body>        
        <style type="text/css">
            body{ margin:0px;font-family:Arial, Tahoma;font-size:12px;color:#666;}
            .enviar{ background-image:url(bt_cadastrar.jpg); background-position:top; height:33px; width:150px; padding-left:10px; padding-right:10px; border:none; cursor:pointer; display:block; font-family:Arial; font-size:13px; color:#FFF; text-decoration:none; line-height:33px; text-align:center; }
            .enviar:hover { background-position:bottom;}
            .alterar{ background-image:url(alterar.jpg); width: 29px; height: 28px; border: 0; }
            .excluir{ background-image:url(apagar.jpg); width: 29px; height: 28px; border: 0; }
            .error {color:#F00;}
        </style>        
        <%                
        try { 
            ChamadosDAO chamadosDao = new ChamadosDAO();
        %>
         <table align="center" style="text-align:center;">            
                <tr>
                    <td></td>
                    <td style="font-size:20px"><strong>Gerenciador de Chamados</strong></td>
                </tr>
                <tr>
                    <td></td>
                    <td style="font-size:16px"><strong>Listar Chamados</strong></td>
                </tr>
         </table>
         <br><br><br>
         <form action="mostraChamados1.jsp" method="GET">
            <table>
               <tr>
                   <td width="300px" align="right">Pesquisar pelo TITULO do Chamado:</td>
                   <td><input type="text" name="titulo" size="30"></td>
                   <td><input type="submit" value="buscar"></td>   
               </tr>
           </table>
             
            <table>
               <tr>
                   <td width="300px" align="right">Pesquisar pelo ATENDENTE do Chamado:</td>
                   <td><input type="text" name="atendente" size="30"></td>
                   <td><input type="submit" value="buscar"></td>   
               </tr>
           </table>  
         </form> 
        <%
         String titulo_busca = new String();
        titulo_busca = request.getParameter("titulo");       
        chamadosDao.titulo_busca = titulo_busca;
        %>
        
        
         <br><br><br>
        <%
      String atendente_busca = new String();
      atendente_busca = request.getParameter("atendente");
      chamadosDao.atendente_busca = atendente_busca;
        %>
        
         <table width="auto" align="center" style="text-align:center;"> 
            <tr>
                <td width="29px"></td>
                <td width="29px"></td>
                <td width="80px"><strong>ID Chamado</strong></td>
                <td width="80px"><strong>Titulo</strong></td>
                <td width="80px"><strong>Descrição</strong></td>
                <td width="80px"><strong>Tipo Chamado</strong></td>
                <td width="80px"><strong>Classificação</strong></td>
                <td width="80px"><strong>Atendente</strong></td>
                <td width="80px"><strong>Usuário</strong></td>                    
              
                
            </tr>                
                <% 
                int a = 0; 
                for (Chamados ch : chamadosDao.getChamadoss() ) { 
                    a++;                    
                %>
                
               
                    <tr>
                        <td>
                          
                        <td>
                            <form action="excluirMotorista.jsp" method="POST">
                                <input type="hidden" name="id" value="<% out.print(ch.getId_chamados()); %>">
                             
                                <input type="submit" name="excluir" class="excluir" value="">
                            </form>
                        </td>                        
                        <td><% out.println(ch.getId_chamados()); %></td>
                         <td><% out.println(ch.getTitulo()); %></td>
                         <td><% out.println(ch.getDescricao()); %></td>
                        <td><% out.println(ch.getTipochamado().getDescricao()); %></td>
                        <td><% out.println(ch.getClassificacao().getDescricao()); %></td>
                        <td><% out.println(ch.getAtendente().getNome()); %></td>
                        <td><% out.println(ch.getUsuario().getNome()); %></td>
                        
                       
                    </tr>
                    <tr>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                        <td><hr></td>
                    </tr>
                <% 
                }                
                %>
        </table>
        <% if(a == 0){ out.println("<br><br><center><strong style='color:#F00'>Nenhum chamado encontrado em sua busca!</strong></center><br><br>"); };%>
        <table style="margin-left:225px">
            <tr>               
                <td>
                    <a href="index.jsp" class="enviar" style="width:130px">Voltar</a>                    
                </td>
                <td><a href="cadastraChamado.jsp" style="width:130px" class="enviar">Cadastrar Chamado</a></td>
            </tr>            
        </table>  

        <% 
        } catch (Exception e) {
            out.print(e.getMessage());
        }  finally {
            out.close();
        }
        %>        
    </body>
</html>
