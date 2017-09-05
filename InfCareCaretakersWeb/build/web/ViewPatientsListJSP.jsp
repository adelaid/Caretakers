<%-- 
    Document   : ViewPatientsListJSP
    Created on : Mar 27, 2017, 4:05:56 PM
    Author     : Ada
--%>

<%@page import="util.PatientMatch"%>
<%@page import="ws.Visit"%>
<%@page import="java.time.LocalDate"%>
<%@page import="ws.Need"%>
<%@page import="ws.PatientNeed"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="ws.Caretaker"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="ws.Patient"%>
<%@page import="java.util.List"%>
<%@page import="ws.TimeReference"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="resources/css/jumbotron-narrow.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
        <style>#success_message{ display: none;}</style>
        <title>Add Schedule</title>
    </head>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Informal Caretaker Distribution</a>
                </div>
                <ul class="nav navbar-nav">


                     <li ><a href="IndexJSP.jsp">Home</a></li>
                    <li><a href="LoginJSP.jsp">Login</a></li>
                    <li><a href="LogoutC">Logout</a></li>
                    <li><a href="RegisterJSP.jsp">Register</a></li>
                    <li class="active"><a href="ViewPatientsListC">View Patients List</a></li>
                    <li><a href="AddScheduleJSP.jsp">Add Schedule</a></li>
                    <li><a href="AddGeneralNeedJSP.jsp">Add a general need</a></li>
                </ul>
            </div>
        </nav>  
        <%
            Map<TimeReference, List<Caretaker>> hm = (Map<TimeReference, List<Caretaker>>) session.getAttribute("sch");
            List<PatientNeed> pn = (List<PatientNeed>) session.getAttribute("pn");
            List<Need> nd = (List<Need>) session.getAttribute("nd");
            Caretaker ctk = (Caretaker) session.getAttribute("user");
            List<TimeReference> patientsSch = (List<TimeReference>) session.getAttribute("patientsSch");
            ArrayList<Long> arr = (ArrayList<Long>) session.getAttribute("arr");
            ArrayList<Visit> visits = (ArrayList<Visit>) session.getAttribute("visits");
            ArrayList<Long> arr2 = (ArrayList<Long>) session.getAttribute("arr2");
            ArrayList<Double> gr = (ArrayList<Double>) session.getAttribute("gr");
            ArrayList<PatientMatch> ptm =( ArrayList<PatientMatch>)session.getAttribute("ptm");
            
        %>
        <h1>View Patients List!</h1>
        <div class="loginform">

            <div class="form-element">

                <h2>Patients Assigned:</h2>
                <form class="well form-horizontal"  method="post" action="SetVisitC"  id="contact_form">
                    <table>

                        <tr><td>Name</td><td>Last Name</td><td>City</td><td>Street</td><td>Street No</td><td>Date</td><td>Start Time</td><td>End Time</td><td> </td></tr>


                        <%
                            for (int i = 0; i < arr2.size(); i++) {
                                for (TimeReference t : patientsSch) {
                                    if (i % 2 == 0) {
                                        if (arr2.get(i + 1).equals(t.getId())) {

                        %>
                        <tr>
                            <td><%=t.getPatient().getFirstName()%> </td>
                            <td><%=t.getPatient().getLastName()%> </td>
                            <td><%=t.getPatient().getAddress().getCity()%> </td>
                            <td><%=t.getPatient().getAddress().getStreet()%> </td>
                            <td><%=t.getPatient().getAddress().getStreetNo()%> </td>
                            <%
                                String[] stime = t.getStartTime().split("T");
                                String[] etime = t.getEndTime().split("T");
                            %>
                            <td><%=stime[0]%> </td>
                            <td><%=stime[1]%> </td>
                            <td><%=etime[1]%> </td>
                            <%for (PatientNeed pp : pn) {
                                    if (pp.getTimerefId().equals(t.getId())) {
                                        for (Need n : nd) {
                                            if (n.getId().equals(pp.getNeedId())) {


                            %>
                            <td><%=n.getType()%> </td>
                            <td><%=pp.getDescription()%> </td>
                            <%
                                String s = pp.getLastVisit();
                                s = s + "a";
                                if (s.equals("nulla")) {
                            %>
                            <td>No last visit </td>
                            <td><%=pp.getMinPeriod()%> </td>
                            <td><%=pp.getMaxPeriod()%> </td>
                            <%} else {%>

                            <% String[] aa = pp.getLastVisit().split("T");%>
                            <td><%=aa[0]%> </td>
                            <%LocalDate t1 = LocalDate.parse(aa[0]);
                                LocalDate t2 = t1.plusDays(pp.getMinPeriod());
                                LocalDate t22 = t1.plusDays(pp.getMaxPeriod());
                            %>
                            <td><%=t2%> </td>
                            <td><%=t22%> </td>
                            <%}%>
                            <%for(PatientMatch pm : ptm){
                            if(pm.getTr().getId().equals(t.getId())){
                            %>
                            <td><a href="SetVisitC?query=<%=t.getId() + "-" + ctk.getId() + "-"+pm.getMatch()%>">Set Visit</a></td>
                            <%}
                            }%>
                            

                        <tr>
                            <%}
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }%>
                    </table>
                   
                </form>

            </div>

        </div>
    </body>
</html>
