<%-- 
    Document   : SetVisitJSP
    Created on : Mar 28, 2017, 12:36:08 PM
    Author     : Ada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link href="resources/css/jumbotron-narrow.css" rel="stylesheet" type="text/css"/>
        <style>#success_message{ display: none;}</style>
        <title>Login</title>
    </head>
    <%
        String error = "";
        if (request.getAttribute("LOGIN_ERROR") != null) {
            error = (String) request.getAttribute("LOGIN_ERROR");
        }

        if (request.getParameter("query") != null) {
            int idProd = Integer.parseInt(request.getParameter("query"));
//              

            Iterator<Pizza> i = produseCumparate.iterator();
            while (i.hasNext()) {
                Pizza p = i.next();
                if (p.getId() == idProd) {
                    if (p.getQuantity() > 1) {
                        p.setQuantity(p.getQuantity() - 1);
                    }
                    i.remove();

                }

            }

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
                    <li><a href="LogoutC">Logout</a></li>
                    <li><a href="RegisterJSP.jsp">Register</a></li>
                    <li><a href="ViewPatientsListC">View Patients List</a></li>
                    <li><a href="AddScheduleJSP.jsp">Add Schedule</a></li>
                    <li><a href="AddGeneralNeedJSP.jsp">Add a general need</a></li>
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

            <form class="well form-horizontal"  method="post" action="LoginC"  id="contact_form">
                <fieldset>

                    <!-- Form Name -->


                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" >Username</label> 
                        <div class="col-md-4 inputGroupContainer">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input name="uname" id="uname" placeholder="Username" class="form-control"  type="text" required>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-md-4 control-label" for="password">Password</label>
                        <div class="col-md-4 inputGroupContainer">

                            <div class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                <input name="password" placeholder="Password" id ="password" class="form-control"  type="password" required>
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

