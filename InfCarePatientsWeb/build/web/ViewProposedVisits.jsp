<%-- 
    Document   : ViewProposedVisits
    Created on : Apr 25, 2017, 6:59:48 PM
    Author     : Ada
--%>

<%@page import="java.util.List"%>
<%@page import="ws.Visit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    <li><a href="FeedbackC">Feedback</a></li>
                    <li><a href="RegisterJSP.jsp">Register</a></li>
                    <li><a href="ViewPatientsListC">View Patients List</a></li>
                    <li><a href="AddScheduleJSP.jsp">Add Schedule</a></li>
                    <li><a href="AddGeneralNeedJSP.jsp">Add a general need</a></li>
                    <li class="active"><a href="ProposedVisitsC">Proposed Visits</a></li>
                </ul>
            </div>
        </nav>  

        <h1>View Patients List!</h1>
        <div class="loginform">

            <div class="form-element">
                <%
                    List<Visit> pVisits = (List<Visit>) request.getSession().getAttribute("proposedvisits");
                %>
                <h2>Patients Assigned:</h2>
                <form class="well form-horizontal"  method="post" action="SetVisitC"  id="contact_form">

                    <table>

                        <tr><td>Caretaker</td><td>Visit Date</td><td>Start time</td><td>End time</td><td>Confirm</td></tr>

                        
                        <%
                        for(Visit v: pVisits){
                        
                        
                        %>
                        <tr>
                            <td><%=v.getCaretaker().getFirstName() + v.getCaretaker().getLastName()%> </td>
                            <td><%=v.getVDate()
                                %> </td>
                            <td><%=
                                v.getTr().getStartTime()
                                %> </td>
                            <td><%=
                                v.getTr().getEndTime()
                                %> </td>
                               <td><a href="ConfirmVisitC?query=<%=v.getId()%>">Confirm Visit</a></td>
                        </tr>
                        <%}%>
                    </table>

                </form>

            </div>

        </div>
    </body>
</html>
