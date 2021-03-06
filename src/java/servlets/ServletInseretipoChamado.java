/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import dados.tipoChamado;
import dao.tipoChamadoDAO;
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
@WebServlet(name = "ServletInseretipoChamado", urlPatterns = {"/ServletInseretipoChamado"})
public class ServletInseretipoChamado extends HttpServlet {

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
            out.println("<title>Servlet InseretipoChamado</title>");
            out.println("</head>");
            out.println("<body>");
            
            
            tipoChamado tc = new tipoChamado();
            
            String descricao = request.getParameter("descricao");
            tc.setDescricao(descricao);
        
            tipoChamadoDAO cliDao = new tipoChamadoDAO();
            String msg = cliDao.addtipoChamado(tc);
            if (msg.equals("sucesso")) {
                out.println("Inserido tipoChamado"+tc.getDescricao());
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
