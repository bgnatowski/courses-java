import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddCookieServlet extends HttpServlet {

  public void doPost(HttpServletRequest request,
    HttpServletResponse response)
  throws ServletException, IOException {

    // Pobieranie parametru z żądania HTTP
    String data = request.getParameter("data");
    
    // Tworzenie znacznika kontekstu użytkownika
    Cookie cookie = new Cookie("MyCookie", data);

    // Dodawanie znacznika do żądania HTTP
    response.addCookie(cookie);

    // Wyświetlanie komunikatu w oknie przeglądarki
    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();
    pw.println("<B>W znaczniku MyCookie została umieszczona wartość");
    pw.println(data);
    pw.close();
  }
}
