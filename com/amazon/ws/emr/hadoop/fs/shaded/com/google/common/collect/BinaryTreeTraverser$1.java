package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import java.util.Iterator;

class BinaryTreeTraverser$1
  extends FluentIterable<T>
{
  BinaryTreeTraverser$1(BinaryTreeTraverser paramBinaryTreeTraverser, Object paramObject) {}
  
  public Iterator<T> iterator()
  {
    new AbstractIterator()
    {
      boolean doneLeft;
      boolean doneRight;
      
      protected T computeNext()
      {
        if (!doneLeft)
        {
          doneLeft = true;
          Optional<T> left = this$0.leftChild(val$root);
          if (left.isPresent()) {
            return (T)left.get();
          }
        }
        if (!doneRight)
        {
          doneRight = true;
          Optional<T> right = this$0.rightChild(val$root);
          if (right.isPresent()) {
            return (T)right.get();
          }
        }
        return (T)endOfData();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BinaryTreeTraverser.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */