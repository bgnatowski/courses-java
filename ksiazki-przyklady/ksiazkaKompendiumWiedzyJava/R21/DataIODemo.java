// Przykład użycia klas DataInputStream i DataOutputStream

import java.io.*;

class DataIODemo {
  public static void main(String args[]) throws IOException {

    // Najpierw zapisuje dane
    try ( DataOutputStream dout =
            new DataOutputStream(new FileOutputStream("Test.dat")) )
    {
      dout.writeDouble(98.6);
      dout.writeInt(1000);
      dout.writeBoolean(true);

    } catch(FileNotFoundException e) {
      System.out.println("Nie można otworzyć pliku wyjściowego");
      return;
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }

    // Teraz ponownie odczytuje te dane
    try ( DataInputStream din =
            new DataInputStream(new FileInputStream("Test.dat")) )
    {
      double d = din.readDouble();
      int i = din.readInt();
      boolean b = din.readBoolean();

      System.out.println("Oto nasze wartości: " +
                         d + " " + i + " " + b);
    } catch(FileNotFoundException e) {
      System.out.println("Nie można otworzyć pliku wejściowego");
      return;
    } catch(IOException e) {
      System.out.println("Błąd wejścia-wyjścia: " + e);
    }
  }
}
