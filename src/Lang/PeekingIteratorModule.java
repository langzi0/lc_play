package Lang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Common.Category;
import Common.InvokableBase;
import Common.Priority;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a
 * PeekingIterator that support the peek() operation -- it essentially peek() at the element that
 * will be returned by the next call to next().
 */

public class PeekingIteratorModule extends InvokableBase {

  // Add this class to Common/Main.java
  @Override
  public Priority getRunPriority() {
    return new Priority(160101, 0, Category.LeetCode);
  }

  @Override
  public void run() {
    //Call your test in Common/Main.java

    List<Integer> listInteger = new ArrayList<>();
    listInteger.add(0);
    listInteger.add(1);
    listInteger.add(2);
    listInteger.add(3);

    PeekingIterator iter = new PeekingIterator(listInteger.iterator());
  }

}


class PeekingIterator implements Iterator<Integer> {

  Iterator<Integer> iterator;
  public PeekingIterator(Iterator<Integer> iterator) {
  this.iterator = iterator;
    chching();
  }

  Integer cache;  // iteractor pointing to the next one
  boolean cached;

  private void chching()
  {
    if (!cached)
    {
      cached = true;
      cache = iterator.next();
    }
  }

  public Integer peek(){
    return cache;
  }

  @Override
  public boolean hasNext() {
    return (cache != null);
  }

  @Override
  public Integer next() {
    Integer val = cache;
     cache = iterator.next();
    return val;
  }
}
