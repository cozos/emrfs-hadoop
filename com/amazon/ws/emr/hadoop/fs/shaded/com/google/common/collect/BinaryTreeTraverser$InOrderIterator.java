package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Deque;

final class BinaryTreeTraverser$InOrderIterator
  extends AbstractIterator<T>
{
  private final Deque<T> stack;
  private final BitSet hasExpandedLeft;
  
  BinaryTreeTraverser$InOrderIterator(T arg1)
  {
    stack = new ArrayDeque();
    hasExpandedLeft = new BitSet();
    stack.addLast(root);
  }
  
  protected T computeNext()
  {
    while (!stack.isEmpty())
    {
      T node = stack.getLast();
      if (hasExpandedLeft.get(stack.size() - 1))
      {
        stack.removeLast();
        hasExpandedLeft.clear(stack.size());
        BinaryTreeTraverser.access$000(stack, this$0.rightChild(node));
        return node;
      }
      hasExpandedLeft.set(stack.size() - 1);
      BinaryTreeTraverser.access$000(stack, this$0.leftChild(node));
    }
    return (T)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BinaryTreeTraverser.InOrderIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */