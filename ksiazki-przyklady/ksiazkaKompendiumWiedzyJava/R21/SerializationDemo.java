// Przykład serializacji

import java.io.*;

public class SerializationDemo {
  public static void main(String args[]) {

    // Serializacja obiektu

    try ( ObjectOutputStream objOStrm =
            new ObjectOutputStream(new FileOutputStream("serial")) )
    {
      MyClass object1 = new MyClass("Witaj", -7, 2.7e10);
      System.out.println("object1: " + object1);

      objOStrm.writeObject(object1);
    }
    catch(IOException e) {
System.out.println("Wyjątek w czasie serializacji: " + e);
    }

    // Deserializacja obiektu

    try ( ObjectInputStream objIStrm =
            new ObjectInputStream(new FileInputStream("serial")) )
    {
      MyClass object2 = (MyClass)objIStrm.readObject();
      System.out.println("object2: " + object2);
    }
    catch(Exception e) {
      System.out.println("Wyjątek w czasie deserializacji: " + e);
    }
  }
}

class MyClass implements Serializable {
  String s;
  int i;
  double d;

  public MyClass(String s, int i, double d) {
    this.s = s;
    this.i = i;
    this.d = d;
  }

  public String toString() {
    return "s=" + s + "; i=" + i + "; d=" + d;
  }
}
