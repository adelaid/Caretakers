<%-- 
    Document   : ProposedVisitsJSP
    Created on : May 4, 2017, 5:11:01 PM
    Author     : Ada
--%>

<%@page import="java.util.List"%>
<%@page import="ws.Visit"%>
<%@page import="ws.Visit"%>
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
        <title>View Proposed Visits</title>
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
                    <li><a href="LogoutPC">Logout</a></li>
                    <li><a href="RegisterJSP.jsp">Register</a></li>
                   <li><a href="FeedbackC">Feedback</a></li>
                    <li><a href="AddScheduleJSP.jsp">Add Schedule</a></li>
                    <li><a href="AddNeedJSP.jsp">Add need</a></li>
                    <li class="active"><a href="ProposedVisitsC">Proposed Visits</a></li>
                </ul>
            </div>
        </nav>  


        <%
           List<Visit> pVisits = (List<Visit>) request.getSession().getAttribute("proposedvisits");
            int i = (Integer) session.getAttribute("i");
           

        %>
        <h1>View Proposed Visits</h1>
        <div class="loginform">

            <div class="form-element">

               
                <form class="well form-horizontal" action="ConfirmVisitC" method="post" id="contact_form">



<% if(pVisits.size()!=0){%>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >First Name: </label> 
                                <span ><p><%=pVisits.get(i).getCaretaker().getFirstName()%></p> 



                                    <input name="name" id="name" placeholder="" class="form-control"  type="hidden" value="<%=pVisits.get(i)%>"/></span>


                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Last Name: </label> 
                                <span ><p><%=pVisits.get(i).getCaretaker().getLastName()%></p> 



                                    <input  placeholder="" class="form-control"  type="hidden"  /></span>


                            </div>
                        </div>
                    </div>
                    
                    <%
                        String[] stime = pVisits.get(i).getTr().getStartTime().split("T");
                        String[] etime = pVisits.get(i).getTr().getEndTime().split("T");
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
                  
                  

                 
                
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" > Match:</label> 
                                <%int match = pVisits.get(i).getMatchtot();
                                   
                                %>
                                <span ><p><%=match%>%</p> 



                                    <input  placeholder="" class="form-control"  type="hidden"/></span>


                            </div>
                        </div>
                    </div>

                    <div class="row">

                        <div class="form-group">
                            <!--<label class="col-md-4 control-label"></label>-->

                            <div class="col-md-4">
                                <button type="submit" name="act" value="no" class="btn btn-warning" >No <span class="glyphicon glyphicon-thumbs-down"></span></button>
                            </div>
                            <div class="col-md-4">
                                <button type="submit" name="act" value="yes" class="btn btn-warning" >Yes <span class="glyphicon glyphicon-thumbs-up"></span></button>
                            </div>
                        </div>
                    </div>   

<%}else{%>

<div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" > No proposed visits</label> 
                               
                               



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