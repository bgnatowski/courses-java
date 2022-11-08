import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetCookiesServlet extends HttpServlet {

   public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {

      // Pobieranie znaczników kontekstu użytkownika z nagłówka żądania
      Cookie[] cookies = request.getCookies();

      // Wyświetlanie znaczników
      response.setContentType("text/html");
      PrintWriter pw = response.getWriter();
      pw.println("<B>");
      for(int i = 0; i < cookies.length; i++) {
         String name = cookies[i].getName();
         String value = cookies[i].getValue();
         pw.println("name = " + name + "; value = " + value);
      }
      pw.close();
   }
}
