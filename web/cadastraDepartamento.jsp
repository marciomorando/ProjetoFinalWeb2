<%-- 
    Document   : cadastraDepartamento
    Created on : 15/06/2014, 12:19:44
    Author     : MarcioMorando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/bootstrap.css">
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Avaliacao Final</title>
    </head>
    <body>
        <h1><strong>Cadastro de Departamento</strong></h1>

        <fieldset>

        <h3>Digite o nome do Departamento:</h3>
        <form name="resultadoForm" action="ServletInsereDepartamento" method="POST">
            
            <label for="nome">Nome:</label><br />
            <input type="text" name="nome" id="nome" value="" size="60" required/><br />
          
            <br />
            
            <label for="nome">Descrição:</label><br />
            <input type="text" name="descricao" id="descricao" value="" size="60" required/><br />
          
            <br />
            
        
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
