import java.io.*;
import java.net.*;

public class CodziennePoradyKlient {
    public void doDziela() {
        try {
            Socket s = new Socket("127.0.0.1",4242);

            InputStreamReader strCzytelnik = new InputStreamReader(s.getInputStream());
            BufferedReader czytelnik = new BufferedReader(strCzytelnik);

            String porada = czytelnik.readLine();
            System.out.println("Dziś powinieneś: " + porada );

            czytelnik.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        CodziennePoradyKlient klient = new CodziennePoradyKlient();
        klient.doDziela();
    }
}
