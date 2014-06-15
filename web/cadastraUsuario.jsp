<%-- 
    Document   : cadastraUsuario
    Created on : 14/06/2014, 17:15:03
    Author     : MarcioMorando
--%>

<%@page import="dados.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="dados.Departamento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/bootstrap.css">
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Avaliacao Final</title>
    </head>
    <body>
        <h1><strong>Cadastro de Usuario</strong></h1>

        <fieldset>

        <h3>Digite seu nome:</h3>
        <form name="resultadoForm" action="ServletInsereUsuario" method="POST">
            
            <label for="nome">Nome:</label><br />
            <input type="text" name="nome" id="nome" value="" size="60" /><br />
          
            <br />
            <label for="nome">Departamento:</label><br />
            <select name="departamento">
                <%
                DepartamentoDAO categoriaDao = new DepartamentoDAO();
                for (Departamento categoria: categoriaDao.getDepartamentos()) {
                    out.print("<option value=\""+categoria.getId_departamento()+"\">"+categoria.getNome()+"</option>");
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
