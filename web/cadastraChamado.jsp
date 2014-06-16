<%-- 
    Document   : cadastraChamado
    Created on : 15/06/2014, 13:02:10
    Author     : MarcioMorando
--%>

<%@page import="dados.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="dados.Atendente"%>
<%@page import="dao.AtendenteDAO"%>
<%@page import="dados.Classificacao"%>
<%@page import="dao.ClassificacaoDAO"%>
<%@page import="dados.tipoChamado"%>
<%@page import="dao.tipoChamadoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/bootstrap.css">
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Avaliacao Final</title>
    </head>
    <body>
        <h1><strong>Cadastro de Chamados</strong></h1>

        <fieldset>

        <h3>Insira os Dados do Chamado:</h3>
        <form name="resultadoForm" action="ServletInsereChamados" method="POST">
            
            <label for="nome">Titulo:</label><br />
            <input type="text" name="titulo" id="titulo" value="" size="60" /><br />
          
            <br />
            
            <label for="nome">Descricao:</label><br />
            <input type="text" name="descricao" id="descricao" value="" size="60" /><br />
          
            <br />
            
            <label for="nome">Tipo do Chamado:</label><br />
            <select name="tipochamado">
                <%
                tipoChamadoDAO categoriaDao = new tipoChamadoDAO();
                for (tipoChamado categoria: categoriaDao.gettipoChamados()) {
                    out.print("<option value=\""+categoria.getId_tipochamado()+"\">"+categoria.getDescricao()+"</option>");
                }
                %>
            </select>

            <br /><br /><br />
            
            <label for="nome">Classificacao:</label><br />
            <select name="classificacao">
                <%
                ClassificacaoDAO categoriaDao1 = new ClassificacaoDAO();
                for (Classificacao categoria: categoriaDao1.getClassificacoes()) {
                    out.print("<option value=\""+categoria.getId_classificacao()+"\">"+categoria.getDescricao()+"</option>");
                }
                %>
            </select>
            <br /><br /><br />
            
            
            <label for="nome">Atendente:</label><br />
            <select name="atendente">
                <%
                AtendenteDAO categoriaDao2 = new AtendenteDAO();
                for (Atendente categoria: categoriaDao2.getAtendentes()) {
                    out.print("<option value=\""+categoria.getId_atendente()+"\">"+categoria.getNome()+"</option>");
                }
                %>
            </select>
            <br /><br /><br />
      
            <label for="nome">Usuario:</label><br />
            <select name="usuario">
                <%
                UsuarioDAO categoriaDao3 = new UsuarioDAO();
                for (Usuario categoria: categoriaDao3.getUsuarios()) {
                    out.print("<option value=\""+categoria.getId_usuario()+"\">"+categoria.getNome()+"</option>");
                }
                %>
            </select>
            <br /><br /><br />
            
            <input type="submit" value="Incluir >>" name="btServlet" id="btServlet" />
        </form>
        </fieldset>
        <hr>
        <br />
        
        
        
        <form name="frmDelete" action="ExcluirServlet" method="POST">
            <input type="hidden" name="codigo" id="codigo" value="" />
        </form>


        <a href="index.jsp">Voltar</a> <br />
    </body>
</html>
