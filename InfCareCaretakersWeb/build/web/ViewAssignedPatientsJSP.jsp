<%-- 
    Document   : ViewAssignedPatientsJSP
    Created on : May 2, 2017, 5:39:14 PM
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
                    <li class="active"> <a href="ViewPatientsListC">View Patients List</a></li>
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
            ArrayList<PatientMatch> ptm = (ArrayList<PatientMatch>) session.getAttribute("ptm");
            int i = (Integer) session.getAttribute("i");

        %>
        
        <div class="loginform">

            <div class="form-element">

                <h2>Patients Assigned:</h2>
                <form class="well form-horizontal" action="SetVisitC" method="post" id="contact_form">
<% if(ptm.size()!=0){%>



                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >First Name: </label> 
                                <span ><p><%=ptm.get(i).getP().getFirstName()%></p> 



                                    <input name="name" id="name" placeholder="" class="form-control"  type="hidden" value="<%=ptm.get(i)%>"/></span>


                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Last Name: </label> 
                                <span ><p><%=ptm.get(i).getP().getLastName()%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"  /></span>


                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >City: </label> 
                                <span ><p><%=ptm.get(i).getP().getAddress().getCity()%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Street </label> 
                                <span ><p><%=ptm.get(i).getP().getAddress().getStreet()%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Street No: </label> 
                                <span ><p><%=ptm.get(i).getP().getAddress().getStreetNo()%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
                    <%
                        String[] stime = ptm.get(i).getTr().getStartTime().split("T");
                        String[] etime = ptm.get(i).getTr().getEndTime().split("T");
                    %>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Date </label> 
                                <span ><p><%=stime[0]%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Start time: </label> 
                                <span ><p><%=stime[1]%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >End time: </label> 
                                <span ><p><%=etime[1]%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
                    <%for (PatientNeed pp : pn) {
                            if (pp.getTimerefId().equals(ptm.get(i).getTr().getId())) {
                                for (Need n : nd) {
                                    if (n.getId().equals(pp.getNeedId())) {


                    %>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Need type: </label> 
                                <span ><p><%=n.getType()%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" > Description: </label> 
                                <span ><p><%=pp.getDescription()%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Last Visit: </label> 
                                <%
                                    String s = pp.getLastVisit();
                                    s = s + "a";
                                    if (s.equals("nulla")) {
                                %>
                                <span ><p>No last visit 

                                    </p> 
                                    <%} else {%>
                                       <% String[] aa = pp.getLastVisit().split("T");%>
                                    <span ><p><%=aa[0]%></p> 
                                        <%}%>
                                        <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
                    <%}
                                }
                            }
                        }%>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" > Match:</label> 
                                <%Double d = ptm.get(i).getMatch();
                                    int match = d.intValue();
                                %>
                                <span ><p><%=match%>%</p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>

                    <div class="row">

                        <div class="form-group">
                            <!--<label class="col-md-4 control-label"></label>-->
                            <%if(ptm.get(i).getMatchU()!=100){%>
                            <div class="col-md-4">
                                <button type="submit" name="act" value="no" class="btn btn-warning" >No <span class="glyphicon glyphicon-thumbs-down"></span></button>
                            </div>
                            <%}%>
                            <div class="col-md-4">
                                <button type="submit" name="act" value="yes" class="btn btn-warning" >Yes <span class="glyphicon glyphicon-thumbs-up"></span></button>
                            </div>
                        </div>
                    </div>   

<%}else{%>
<div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" > No patients assigned</label> 
                               
                               



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>
<%}%>
                </form>

            </div>
        </div>
    </body>
</html>
