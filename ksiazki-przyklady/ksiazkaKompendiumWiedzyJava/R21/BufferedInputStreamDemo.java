// Wykorzystuje buforowany strumień wejściowy

import java.io.*;

class BufferedInputStreamDemo {
  public static void main(String args[]) {
    String s = "&copy; jest symbolem praw autorskich, " +
      "natomiast &copy takim symbolem nie jest.\n";
    byte buf[] = s.getBytes();

    ByteArrayInputStream in = new ByteArrayInputStream(buf);
    int c;
    boolean marked = false;

    // Używa instrukcji try-with-resources do zarządzania plikiem
    try ( BufferedInputStream f = new BufferedInputStream(in) )
    {
      while ((c = f.read()) != -1) {
        switch(c) {
          case '&':
            if (!marked) {
              f.mark(32);
              marked = true;
            } else {
              marked = false;
            }
            break;
          case ';':
            if (marked) {
              marked = false;
              System.out.print("(c)");
            } else
            System.out.print((char) c);
              break;
          case ' ':
            if (marked) {
              marked = false;
              f.reset();
              System.out.print("&");
            } else
              System.out.print((char) c);
            break;
          default:
            if (!marked)
              System.out.print((char) c);
            break;
        }
      }
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
