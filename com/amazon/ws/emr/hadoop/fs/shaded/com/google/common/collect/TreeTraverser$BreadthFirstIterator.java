package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Queue;

final class TreeTraverser$BreadthFirstIterator
  extends UnmodifiableIterator<T>
  implements PeekingIterator<T>
{
  private final Queue<T> queue;
  
  TreeTraverser$BreadthFirstIterator(T arg1)
  {
    queue = new ArrayDeque();
    queue.add(root);
  }
  
  public boolean hasNext()
  {
    return !queue.isEmpty();
  }
  
  public T peek()
  {
    return (T)queue.element();
  }
  
  public T next()
  {
    T result = queue.remove();
    Iterables.addAll(queue, this$0.children(result));
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeTraverser.BreadthFirstIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */