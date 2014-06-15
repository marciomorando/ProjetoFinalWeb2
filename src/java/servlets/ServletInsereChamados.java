/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import dados.Atendente;
import dados.Chamados;
import dados.Classificacao;
import dados.Usuario;
import dados.tipoChamado;
import dao.ChamadosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MarcioMorando
 */
@WebServlet(name = "ServletInsereChamados", urlPatterns = {"/ServletInsereChamados"})
public class ServletInsereChamados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsereChamados</title>");
            out.println("</head>");
            out.println("<body>");
            
            
            Chamados ch = new Chamados();
            
            String temp = request.getParameter("titulo");
            ch.setTitulo(temp);
            
            temp = request.getParameter("descricao");
            ch.setDescricao(temp);
            
            temp = request.getParameter("tipochamado");
            tipoChamado tc = new tipoChamado();
            tc.setId_tipochamado(Integer.parseInt(temp));
            ch.setTipochamado(tc);
            
            temp = request.getParameter("classificacao");
            Classificacao cl = new Classificacao();
            cl.setId_classificacao(Integer.parseInt(temp));
            ch.setClassificacao(cl);
            
            temp = request.getParameter("atendente");
            Atendente at = new Atendente();
            at.setId_atendente(Integer.parseInt(temp));
            ch.setAtendente(at);
            
            temp = request.getParameter("usuario");
            Usuario usu = new Usuario();
            usu.setId_usuario(Integer.parseInt(temp));
            ch.setUsuario(usu);
        
            ChamadosDAO cliDao = new ChamadosDAO();
            String msg = cliDao.addChamados(ch);
            if (msg.equals("sucesso")) {
                //out.println("Inserido Usuario"+usu.getNome());
                //response.sendRedirect("mostraDados.jsp?nomeIncluido="+cli.getNome_pessoa());
            } else {
                out.println("Erro: "+msg);
            }
            
            out.println("</body>");
            out.println("</html>");
            

        } catch (Exception e) {
            out.println("erro:" + e);
        } finally {
            out.println("<br /> <a href=\"index.jsp\">Voltar</a> <br />");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
