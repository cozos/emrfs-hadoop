package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$NodeIterator
  implements ListIterator<Map.Entry<K, V>>
{
  int nextIndex;
  LinkedListMultimap.Node<K, V> next;
  LinkedListMultimap.Node<K, V> current;
  LinkedListMultimap.Node<K, V> previous;
  int expectedModCount = LinkedListMultimap.access$000(this$0);
  
  LinkedListMultimap$NodeIterator(LinkedListMultimap arg1, int index)
  {
    int size = ???.size();
    Preconditions.checkPositionIndex(index, size);
    if (index >= size / 2)
    {
      previous = LinkedListMultimap.access$100(???);
      nextIndex = size;
      while (index++ < size) {
        previous();
      }
    }
    next = LinkedListMultimap.access$200(???);
    while (index-- > 0) {
      next();
    }
    current = null;
  }
  
  private void checkForConcurrentModification()
  {
    if (LinkedListMultimap.access$000(this$0) != expectedModCount) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean hasNext()
  {
    checkForConcurrentModification();
    return next != null;
  }
  
  public LinkedListMultimap.Node<K, V> next()
  {
    checkForConcurrentModification();
    LinkedListMultimap.access$300(next);
    previous = (current = next);
    next = next.next;
    nextIndex += 1;
    return current;
  }
  
  public void remove()
  {
    checkForConcurrentModification();
    CollectPreconditions.checkRemove(current != null);
    if (current != next)
    {
      previous = current.previous;
      nextIndex -= 1;
    }
    else
    {
      next = current.next;
    }
    LinkedListMultimap.access$400(this$0, current);
    current = null;
    expectedModCount = LinkedListMultimap.access$000(this$0);
  }
  
  public boolean hasPrevious()
  {
    checkForConcurrentModification();
    return previous != null;
  }
  
  public LinkedListMultimap.Node<K, V> previous()
  {
    checkForConcurrentModification();
    LinkedListMultimap.access$300(previous);
    next = (current = previous);
    previous = previous.previous;
    nextIndex -= 1;
    return current;
  }
  
  public int nextIndex()
  {
    return nextIndex;
  }
  
  public int previousIndex()
  {
    return nextIndex - 1;
  }
  
  public void set(Map.Entry<K, V> e)
  {
    throw new UnsupportedOperationException();
  }
  
  public void add(Map.Entry<K, V> e)
  {
    throw new UnsupportedOperationException();
  }
  
  void setValue(V value)
  {
    Preconditions.checkState(current != null);
    current.value = value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedListMultimap.NodeIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */