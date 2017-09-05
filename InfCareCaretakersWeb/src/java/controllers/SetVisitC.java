/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import util.PatientMatch;
import ws.Caretaker;
import ws.CaretakerWS_Service;
import ws.TimeReference;
import ws.TimeReferenceWS_Service;

/**
 *
 * @author Ada
 */
public class SetVisitC extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/TimeReferenceWS/TimeReferenceWS.wsdl")
    private TimeReferenceWS_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CaretakerWS/CaretakerWS.wsdl")
    private CaretakerWS_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     public String seconds(String str) {
        // String timpul="";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = str.toCharArray();
        for (Character ch : chars) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        Set<Character> keys = map.keySet();
        Character c = ':';
        if (map.get(c) == 1) {
            str = str + ":00";
        }
        //      System.out.println("timpp "+ str);
        return str;

    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println(request.getParameter("query"));
//        String query=request.getParameter("query");
//         String[] parts = query.split("-");
//         Long trId=Long.parseLong(parts[0]);
//       //  System.out.println(trId);
//        Long ctId =Long.parseLong( parts[1]);
//        Double m=Double.parseDouble(parts[2]);
//        
//    //    int m =Integer.parseInt(Double.parseDouble(parts[2]));
//     //   System.out.println("m " + m.intValue());
//        int match = m.intValue();
//      //  System.out.println(ptId);
//        TimeReference timeRef= getTimeRef(trId);
//        Long ptId=timeRef.getPatient().getId();
//           //String startT="2017-03-21 10:15:00";
//           //'2017-03-29T17:00'
//        String data=seconds(timeRef.getStartTime());
//        String[] parts2 = data.split("T");
//        String dd=parts2[0];
//        String tt=parts2[1];
//        String ddtt=dd+" "+tt;
//        System.out.println(ddtt); 
// //       int match=0;
//        
//       // System.out.println(data);
//       int i=0;
//       setVisit(ctId, ptId, ddtt,trId, match);

     Caretaker ct=(Caretaker)request.getSession().getAttribute("user");
ArrayList<PatientMatch> ptm = (ArrayList<PatientMatch>) request.getSession().getAttribute("ptm");
//request.getParameter();

int i=(Integer)request.getSession().getAttribute("i");
        System.out.println(i);
    if(request.getParameter("act").equals("yes")){
//          for(int j=0;j<ptm.size();j++){
//          //        String data=seconds(timeRef.getStartTime());
String data = seconds(ptm.get(i).getTr().getStartTime());
        String[] parts2 = data.split("T");
        String dd=parts2[0];
        String tt=parts2[1];
        String ddtt=dd+" "+tt;
        System.out.println(ddtt); 
    Double m=ptm.get(i).getMatch();
    int match = m.intValue();
//          }
          setVisit(ct.getId(), ptm.get(i).getP().getId(), ddtt, ptm.get(i).getTr().getId(), match);
      }

      request.getSession().setAttribute("i", i+1);
      
      if(i==ptm.size()-1){
      request.getRequestDispatcher("ViewPatientsListC").forward(request, response);
      }else{
        request.getRequestDispatcher("ViewAssignedPatientsJSP.jsp").forward(request, response);
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

  

    private TimeReference getTimeRef(long trId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.TimeReferenceWS port = service_1.getTimeReferenceWSPort();
        return port.getTimeRef(trId);
    }

    private void setVisit(long ctkId, long patientId, java.lang.String dateV, java.lang.Long timeRefId, java.lang.Integer match) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.CaretakerWS port = service.getCaretakerWSPort();
        port.setVisit(ctkId, patientId, dateV, timeRefId, match);
    }
    
    

}
