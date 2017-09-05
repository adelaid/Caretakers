/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.Patient;
import ws.Visit;
import ws.VisitWS_Service;

/**
 *
 * @author Ada
 */
@WebServlet(name = "ProposedVisitsC", urlPatterns = {"/ProposedVisitsC"})
public class ProposedVisitsC extends HttpServlet {

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
        Patient pt = (Patient) request.getSession().getAttribute("user");
        List<Visit> visits = getVisitsByPatient(pt.getUsername());
        List<Visit> visitsProposed = new ArrayList<Visit>();
        for (Visit v : visits) {
            if (v.getConfirmed().equals("NO")) {
                visitsProposed.add(v);
               // v.getMatchtot();
               
            }

        }
         Collections.sort(visitsProposed, new Comparator<Visit>() {  
 
     

            @Override
            public int compare(Visit o1, Visit o2) {
              
               return Double.compare(o1.getMatchtot(),o2.getMatchtot());
            }
        }); 
                   Collections.reverse(visitsProposed);

//        for (Visit v : visitsProposed) {
//            System.out.println("vId " + v.getId());
//        }
        request.getSession().setAttribute("i", 0);
        request.getSession().setAttribute("proposedvisits", visitsProposed);
        request.getRequestDispatcher("ProposedVisitsJSP.jsp").forward(request, response);
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

    private java.util.List<ws.Visit> getVisitsByPatient(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.VisitWS port = service.getVisitWSPort();
        return port.getVisitsByPatient(username);
    }

}
