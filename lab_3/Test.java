package builder;

public class Test {
  public static void main(String[] args) {
    UndoBuilder builder = new UndoBuilder();
    builder.append("1234567");
    builder.append("890");
    builder.append("hello");
    builder.append("how");
    builder.append("are");
    builder.append("you");
    builder.undo();
    builder.undo();
    builder.undo();
    builder.undo();
    System.out.println(builder.toString());
  }
}