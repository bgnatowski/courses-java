// Oczekiwanie na zakończenie programu notepad
class ExecDemoFini {
  public static void main(String args[]) {
    Runtime r = Runtime.getRuntime();
    Process p = null;

    try {
      p = r.exec("notepad");
      p.waitFor();
    } catch (Exception e) {
      System.out.println("Błąd wykonania programu notepad");
    }
    System.out.println("Notepad zwrócił kod błędu " + p.exitValue());
  }
}
