import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ColorPostServlet extends HttpServlet {

  public void doPost(HttpServletRequest request,
    HttpServletResponse response)
  throws ServletException, IOException {
  
    String color = request.getParameter("kolor");
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    pw.println("<B>Wybrany kolor: ");
    pw.println(color);
    pw.close();
  }
}
