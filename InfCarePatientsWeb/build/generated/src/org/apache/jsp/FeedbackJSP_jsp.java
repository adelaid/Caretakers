package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import ws.Visit;
import java.util.List;

public final class FeedbackJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Add Need</title>\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"resources/css/jumbotron-narrow.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <style>#success_message{ display: none;}</style>\n");
      out.write("        <style>\n");
      out.write("            table {\n");
      out.write("                border-collapse: collapse;\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            th, td {\n");
      out.write("                text-align: left;\n");
      out.write("                padding: 8px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            tr:nth-child(even){background-color: #f2f2f2}\n");
      out.write("\n");
      out.write("            th {\n");
      out.write("                background-color: #4CAF50;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    ");

        String error = "";
        if (request.getAttribute("LOGIN_ERROR") != null) {
            error = (String) request.getAttribute("LOGIN_ERROR");
        }

    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Informal Caretaker Distribution</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li ><a href=\"IndexJSP.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"LoginJSP.jsp\">Login</a></li>\n");
      out.write("                    <li><a href=\"LogoutPC\">Logout</a></li>\n");
      out.write("                    <li><a href=\"RegisterJSP.jsp\">Register</a></li>\n");
      out.write("                    <li><a href=\"FeedbackC\">Feedback</a></li>\n");
      out.write("                    <li><a href=\"AddScheduleJSP.jsp\">Add Schedule</a></li>\n");
      out.write("                    <li class=\"active\"><a href=\"AddNeedJSP.jsp\">Add need</a></li>\n");
      out.write("                    <li><a href=\"ProposedVisitsC\">Proposed Visits</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>  \n");
      out.write("        <div id=\"bigmenu\">\n");
      out.write("\n");
      out.write("            <!--             <div id=\"bigmenulinks\">\n");
      out.write("            ");
if (session.getAttribute("user") == null) {
      out.write("\n");
      out.write("            <a href=\"LoginJSP.jsp\">Login</a>\n");
      out.write("            <a href=\"RegisterNew.jsp\">Register</a>\n");
      out.write("            \n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("            You are logged in as <b>");
      out.print(session.getAttribute("user"));
      out.write("</b>\n");
      out.write("            <a href=\"LogoutC\">Logout</a>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("       \n");
      out.write("            \n");
      out.write("        </div>-->\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");


                List<Visit> visits = (List<Visit>) session.getAttribute("visits");

            
      out.write("\n");
      out.write("\n");
      out.write("            <form class=\"well form-horizontal\"  method=\"post\" action=\"AddNeedC\"  id=\"contact_form\">\n");
      out.write("                <fieldset>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <h2>Visits</h2>\n");
      out.write("                    <table>\n");
      out.write("                        <tr ><td>Date</td><td>Time</td><td>Caretaker</td><td>Grade</td></tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");
 for (Visit v : visits) {
                                if (v.getGrade() == 0) {
                        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            ");
String[] aa = v.getVDate().split("T");
      out.write("\n");
      out.write("                            <td>");
      out.print(aa[0]);
      out.write(" </td>\n");
      out.write("                            <td>");
      out.print(aa[1]);
      out.write(" </td>\n");
      out.write("                            <td> ");
      out.print(v.getCaretaker().getFirstName() + " " + v.getCaretaker().getLastName());
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <td><input name=\"");
      out.print(v.getId());
      out.write("\" id=\"uname\" placeholder=\"\" class=\"form-control\"  type=\"text\" required></td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        ");
}
                            }
      out.write("\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"col-md-4 control-label\"></label>\n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <button type=\"submit\" class=\"btn btn-warning\" >Send <span class=\"glyphicon glyphicon-send\"></span></button>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </fieldset>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
