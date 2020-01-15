package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ArrayDeque;
import java.util.Deque;

final class BinaryTreeTraverser$PreOrderIterator
  extends UnmodifiableIterator<T>
  implements PeekingIterator<T>
{
  private final Deque<T> stack;
  
  BinaryTreeTraverser$PreOrderIterator(T arg1)
  {
    stack = new ArrayDeque();
    stack.addLast(root);
  }
  
  public boolean hasNext()
  {
    return !stack.isEmpty();
  }
  
  public T next()
  {
    T result = stack.removeLast();
    BinaryTreeTraverser.access$000(stack, this$0.rightChild(result));
    BinaryTreeTraverser.access$000(stack, this$0.leftChild(result));
    return result;
  }
  
  public T peek()
  {
    return (T)stack.getLast();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BinaryTreeTraverser.PreOrderIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */