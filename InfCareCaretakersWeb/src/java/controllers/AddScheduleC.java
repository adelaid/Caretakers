/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.Caretaker;
import ws.TimeReferenceWS_Service;

/**
 *
 * @author Ada
 */
@WebServlet(name = "AddScheduleC", urlPatterns = {"/AddScheduleC"})
public class AddScheduleC extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TimeReferenceWS/TimeReferenceWS.wsdl")
    private TimeReferenceWS_Service service;

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
     String data= request.getParameter("date");
     String stime= request.getParameter("starttime");
     String etime= request.getParameter("endtime");
     Caretaker ct=(Caretaker)request.getSession().getAttribute("user");
     Long ctkid=ct.getId();
     
     //String startT="2017-03-21 10:15:00";
        addTimeReference(ctkid, data + " "+stime, data + " "+etime, false);
        System.out.println(stime);
        request.getRequestDispatcher("IndexJSP.jsp").forward(request, response);
     
      
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

    private void addTimeReference(java.lang.Long caretakerId, java.lang.String startTime, java.lang.String endTime, boolean isPatient) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.TimeReferenceWS port = service.getTimeReferenceWSPort();
        port.addTimeReference(caretakerId, startTime, endTime, isPatient);
    }

   

   
   
  

}
