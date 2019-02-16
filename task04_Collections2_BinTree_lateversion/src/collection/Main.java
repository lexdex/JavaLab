package collection;

public class Main {

  public static void main(String[] args) {
    Tree<String, String> tree = new BinaryTreeMap<>();

    tree.put("AA", "BB");
    tree.put("AS", "BB");

    System.out.println(tree.isEmpty());
    System.out.println(tree.size());
    System.out.println(tree.get("AS"));

    tree.print();

    tree.remove("AS");

    tree.print();
  }
}