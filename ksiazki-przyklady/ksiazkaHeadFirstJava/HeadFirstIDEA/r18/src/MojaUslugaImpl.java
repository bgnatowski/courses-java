import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MojaUslugaImpl extends UnicastRemoteObject implements MojaUsluga {
    @Override
    public String powiedzCzesc() throws RemoteException {
        return "Serwer mówi: 'Czołem!'";
    }

    public MojaUslugaImpl() throws RemoteException { }

    public static void main(String[] args){
        try {
            MojaUsluga usluga = new MojaUslugaImpl();
            Naming.rebind("Zdalne czesc", usluga);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
