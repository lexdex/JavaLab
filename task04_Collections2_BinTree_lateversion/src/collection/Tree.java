package collection;

public interface Tree<K, V> {

  void put(K key, V value);

  void remove (K key);

  boolean isEmpty();

  int size();

  V get(K key);

  void print();
}
