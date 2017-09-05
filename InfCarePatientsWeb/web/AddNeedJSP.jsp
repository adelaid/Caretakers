<%-- 
    Document   : AddNeedJSP
    Created on : Mar 27, 2017, 2:10:55 PM
    Author     : Ada
--%>

<%@page import="ws.Need"%>
<%@page import="java.util.List"%>
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
                        <li><a href="FeedbackC">Feedback</a></li>
                    <li><a href="AddScheduleJSP.jsp">Add Schedule</a></li>
                    <li class="active"><a href="AddNeedJSP.jsp">Add need</a></li>
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
            <% List<Need> needs = (List<Need>) session.getAttribute("needs"); %>
            
        </div>-->
        </div>

        <div class="container">

            <form class="well form-horizontal"  method="post" action="AddNeedC"  id="contact_form">
                <fieldset>

                    <!-- Form Name -->

                    <div class="form-group">
                        <label class="col-md-4 control-label" >Choose Need</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <select id="need" name="need">
                                    <%  for (int i = 0; i < needs.size(); i++) {
                                            Need option = needs.get(i);
                                    %>
                                    <option value="<%= option.getId()%>"><%= option.getType()%></option>
                                    <% }%>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Description</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">

                                <input name="desc" id="desc"  class="form-control"  type="text" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Minimum Period of time</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">

                                <input name="min" id="min"  class="form-control"  type="text" required>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Maximum period of time</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">

                                <input name="max" id="max"  class="form-control"  type="text" required>
                            </div>
                        </div>
                    </div>




                    <!-- Success message -->
                    <div class="alert alert-success" role="alert" id="success_message">Success <i class="glyphicon glyphicon-thumbs-up"></i></div>

                    <!-- Button -->
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