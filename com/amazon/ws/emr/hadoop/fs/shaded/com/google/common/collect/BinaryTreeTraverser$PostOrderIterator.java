package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

final class BinaryTreeTraverser$PostOrderIterator
  extends UnmodifiableIterator<T>
{
  private final Deque<T> stack;
  private final BitSet hasExpanded;
  
  BinaryTreeTraverser$PostOrderIterator(T arg1)
  {
    stack = new ArrayDeque();
    stack.addLast(root);
    hasExpanded = new BitSet();
  }
  
  public boolean hasNext()
  {
    return !stack.isEmpty();
  }
  
  public T next()
  {
    for (;;)
    {
      T node = stack.getLast();
      boolean expandedNode = hasExpanded.get(stack.size() - 1);
      if (expandedNode)
      {
        stack.removeLast();
        hasExpanded.clear(stack.size());
        return node;
      }
      hasExpanded.set(stack.size() - 1);
      BinaryTreeTraverser.access$000(stack, this$0.rightChild(node));
      BinaryTreeTraverser.access$000(stack, this$0.leftChild(node));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BinaryTreeTraverser.PostOrderIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */