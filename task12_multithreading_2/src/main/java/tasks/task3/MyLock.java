package tasks.task3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class MyLock implements ReadWriteLock {
  @Override
  public Lock readLock() {
    return null;
  }

  @Override
  public Lock writeLock() {
    return null;
  }
}
