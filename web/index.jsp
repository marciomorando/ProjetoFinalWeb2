<%-- 
    Document   : index2
    Created on : 21/06/2014, 20:38:08
    Author     : MarcioMorando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/bootstrap.css">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TRABALHO FINAL</title>
    </head>
    <body>
        <style type="text/css">
            body{ margin:0px;font-family:Arial, Tahoma;font-size:12px;color:#666;}
            a.botao_cadastrar{ background-image:url(bt_cadastrar.jpg); background-position:top; height:33px; width:150px; padding-left:10px; padding-right:10px; border:none; cursor:pointer; display:block; font-family:Arial; font-size:13px; color:#FFF; text-decoration:none; line-height:33px; text-align:center; }
            a.botao_cadastrar:hover{ background-position:bottom;}
        </style>
        <table align="center" style="text-align:center;">
            <tr>
                <td>      
                    <img src="unoesc.png" width="125" height="89">       
                </td>       
                <td style="text-align: center">
                    UNIVERSIDADE DO OESTE DE SANTA CATARINA<br>
                    CURSO: ENGENHARIA DA COMPUTAÇÃO<br>
                    DISCIPLINA: PROGRAMAÇÃO PARA WEB II<br>
                    PROFESSOR: EDUARDO COMIN<br>
                    TRABALHO FINAL<br>
                    <b>Márcio Morando</b>
                </td>
               
            </tr>
            <tr>
                <td></td>
                <td align="center" style="font-size:20px"><strong><br /><br /><br />GERENCIADOR DE CHAMADOS</strong></td>
            </tr>
     
        </table>
       
        
        
                   <ul class="nav nav-pills nav-stacked">
  <li align="center" class="active"> <a href="index2.jsp">Home</a></li>
  <li align="center" ><a href="cadastraAtendente.jsp">Cadastrar Atendente</a></li>
  <li align="center" ><a href="cadastraChamado.jsp">Cadastrar Chamado</a></li>
  <li align="center" ><a href="cadastraDepartamento.jsp">Cadastrar Departamento</a></li>
  <li align="center" ><a href="cadastraUsuario.jsp">Cadastrar Usuário</a></li>
  <li align="center" ><a href="mostraChamados1.jsp">Listar Chamados</a></li>
                  </ul>
 
    </body>
</html>