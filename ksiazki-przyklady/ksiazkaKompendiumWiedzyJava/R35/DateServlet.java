import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DataServlet extends HttpServlet {

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

    // Pobieranie obiektu typu HttpSession.
    HttpSession hs = request.getSession(true);

    // Tworzenie obiektu typu PrintWriter.
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    pw.print("<B>");

    // Wyświetlanie daty/czasu ostatniego dostępu do serwletu.
    Date date = (Date)hs.getAttribute("date");
    if(date != null) {
      pw.print("Ostatni dostęp do strony: " + date + "<br>");
    }

    // Wyświetlanie aktualnej daty/czasu.
    date = new Date();
    hs.setAttribute("date", date);
    pw.println("Aktualna data: " + date);
  }
}
