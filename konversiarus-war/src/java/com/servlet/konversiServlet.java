/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.konversiarus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lian CahJaya
 */
public class konversiServlet extends HttpServlet {

    @EJB
    private konversiarus konversiarus;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body");
            out.println("<h1><center>Tugas RSBK Dasar Elektronika</center></h1>");
            String elek = request.getParameter("elek");
            String elek2 = request.getParameter("elek2");
            
            if ((elek != null) && (elek.length() > 0) && (elek2 != null) && (elek2.length() > 0)) {
                double d = Double.parseDouble(elek);
                double e = Double.parseDouble(elek2);
                if (request.getParameter("Tegangan") != null){
                    String tegangan = konversiarus.tegangan(d, e);
                    out.println("<p> Hasil Tegangan: "+tegangan+"</p>");
                }  
                if (request.getParameter("Hambatan") != null) {
                    String hambatan = konversiarus.hambatan(d, e);
                    out.println("<p> Hasil Hambatan: "+hambatan+ " .</p>");
                }
                if (request.getParameter("Arus") != null) {
                    String arus = konversiarus.arus(d, e);
                    out.println("<p> Hasil Arus: " +arus+ " .</p>");
                }
                
            } else {
                out.println("<center>");
                out.println("<p>Masukan yang anda ketahui !</p>");
                out.println("<form method=\"get\">");
                out.println("<p>Input 1 : <input type=\"text\" name=\"elek\" size=\"20\"></p>"+"<p>Input 2 : <input type=\"text\" name=\"elek2\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<p>Pilih yang ingin anda cari !</p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"Arus\" value=\"Arus\">"+ "<input type=\"submit\" name=\"Hambatan\" value=\"Hambatan\">"+ "<input type=\"submit\" name=\"Tegangan\" value=\"Tegangan\">");
                out.println("<br/>");
                out.println("<p>Catatan Rumus</p>");
                out.println("<p>Untuk mencari Arus masukan Input 1 = Tegangan(v) dan Input 2 = Hambatan(R) </p>");
                out.println("<p>Untuk mencari Tegangan masukan Input 1 = Arus(A) dan Input 2 = Hambatan(R) </p>");
                out.println("<p>Untuk mencari Hambatan masukan Input 1 = Tegangan(v) dan Input 2 = Arus(A) </p>");
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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
