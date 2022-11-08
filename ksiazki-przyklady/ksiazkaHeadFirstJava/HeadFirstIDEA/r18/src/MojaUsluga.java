import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MojaUsluga extends Remote {
    public String powiedzCzesc() throws RemoteException;
}
