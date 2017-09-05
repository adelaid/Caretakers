<%-- 
    Document   : FeedbackJSP
    Created on : Apr 9, 2017, 3:26:50 PM
    Author     : Ada
--%>

<%@page import="ws.Visit"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Need</title>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="resources/css/jumbotron-narrow.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
        <style>#success_message{ display: none;}</style>
        <style>
            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2}

            th {
                background-color: #4CAF50;
                color: white;
            }
        </style>

    </head>
    <%
        String error = "";
        if (request.getAttribute("LOGIN_ERROR") != null) {
            error = (String) request.getAttribute("LOGIN_ERROR");
        }

    %>
    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">Informal Caretaker Distribution</a>
                </div>
                <ul class="nav navbar-nav">


                    <li ><a href="IndexJSP.jsp">Home</a></li>
                    <li><a href="LoginJSP.jsp">Login</a></li>
                    <li><a href="LogoutPC">Logout</a></li>
                    <li><a href="RegisterJSP.jsp">Register</a></li>
                    <li class="active"> <a href="FeedbackC">Feedback</a></li>
                    <li><a href="AddScheduleJSP.jsp">Add Schedule</a></li>
                    <li ><a href="AddNeedJSP.jsp">Add need</a></li>
                    <li><a href="ProposedVisitsC">Proposed Visits</a></li>
                </ul>
            </div>
        </nav>  
        <div id="bigmenu">

            <!--             <div id="bigmenulinks">
            <%if (session.getAttribute("user") == null) {%>
            <a href="LoginJSP.jsp">Login</a>
            <a href="RegisterNew.jsp">Register</a>
            
            <%} else {%>
            You are logged in as <b><%=session.getAttribute("user")%></b>
            <a href="LogoutC">Logout</a>
            <%}%>
       
            
        </div>-->
        </div>

        <div class="container">
            <%

                List<Visit> visits = (List<Visit>) session.getAttribute("visits");

            %>

            <form class="well form-horizontal"  method="post" action="AddFeedbackC"  id="contact_form">
                <fieldset>


                    <h2>Feedback Form</h2>
                    <table>
                        <tr ><td>Date</td><td>Time</td><td>Caretaker</td><td>Grade</td></tr>



                        <% for (Visit v : visits) {
                                if (v.getGrade() == 0) {
                        %>


                        <tr>
                            <%String[] aa = v.getVDate().split("T");%>
                            <td><%=aa[0]%> </td>
                            <td><%=aa[1]%> </td>
                            <td> <%=v.getCaretaker().getFirstName() + " " + v.getCaretaker().getLastName()%></td>




                            <td><input name="<%=v.getId()%>" id="uname" placeholder="" class="form-control"  type="text" ></td>
                        </tr>

                        <%}
                            }%>

                    </table>

                    <div class="form-group">
                        <label class="col-md-4 control-label"></label>
                        <div class="col-md-4">
                            <button type="submit" class="btn btn-warning" >Send <span class="glyphicon glyphicon-send"></span></button>
                        </div>
                    </div>
                </fieldset>


            </form>



        </div>



    </body>
</html>