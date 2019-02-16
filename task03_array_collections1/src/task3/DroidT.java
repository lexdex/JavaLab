package task3;

public class DroidT extends Droid {
  private int knownLanguagesAmount;
  private int IQ;

  public DroidT(final String model,
      final int knownLanguagesAmount,
      final int IQ) {
    super(model);
    this.knownLanguagesAmount = knownLanguagesAmount;
    this.IQ = IQ;
  }

  public void work() {
    System.out.println("Evaluating difference  languages");
  }

  public <T extends Droid> String translate(T droid) {

    char[] symbols = droid.speak().toCharArray();

    for(int i = 0; i < symbols.length; i++) {
      if (symbols[i] != ' ') {
        symbols[i] = (char) (symbols[i] + 2);
      }
    }

    String resultSpeech = new String(symbols);
    System.out.println(resultSpeech);

    return resultSpeech;
  }

  public String speak() {
    return new String();
  }
}
