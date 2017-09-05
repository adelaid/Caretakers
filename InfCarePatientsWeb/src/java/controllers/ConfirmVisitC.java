/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.Visit;
import ws.VisitWS_Service;

/**
 *
 * @author Ada
 */
@WebServlet(name = "ConfirmVisitC", urlPatterns = {"/ConfirmVisitC"})
public class ConfirmVisitC extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/VisitWS/VisitWS.wsdl")
    private VisitWS_Service service;

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
//        String query=request.getParameter("query");
//        Long q= Long.parseLong(query);
//        confirmVisit(q);
       

        List<Visit> pVisits = (List<Visit>) request.getSession().getAttribute("proposedvisits");
        int i = (Integer) request.getSession().getAttribute("i");
        System.out.println(i);
        if (request.getParameter("act").equals("yes") ) {
//          for(int j=0;j<ptm.size();j++){
//          //        String data=seconds(timeRef.getStartTime());
            Long q = pVisits.get(i).getId();
            confirmVisit(q);
        }
        request.getSession().setAttribute("i", i + 1);

        if (i == pVisits.size()-1) {
            request.getRequestDispatcher("ProposedVisitsC").forward(request, response);
            System.out.println("f");
        } else {
            request.getRequestDispatcher("ProposedVisitsJSP.jsp").forward(request, response);
            System.out.println("a");
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

    private void confirmVisit(java.lang.Long visitId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.VisitWS port = service.getVisitWSPort();
        port.confirmVisit(visitId);
    }

}
