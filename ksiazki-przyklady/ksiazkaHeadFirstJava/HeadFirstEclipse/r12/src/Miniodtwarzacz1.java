import javax.sound.midi.*;

class Miniodtwarzacz1 {
    public static void main(String[] args) {
        try {
            Sequencer sekwenser = MidiSystem.getSequencer();
            sekwenser.open();
            
            Sequence sekwencja = new Sequence(Sequence.PPQ, 4);
            Track sciezka = sekwencja.createTrack();
            
            for (int i = 5; i < 61; i += 4) {
                sciezka.add(tworzZdarzenie(144,1,i,100,i));
                sciezka.add(tworzZdarzenie(128,1,i,100,i + 2));
            }
            
            sekwenser.setSequence(sekwencja);
            sekwenser.setTempoInBPM(220);
            sekwenser.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static MidiEvent tworzZdarzenie(int plc, int kanal, int nuta, int dlugosc, int takt) {
        MidiEvent zdarzenie = null;
        
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(plc, kanal, nuta, dlugosc);
            zdarzenie = new MidiEvent(a, takt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return zdarzenie;
    }
}