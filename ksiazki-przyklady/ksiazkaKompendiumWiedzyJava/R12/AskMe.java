// Ulepszona wersja programu do podejmowania decyzji
// z rozdziału 9. Ta wersja używa wyliczenia
// zamiast zmiennych interfejsu do reprezentowania
// możliwych odpowiedzi

import java.util.Random;

// Wyliczenie ze wszystkimi możliwymi odpowiedziami
enum Answers {
  NO, YES, MAYBE, LATER, SOON, NEVER
}

class Question {
  Random rand = new Random();
  Answers ask() {
    int prob = (int) (100 * rand.nextDouble());

    if (prob < 15)
      return Answers.MAYBE; // 15%
    else if (prob < 30)
      return Answers.NO;    // 15%
    else if (prob < 60)
      return Answers.YES;   // 30%
    else if (prob < 75)
      return Answers.LATER; // 15%
    else if (prob < 98)
      return Answers.SOON;  // 13%
    else
      return Answers.NEVER; // 2%
  }
}

class AskMe {
  static void answer(Answers result) {
    switch(result) {
      case NO:
        System.out.println("Nie");
        break;
      case YES:
        System.out.println("Tak");
        break;
      case MAYBE:
        System.out.println("Może");
        break;
      case LATER:
        System.out.println("Później");
        break;
      case SOON:
        System.out.println("Wkrótce");
        break;
      case NEVER:
        System.out.println("Nigdy");
        break;
    }
  }

  public static void main(String args[]) {
    Question q = new Question();
    answer(q.ask());
    answer(q.ask());
    answer(q.ask());
    answer(q.ask());
  }
}
