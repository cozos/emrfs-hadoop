package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class LinkedTreeMap$LinkedTreeMapIterator<T>
  implements Iterator<T>
{
  LinkedTreeMap.Node<K, V> next = this$0.header.next;
  LinkedTreeMap.Node<K, V> lastReturned = null;
  int expectedModCount = this$0.modCount;
  
  private LinkedTreeMap$LinkedTreeMapIterator(LinkedTreeMap paramLinkedTreeMap) {}
  
  public final boolean hasNext()
  {
    return next != this$0.header;
  }
  
  final LinkedTreeMap.Node<K, V> nextNode()
  {
    LinkedTreeMap.Node<K, V> e = next;
    if (e == this$0.header) {
      throw new NoSuchElementException();
    }
    if (this$0.modCount != expectedModCount) {
      throw new ConcurrentModificationException();
    }
    next = next;
    return lastReturned = e;
  }
  
  public final void remove()
  {
    if (lastReturned == null) {
      throw new IllegalStateException();
    }
    this$0.removeInternal(lastReturned, true);
    lastReturned = null;
    expectedModCount = this$0.modCount;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal.LinkedTreeMap.LinkedTreeMapIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */