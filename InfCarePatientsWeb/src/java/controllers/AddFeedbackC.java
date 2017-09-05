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
@WebServlet(name = "AddFeedbackC", urlPatterns = {"/AddFeedbackC"})
public class AddFeedbackC extends HttpServlet {

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
        
        List<Visit> visits=(List<Visit>)request.getSession().getAttribute("visits");
        
        for(Visit v: visits){
            if(v.getGrade()==0){
               String s= request.getParameter(v.getId().toString());
                System.out.println("s " + s);
           int grade=0; 
            if(s.equals("")){
           grade=0;
            }
            else{
             grade= Integer.parseInt(  request.getParameter(v.getId().toString()));
            }
         
      //  if(v.getId()==request.getParameter(name)){
          //  System.out.println(request.getParameter(v.getId().toString()) + " " + v.getId());
         
            giveGrade(grade, v.getId());
        }}
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

    private void giveGrade(int grade, java.lang.Long visitId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.VisitWS port = service.getVisitWSPort();
        port.giveGrade(grade, visitId);
    }

}
