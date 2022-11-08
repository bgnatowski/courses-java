// Demonstruje użycie specyfikatorów formatów %n i %%
import java.util.*; 
 
class FormatDemo3 { 
  public static void main(String args[]) { 
    Formatter fmt = new Formatter(); 
 
    fmt.format("Kopiowanie pliku%nTransfer jest gotowy w %d%%", 88); 
    System.out.println(fmt);
    fmt.close();
  } 
}
