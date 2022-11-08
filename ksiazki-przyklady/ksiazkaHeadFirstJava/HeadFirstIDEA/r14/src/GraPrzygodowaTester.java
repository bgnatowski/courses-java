import java.io.*;

public class GraPrzygodowaTester {
    public static void main(String[] args){
        GraPrzygodowa g = new GraPrzygodowa();
        try {
            System.out.println(g.getX() + g.getY() + g.getZ());
            FileOutputStream fos = new FileOutputStream("gra.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(g);
            oos.close();

            FileInputStream fis = new FileInputStream("gra.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            g = (GraPrzygodowa) ois.readObject();
            ois.close();

            System.out.println(g.getX() + g.getY() + g.getZ());


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

