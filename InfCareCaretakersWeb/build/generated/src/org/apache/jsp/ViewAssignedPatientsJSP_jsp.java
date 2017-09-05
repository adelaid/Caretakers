package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import util.PatientMatch;
import ws.Visit;
import java.time.LocalDate;
import ws.Need;
import ws.PatientNeed;
import java.util.ArrayList;
import java.util.Set;
import ws.Caretaker;
import java.util.Map;
import java.util.HashMap;
import ws.Patient;
import java.util.List;
import ws.TimeReference;

public final class ViewAssignedPatientsJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 int i = 0;
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Register</title>\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"resources/css/jumbotron-narrow.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.47/css/bootstrap-datetimepicker.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("        <style>#success_message{ display: none;}</style>\n");
      out.write("        <title>Add Schedule</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <nav class=\"navbar navbar-default\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Informal Caretaker Distribution</a>\n");
      out.write("                </div>\n");
      out.write("                <ul class=\"nav navbar-nav\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li class=\"active\"><a href=\"RegisterJSP.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"LoginJSP.jsp\">Login</a></li>\n");
      out.write("                    <li><a href=\"LogoutC\">Logout</a></li>\n");
      out.write("                    <li><a href=\"RegisterJSP.jsp\">Register</a></li>\n");
      out.write("                    <li><a href=\"ViewPatientsListC\">View Patients List</a></li>\n");
      out.write("                    <li><a href=\"AddScheduleJSP.jsp\">Add Schedule</a></li>\n");
      out.write("                    <li><a href=\"AddGeneralNeedJSP.jsp\">Add a general need</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </nav>  \n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        ");

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

        
      out.write("\n");
      out.write("        <h1>View Assigned Patients List!</h1>\n");
      out.write("        <div class=\"loginform\">\n");
      out.write("\n");
      out.write("            <div class=\"form-element\">\n");
      out.write("\n");
      out.write("                <h2>Patients Assigned:</h2>\n");
      out.write("                <form class=\"well form-horizontal\"  method=\"post\" action=\"aaC\"  id=\"contact_form\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class='col-sm-6'>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <label class=\"col-md-4 control-label\" >Name: </label> \n");
      out.write("                                    <label class=\"col-md-4 control-label\" >");
      out.print(ptm.get(i).getP().getFirstName());
      out.write("</label> \n");
      out.write("                                <div class=\"col-md-4 inputGroupContainer\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    <input name=\"name\" id=\"name\" placeholder=\"\" class=\"form-control\"  type=\"hidden\" value=\"");
      out.print(ptm.get(i));
      out.write("\">\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label class=\"col-md-4 control-label\"></label>\n");
      out.write("                            <div class=\"col-md-4\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-warning\" >Yes <span class=\"glyphicon glyphicon-send\"></span></button>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>   \n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
