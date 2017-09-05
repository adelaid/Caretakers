/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.Need;
import ws.Patient;
import ws.PatientWS_Service;
import ws.TimeReference;
import ws.Visit;
import ws.VisitWS_Service;

/**
 *
 * @author Ada
 */
@WebServlet(name = "AddNeedC", urlPatterns = {"/AddNeedC"})
public class AddNeedC extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/VisitWS/VisitWS.wsdl")
    private VisitWS_Service service_1;

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/PatientWS/PatientWS.wsdl")
    private PatientWS_Service service;

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

    public LocalTime getlTime(String t) {
        String[] parts = t.split("T");

        String timpul = parts[1];

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(timpul, timeFormatter);
        return localTime;
        // System.out.println("timp " + localTime);

    }

    public LocalDate getlDate(String t) {
        String[] parts = t.split("T");
        String data = parts[0];
        DateTimeFormatter formatterX
                = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.US);
        LocalDate localDate = LocalDate.parse(data, formatterX);
        return localDate;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int minP = Integer.parseInt(request.getParameter("min"));
        int maxP = Integer.parseInt(request.getParameter("max"));
        String desc = request.getParameter("desc");
        int need = Integer.parseInt(request.getParameter("need"));
        String type = "";
        Patient pt = (Patient) request.getSession().getAttribute("user");
        String username = pt.getUsername();

        List<Need> needs = (List<Need>) request.getSession().getAttribute("needs");
        for (Need n : needs) {
            if (n.getId() == need) {
                type = n.getType();
            }
        }

        List<Visit> visits = getVisitsByPatient(username);
        //    for (Visit v : visits) {
        // getlDate(v.getVDate());
        String vDate = "";
        String ddtt = "";
        if (visits.size() != 0) {
            Collections.sort(visits, new Comparator<Visit>() {
                @Override
                public int compare(Visit o1, Visit o2) {
                    return o1.getVDate().compareTo(
                            o2.getVDate());
                }

            });

            for (Visit v : visits) {
                System.out.println(v.getId());
                System.out.println(v.getVDate());
                vDate = v.getVDate();

            }
            if (!vDate.isEmpty()) {
                String data = seconds(vDate);
                String[] parts2 = data.split("T");
                String dd = parts2[0];
                String tt = parts2[1];
                ddtt = dd + " " + tt;
                System.out.println(ddtt);
            }
        }
        else{
        ddtt="1111-11-11 00:00:00";
        }
        List<TimeReference> ptSch = getAllPatientsSchedule();
        Long trId = 0l;
        for (TimeReference tr : ptSch) {
            if (tr.getPatient().getUsername().equals(pt.getUsername())) {
            }
            trId = tr.getId();
        }

        setNeed(desc, ddtt, minP, maxP, type, username, trId);
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

    private java.util.List<ws.Visit> getVisitsByPatient(java.lang.String username) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.VisitWS port = service_1.getVisitWSPort();
        return port.getVisitsByPatient(username);
    }

    private void setNeed(java.lang.String desc, java.lang.String lastVisit, int minP, int maxP, java.lang.String needType, java.lang.String username, java.lang.Long timerefId) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.PatientWS port = service.getPatientWSPort();
        port.setNeed(desc, lastVisit, minP, maxP, needType, username, timerefId);
    }

    private java.util.List<ws.TimeReference> getAllPatientsSchedule() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.PatientWS port = service.getPatientWSPort();
        return port.getAllPatientsSchedule();
    }

}
