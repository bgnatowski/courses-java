import java.io.*;

public class ArchiwizatorStanuGry {
	public static void main(String[] args) {
		Bohater postac1 = new Bohater(50,"Elf", new String[] {"łuk", "miecz", "pył"});
		Bohater postac2 = new Bohater(200,"Trol", new String[] {"pięści", "wielki topór"});
		Bohater postac3 = new Bohater(120,"Mag", new String[] {"czary", "niewidzialnośc"});
		
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Gra.ser"));
			os.writeObject(postac1);
			os.writeObject(postac2);
			os.writeObject(postac3);
			
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		postac1 = null;
		postac2 = null;
		postac3 = null;
		
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Gra.ser"));
			Bohater p1N = (Bohater) is.readObject();
			Bohater p2N = (Bohater) is.readObject();
			Bohater p3N = (Bohater) is.readObject();
			
			System.out.println("Typ postaci 1.: " + p1N.getTyp());
			System.out.println("Typ postaci 2.: " + p2N.getTyp());
			System.out.println("Typ postaci 3.: " + p3N.getTyp());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
