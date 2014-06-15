<%-- 
    Document   : mostraChamados
    Created on : 15/06/2014, 14:58:52
    Author     : MarcioMorando
--%>

<%@page import="java.util.List"%>
<%@page import="dados.Chamados"%>
<%@page import="dao.ChamadosDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Listagem de Chamados</title>
    </head>
    <body>
        
        <%
            String msg_exc = request.getParameter("codExcluido");
            if (msg_exc != null) {
                out.println("<h3>Cliente: <strong>"+msg_exc+"</strong> foi excluído com sucesso</h3>");
            }
            
            String msg = request.getParameter("nomeIncluido");
            if (msg != null) {
                out.println("<h3>Cliente: <strong>"+msg+"</strong> foi incluído com sucesso</h3>");
            } else {
                msg = request.getParameter("erro");
                if (msg != null) {
                   out.println("<h3>Erro: <strong>"+msg+"</strong> ao incluir cliente</h3>"); 
                }
            }
           
        // Definido o Statement, executamos o comando no banco de dados.

            out.println("<table border=2px cellpadding=5px cellspacing=0>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Titulo</th>");
            out.println("<th>Descricao</th>");
            out.println("<th>Tipo do Chamado</th>");
            out.println("<th>Classificacao</th>");
            out.println("<th>Atendente</th>");
            out.println("<th>Usuário</th>");
            out.println("</thead>");
            ChamadosDAO clienteDao = new ChamadosDAO();
            List<Chamados> lista = clienteDao.getChamadoss();
            int nregistros = lista.size();
            for (Chamados chamados: lista) {



            // caso existir resultados, percorremos a lista.



                //Exibir os dados na tela.
                out.println("<tr>");
                out.println("<td align='center'>" + chamados.getTitulo() + "</td>");
                out.println("<td>" + chamados.getDescricao()+ "</td>");
                out.println("<td>" + chamados.getTipochamado().getDescricao() + "</td>");
                out.println("<td>" + chamados.getClassificacao().getDescricao() + "</td>");
                out.println("<td>" + chamados.getAtendente().getNome() + "</td>");
                out.println("<td>" + chamados.getUsuario().getNome() + "</td>");

                //link para exclusão
                out.println("<td><form name=\"excluirForm\" action=\"ServletExcluirCliente\" method=\"POST\">");
                out.println("<input type=\"hidden\" name=\"codigo\" id=\"codigo\" value=\""+chamados.getId_chamados()+"\"/>");
                out.println("<input type=\"submit\" value=\"Excluir >>\" name=\"btServletExcluir\" id=\"btServletExcluir\" />");
                out.println("</form></td>");

                out.println("</tr>");
                nregistros++;
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("<br />");
            out.println("<br />Foram encontrados " + nregistros + " registros<br />");

                
            out.println("<a href=\"index.jsp\">Voltar</a> <br />");
            %>
    </body>
</html>
