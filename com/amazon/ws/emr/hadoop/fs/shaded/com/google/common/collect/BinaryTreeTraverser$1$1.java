package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;

class BinaryTreeTraverser$1$1
  extends AbstractIterator<T>
{
  boolean doneLeft;
  boolean doneRight;
  
  BinaryTreeTraverser$1$1(BinaryTreeTraverser.1 param1) {}
  
  protected T computeNext()
  {
    if (!doneLeft)
    {
      doneLeft = true;
      Optional<T> left = this$1.this$0.leftChild(this$1.val$root);
      if (left.isPresent()) {
        return (T)left.get();
      }
    }
    if (!doneRight)
    {
      doneRight = true;
      Optional<T> right = this$1.this$0.rightChild(this$1.val$root);
      if (right.isPresent()) {
        return (T)right.get();
      }
    }
    return (T)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BinaryTreeTraverser.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */