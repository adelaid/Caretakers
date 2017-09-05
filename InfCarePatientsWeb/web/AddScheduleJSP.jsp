<%-- 
    Document   : AddScheduleJSP
    Created on : Mar 27, 2017, 2:52:52 PM
    Author     : Ada
--%>

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


                   <li><a href="IndexJSP.jsp">Home</a></li>
                    <li><a href="LoginJSP.jsp">Login</a></li>
                    <li><a href="LogoutPC">Logout</a></li>
                    <li><a href="RegisterJSP.jsp">Register</a></li>
                   <li><a href="FeedbackC">Feedback</a></li>
                    <li  class="active"><a href="AddScheduleJSP.jsp">Add Schedule</a></li>
                    <li><a href="AddNeedJSP.jsp">Add need</a></li>
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

            <form class="well form-horizontal"  method="post" action="AddPatientScheduleC"  id="contact_form">
                <fieldset>

                    <!-- Form Name -->


                    <!-- Text input-->
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" >Date</label> 
                                <div class="col-md-4 inputGroupContainer">
                                    <div class='input-group date' id='datetimepicker1'>
                                        <span class="input-group-addon">
                                            <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                        <input name="date" id="uname" placeholder="" class="form-control"  type="text" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="password">Start Time</label>
                                <div class="col-md-4 inputGroupContainer">
                                    <div class='input-group date' id='datetimepicker2'>


                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span> 
                                            </span>
                                            <input name="starttime" placeholder="" id ="password" class="form-control"  type="text" required>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class='col-sm-6'>
                            <div class="form-group">
                                <label class="col-md-4 control-label" for="password">End Time</label>
                                <div class="col-md-4 inputGroupContainer">

                                    <div class="input-group date" id='datetimepicker3'> 
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <span class="glyphicon glyphicon-calendar"></span> 
                                            </span>
                                            <input name="endtime" placeholder="" id ="password" class="form-control"  type="text" required>
                                        </div>
                                    </div>
                                </div>
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
               <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"></script>
            <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/js/bootstrap-datetimepicker.min.js"></script>

            <script type="text/javascript">
                $(function () {
                    $('#datetimepicker1').datetimepicker({
                        format: 'YYYY-MM-DD'
                    });
                });
                $(function () {
                    $('#datetimepicker2').datetimepicker({
                        format: 'HH:mm:ss'
                    });
                });
                 $(function () {
                    $('#datetimepicker3').datetimepicker({
                        format: 'HH:mm:ss'
                    });
                });
            </script>
        </div>

    </body>
</html>