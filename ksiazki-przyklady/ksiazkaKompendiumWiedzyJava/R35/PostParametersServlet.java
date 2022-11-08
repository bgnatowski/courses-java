import java.io.*;
import java.util.*;
import javax.servlet.*;

public class PostParametersServlet
extends GenericServlet {

  public void service(ServiceRequest request,
    ServletResponse response)
  throws ServletException, IOException {
  
    // Pobieranie obiektu typu PrintWriter
    PrintWriter pw = response.getWriter();

    // Pobieranie listy parametrów
    Enumeration<String> e = request.getParameterNames();

    // Wyświetlanie nazw parametrów wraz z ich wartościami
    while(e.hasMoreElements()) {
      String pname = e.nextElement();
      pw.print(pname + " = ");
      String pvalue = request.getParameter(pname);
      pw.println(pvalue);
    }
    pw.close();
  }
}
