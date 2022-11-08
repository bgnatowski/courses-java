import java.io.*;

public class ZapisPliku {

    public static void main(String[] args){

        try {
            FileWriter pisarz = new FileWriter("tekst.txt");

            pisarz.write("Witamy w pliku tekstowym");

            pisarz.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
