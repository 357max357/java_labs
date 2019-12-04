public class Controller {

  public static void main(String[] args) {
    PropsReader.readProperties("./res/props");
    PropsReader.printProperties();
  }
}