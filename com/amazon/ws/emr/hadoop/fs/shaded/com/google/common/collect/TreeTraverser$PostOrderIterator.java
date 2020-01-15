package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Iterator;

final class TreeTraverser$PostOrderIterator
  extends AbstractIterator<T>
{
  private final ArrayDeque<TreeTraverser.PostOrderNode<T>> stack;
  
  TreeTraverser$PostOrderIterator(T arg1)
  {
    stack = new ArrayDeque();
    stack.addLast(expand(root));
  }
  
  protected T computeNext()
  {
    while (!stack.isEmpty())
    {
      TreeTraverser.PostOrderNode<T> top = (TreeTraverser.PostOrderNode)stack.getLast();
      if (childIterator.hasNext())
      {
        T child = childIterator.next();
        stack.addLast(expand(child));
      }
      else
      {
        stack.removeLast();
        return (T)root;
      }
    }
    return (T)endOfData();
  }
  
  private TreeTraverser.PostOrderNode<T> expand(T t)
  {
    return new TreeTraverser.PostOrderNode(t, this$0.children(t).iterator());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeTraverser.PostOrderIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */