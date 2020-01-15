package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

final class TreeTraverser$PreOrderIterator
  extends UnmodifiableIterator<T>
{
  private final Deque<Iterator<T>> stack;
  
  TreeTraverser$PreOrderIterator(T arg1)
  {
    stack = new ArrayDeque();
    stack.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(root)));
  }
  
  public boolean hasNext()
  {
    return !stack.isEmpty();
  }
  
  public T next()
  {
    Iterator<T> itr = (Iterator)stack.getLast();
    T result = Preconditions.checkNotNull(itr.next());
    if (!itr.hasNext()) {
      stack.removeLast();
    }
    Iterator<T> childItr = this$0.children(result).iterator();
    if (childItr.hasNext()) {
      stack.addLast(childItr);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeTraverser.PreOrderIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */