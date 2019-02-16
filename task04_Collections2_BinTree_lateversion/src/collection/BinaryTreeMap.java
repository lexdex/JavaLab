package collection;

import java.util.Comparator;

public class BinaryTreeMap<K, V> implements Tree<K, V> {

  /**
   * Root of the tree.
   */
  private Node root;

  /**
   * User's possible comparator
   */
  private Comparator<? super K> comparator;

  /**
   * Constructor without arguments.
   */
  public BinaryTreeMap() {
    this.comparator = null;
  }

  /**
   * Constructor, which takes user's comparator.
   *
   */
  public BinaryTreeMap(Comparator<? super K> comparator) {
    this.comparator = comparator;
  }

  /**
   * Adding a new element into tree.
   */
  public void put(K key, V value) {
    if (this.comparator == null) {
      if (!(key instanceof Comparable)) {
        throw new ClassCastException("Comparator is invalid");
      }
    }
    insert(key, value);
  }

  /**
   * Inserting a new Node in tree by compering key.
   * Current Node will be root and then it goes down on tree
   * searching place where it could insert a node
   */
  private void insert(K key, V value) {
    if (root == null)
      root = createNode(key, value, null);
    else {
      Node node = root;

      while (true) {

        if (compareKey(key, node.key) > 0) {
          if (node.right != null)
            node = node.right;
          else {
            node.setRight(createNode(key, value, node));
            return;
          }

        } else {

          if (compareKey(key, node.key) < 0) {
            if (node.left != null)
              node = node.left;
            else {
              node.setLeft(createNode(key, value, node));
              return;
            }
          } else {
            return;
          }

        }
      }
    }
  }

  public boolean isEmpty() {
    return root == null;
  }

  public V get(K key) {
    Node node = findNodeByKey(root, key);
    if (node != null)
      return node.getValue();
    else return null;
  }


  /**
   * Comparing keys of tree's nodes.
   */
  private int compareKey(K o1, K o2) {
    if (comparator == null) {
      return ((Comparable) o1).compareTo(o2);
    }
    return comparator.compare(o1, o2);
  }

  /**
   * Removing from tree a node with certain key.
   */
  public void remove(K key) {
    if (!isEmpty()) {
      if (!delete(key))
        System.out.println("Not such element with key: " + key);
    } else {
      System.out.println("Tree is empty");
    }
  }


  /**
   * Delete by key.
   */
  private boolean delete(K key) {
    Node target = findNodeByKey(root, key);

    // not found - no deleted
    if (target == null)
      return false;

    // target == root
    if (target.equals(root)) {
      deleteRoot();
    } else {
      // target != root
      deleteNode(target);
    }

    return true;
  }

  private void deleteRoot() {
    Node node;
    // if there any right node from root than save in order to do not lose it
    if (root.right != null) {
      // look for the min node in right branch of target == root
      node = findMinNode(root.right);

      // in case right branch is simple like:
      if (node.equals(root.right)) {
        node.left = root.left;
        node.parent.right = null;
        root.right = null;
      } else {
        node.left = root.left;
        root.left = null;

        // if the min element has right branch than save it by changing references
        if (node.right != null)
          node.parent.left = node.right;
        else
          node.parent.left = null;
      }
      node.parent = null;
      node.right = root.right;

      root.right = null;

      root = node;
    } else {
      // tree has just left branch

      // look for the max node in left branch of target == root
      node = findMaxNode(root.left);

      // in case left branch is simple like:
      if (node.equals(root.left)) {
        root.left = null;
        node.parent.left = null;
      } else {
        // if the max element has left branch than save it by changing references
        if (node.left != null)
          node.parent.right = node.left;
        else
          node.parent.right = null;

        node.left = root.left;
        root.left = null;
      }
      node.parent = null;
      root = node;
    }
    root = null;
  }

  private void deleteNode(Node target) {
    if (target.left != null && target.right != null) {
      Node localMax = findMaxNode(target.left);
      target.value = localMax.value;
      deleteNode(localMax);
    } else if (target.left != null) {

      // if target has a left child then put it's child on target place
      if (target.equals(target.parent.left)) {
        target.parent.left = target.left;
        target.parent.left.parent = target.parent;
      } else {
        target.parent.right = target.left;
        target.parent.left.parent = target.parent;
      }
    } else if (target.right != null) {
      // if target has a left child then put it's child on target place
      if (target.equals(target.parent.right)) {
        target.parent.right = target.right;
        target.parent.right.parent = target.parent;
      } else {
        target.parent.left = target.right;
        target.parent.right.parent = target.parent;
      }

    } else {
      // which  parents child it's
      // if target was left child then it will be null
      if (target.equals(target.parent.left))
        target.parent.left = null;
      else
        target.parent.right = null;
    }
  }

  /**
   * Creating a new Node and return it
   */
  private Node createNode(K key, V value, Node parent) {
    Node tmp = new Node(key, value);
    tmp.parent = parent;
    return tmp;
  }

  public void print() {
    if (!isEmpty())
      printTree(root);
    else
      System.out.println("Tree is empty");
  }

  private void printTree(Node cur) {
    if (cur != null) {
      System.out.println(cur.getKey() + ":" + cur.getValue());
      printTree(cur.left);
      printTree(cur.right);
    }
  }

  public int size() {
    return countNodes(root);
  }

  private int countNodes(Node cur) {
    if (cur == null)
      return 0;

    return 1 + countNodes(cur.left) + countNodes(cur.right);

  }

  /**
   * Find Node by key
   */
  private Node findNodeByKey(Node node, K key) {
    if (node == null)
      return null;

    if (compareKey(key, node.key) == 0)
      return node;

    // left
    if (compareKey(key, node.key) < 0)
      if (node.left != null)
        return findNodeByKey(node.left, key);
      else
        // not found
        return null;
      // right
    else if (node.right != null)
      return findNodeByKey(node.right, key);
    else
      // not found
      return null;
  }

  private Node findMaxNode(Node node) {
    while (node.getRight() != null) {
      node = node.getRight();
    }
    return node;
  }

  private Node findMinNode(Node node) {
    while (node.getLeft() != null) {
      node = node.getLeft();
    }
    return node;
  }

  interface Entry<K,V> {

    K getKey();

    V getValue();
  }

  /**
   * Node is an element of tree. It contains key, value
   */
  public class Node implements Entry<K, V>, Comparable<Node> {
    private K key;
    private V value;

    // left node
    private Node left;
    // right node
    private Node right;
    // previous node
    private Node parent;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
      this.left = this.right = null;
    }

    public Node getLeft() {
      return left;
    }

    public Node getRight() {
      return right;
    }

    public Node getParent() {
      return parent;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public int compareTo(Node o) {
      return compareKey(key, o.key);
    }
  }
}
