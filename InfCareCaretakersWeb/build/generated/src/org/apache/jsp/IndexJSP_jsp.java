package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class IndexJSP_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Index</title>\n");
      out.write("        <link href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n");
      out.write("        <link href=\"resources/css/jumbotron-narrow.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>#success_message{ display: none;}</style>\n");
      out.write("        <style>\n");
      out.write("            \n");
      out.write("          \n");
      out.write("            \n");
      out.write("        </style>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    ");

        String error = "";
        if (request.getAttribute("LOGIN_ERROR") != null) {
            error = (String) request.getAttribute("LOGIN_ERROR");
        }

    
      out.write("\n");
      out.write("    <body background=\"homeresized2.png\">\n");
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
      out.write("        </nav>\n");
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
      out.write("            \n");
      out.write("        </div>-->\n");
      out.write("        </div>\n");
      out.write("        \n");
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
