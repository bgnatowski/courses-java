// Demonstruje użycie komponentu TextArea
import java.awt.*; 
import java.awt.event.*;
 
public class TextAreaDemo extends Frame { 

  public TextAreaDemo() { 

    // Wybiera menedżer FlowLayout
    setLayout(new FlowLayout());

    String val =  
      "Java 9 jest najnowszą wersją najczęściej używanego\n" +
      "języka programowania na świecie. Bazując na bogatej\n" +
      "spuściźnie innych języków, Java rozwinęła projektowanie\n" +
      "języków programowania w obu jego aspektach: sztuki i nauki.\n\n" +
      "Jednym z powodów nieustającej popularności Javy jest jej\n" +
      "stały, stopniowy rozwój. Java nigdy nie tkwiła\n" +
      "w miejscu, lecz bezustannie przystosowywała się\n" +
      "do sieciowego świata, podlegającego ciągłym, szybkim \n" +
      "zmianom. Co więcej, Java często wyznaczała kierunki\n" +
      "rozwoju dla innych języków programowania.";
 
    TextArea text = new TextArea(val, 10, 30); 
    add(text); 

    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent we) {
        System.exit(0);
      }
    });
  }
 
  public static void main(String[] args) {
    TextAreaDemo appwin = new TextAreaDemo();

    appwin.setSize(new Dimension(300, 220));
    appwin.setTitle("TextAreaDemo");
    appwin.setVisible(true);
  } 
}
