package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.annotation.Nullable;

final class TreeMultiset$AvlNode<E>
  extends Multisets.AbstractEntry<E>
{
  @Nullable
  private final E elem;
  private int elemCount;
  private int distinctElements;
  private long totalCount;
  private int height;
  private AvlNode<E> left;
  private AvlNode<E> right;
  private AvlNode<E> pred;
  private AvlNode<E> succ;
  
  TreeMultiset$AvlNode(@Nullable E elem, int elemCount)
  {
    Preconditions.checkArgument(elemCount > 0);
    this.elem = elem;
    this.elemCount = elemCount;
    totalCount = elemCount;
    distinctElements = 1;
    height = 1;
    left = null;
    right = null;
  }
  
  public int count(Comparator<? super E> comparator, E e)
  {
    int cmp = comparator.compare(e, elem);
    if (cmp < 0) {
      return left == null ? 0 : left.count(comparator, e);
    }
    if (cmp > 0) {
      return right == null ? 0 : right.count(comparator, e);
    }
    return elemCount;
  }
  
  private AvlNode<E> addRightChild(E e, int count)
  {
    right = new AvlNode(e, count);
    TreeMultiset.access$1700(this, right, succ);
    height = Math.max(2, height);
    distinctElements += 1;
    totalCount += count;
    return this;
  }
  
  private AvlNode<E> addLeftChild(E e, int count)
  {
    left = new AvlNode(e, count);
    TreeMultiset.access$1700(pred, left, this);
    height = Math.max(2, height);
    distinctElements += 1;
    totalCount += count;
    return this;
  }
  
  AvlNode<E> add(Comparator<? super E> comparator, @Nullable E e, int count, int[] result)
  {
    int cmp = comparator.compare(e, elem);
    if (cmp < 0)
    {
      AvlNode<E> initLeft = left;
      if (initLeft == null)
      {
        result[0] = 0;
        return addLeftChild(e, count);
      }
      int initHeight = height;
      
      left = initLeft.add(comparator, e, count, result);
      if (result[0] == 0) {
        distinctElements += 1;
      }
      totalCount += count;
      return left.height == initHeight ? this : rebalance();
    }
    if (cmp > 0)
    {
      AvlNode<E> initRight = right;
      if (initRight == null)
      {
        result[0] = 0;
        return addRightChild(e, count);
      }
      int initHeight = height;
      
      right = initRight.add(comparator, e, count, result);
      if (result[0] == 0) {
        distinctElements += 1;
      }
      totalCount += count;
      return right.height == initHeight ? this : rebalance();
    }
    result[0] = elemCount;
    long resultCount = elemCount + count;
    Preconditions.checkArgument(resultCount <= 2147483647L);
    elemCount += count;
    totalCount += count;
    return this;
  }
  
  AvlNode<E> remove(Comparator<? super E> comparator, @Nullable E e, int count, int[] result)
  {
    int cmp = comparator.compare(e, elem);
    if (cmp < 0)
    {
      AvlNode<E> initLeft = left;
      if (initLeft == null)
      {
        result[0] = 0;
        return this;
      }
      left = initLeft.remove(comparator, e, count, result);
      if (result[0] > 0) {
        if (count >= result[0])
        {
          distinctElements -= 1;
          totalCount -= result[0];
        }
        else
        {
          totalCount -= count;
        }
      }
      return result[0] == 0 ? this : rebalance();
    }
    if (cmp > 0)
    {
      AvlNode<E> initRight = right;
      if (initRight == null)
      {
        result[0] = 0;
        return this;
      }
      right = initRight.remove(comparator, e, count, result);
      if (result[0] > 0) {
        if (count >= result[0])
        {
          distinctElements -= 1;
          totalCount -= result[0];
        }
        else
        {
          totalCount -= count;
        }
      }
      return rebalance();
    }
    result[0] = elemCount;
    if (count >= elemCount) {
      return deleteMe();
    }
    elemCount -= count;
    totalCount -= count;
    return this;
  }
  
  AvlNode<E> setCount(Comparator<? super E> comparator, @Nullable E e, int count, int[] result)
  {
    int cmp = comparator.compare(e, elem);
    if (cmp < 0)
    {
      AvlNode<E> initLeft = left;
      if (initLeft == null)
      {
        result[0] = 0;
        return count > 0 ? addLeftChild(e, count) : this;
      }
      left = initLeft.setCount(comparator, e, count, result);
      if ((count == 0) && (result[0] != 0)) {
        distinctElements -= 1;
      } else if ((count > 0) && (result[0] == 0)) {
        distinctElements += 1;
      }
      totalCount += count - result[0];
      return rebalance();
    }
    if (cmp > 0)
    {
      AvlNode<E> initRight = right;
      if (initRight == null)
      {
        result[0] = 0;
        return count > 0 ? addRightChild(e, count) : this;
      }
      right = initRight.setCount(comparator, e, count, result);
      if ((count == 0) && (result[0] != 0)) {
        distinctElements -= 1;
      } else if ((count > 0) && (result[0] == 0)) {
        distinctElements += 1;
      }
      totalCount += count - result[0];
      return rebalance();
    }
    result[0] = elemCount;
    if (count == 0) {
      return deleteMe();
    }
    totalCount += count - elemCount;
    elemCount = count;
    return this;
  }
  
  AvlNode<E> setCount(Comparator<? super E> comparator, @Nullable E e, int expectedCount, int newCount, int[] result)
  {
    int cmp = comparator.compare(e, elem);
    if (cmp < 0)
    {
      AvlNode<E> initLeft = left;
      if (initLeft == null)
      {
        result[0] = 0;
        if ((expectedCount == 0) && (newCount > 0)) {
          return addLeftChild(e, newCount);
        }
        return this;
      }
      left = initLeft.setCount(comparator, e, expectedCount, newCount, result);
      if (result[0] == expectedCount)
      {
        if ((newCount == 0) && (result[0] != 0)) {
          distinctElements -= 1;
        } else if ((newCount > 0) && (result[0] == 0)) {
          distinctElements += 1;
        }
        totalCount += newCount - result[0];
      }
      return rebalance();
    }
    if (cmp > 0)
    {
      AvlNode<E> initRight = right;
      if (initRight == null)
      {
        result[0] = 0;
        if ((expectedCount == 0) && (newCount > 0)) {
          return addRightChild(e, newCount);
        }
        return this;
      }
      right = initRight.setCount(comparator, e, expectedCount, newCount, result);
      if (result[0] == expectedCount)
      {
        if ((newCount == 0) && (result[0] != 0)) {
          distinctElements -= 1;
        } else if ((newCount > 0) && (result[0] == 0)) {
          distinctElements += 1;
        }
        totalCount += newCount - result[0];
      }
      return rebalance();
    }
    result[0] = elemCount;
    if (expectedCount == elemCount)
    {
      if (newCount == 0) {
        return deleteMe();
      }
      totalCount += newCount - elemCount;
      elemCount = newCount;
    }
    return this;
  }
  
  private AvlNode<E> deleteMe()
  {
    int oldElemCount = elemCount;
    elemCount = 0;
    TreeMultiset.access$1800(pred, succ);
    if (left == null) {
      return right;
    }
    if (right == null) {
      return left;
    }
    if (left.height >= right.height)
    {
      AvlNode<E> newTop = pred;
      
      left = left.removeMax(newTop);
      right = right;
      distinctElements -= 1;
      totalCount -= oldElemCount;
      return newTop.rebalance();
    }
    AvlNode<E> newTop = succ;
    right = right.removeMin(newTop);
    left = left;
    distinctElements -= 1;
    totalCount -= oldElemCount;
    return newTop.rebalance();
  }
  
  private AvlNode<E> removeMin(AvlNode<E> node)
  {
    if (left == null) {
      return right;
    }
    left = left.removeMin(node);
    distinctElements -= 1;
    totalCount -= elemCount;
    return rebalance();
  }
  
  private AvlNode<E> removeMax(AvlNode<E> node)
  {
    if (right == null) {
      return left;
    }
    right = right.removeMax(node);
    distinctElements -= 1;
    totalCount -= elemCount;
    return rebalance();
  }
  
  private void recomputeMultiset()
  {
    distinctElements = (1 + TreeMultiset.distinctElements(left) + TreeMultiset.distinctElements(right));
    
    totalCount = (elemCount + totalCount(left) + totalCount(right));
  }
  
  private void recomputeHeight()
  {
    height = (1 + Math.max(height(left), height(right)));
  }
  
  private void recompute()
  {
    recomputeMultiset();
    recomputeHeight();
  }
  
  private AvlNode<E> rebalance()
  {
    switch (balanceFactor())
    {
    case -2: 
      if (right.balanceFactor() > 0) {
        right = right.rotateRight();
      }
      return rotateLeft();
    case 2: 
      if (left.balanceFactor() < 0) {
        left = left.rotateLeft();
      }
      return rotateRight();
    }
    recomputeHeight();
    return this;
  }
  
  private int balanceFactor()
  {
    return height(left) - height(right);
  }
  
  private AvlNode<E> rotateLeft()
  {
    Preconditions.checkState(right != null);
    AvlNode<E> newTop = right;
    right = left;
    left = this;
    totalCount = totalCount;
    distinctElements = distinctElements;
    recompute();
    newTop.recomputeHeight();
    return newTop;
  }
  
  private AvlNode<E> rotateRight()
  {
    Preconditions.checkState(left != null);
    AvlNode<E> newTop = left;
    left = right;
    right = this;
    totalCount = totalCount;
    distinctElements = distinctElements;
    recompute();
    newTop.recomputeHeight();
    return newTop;
  }
  
  private static long totalCount(@Nullable AvlNode<?> node)
  {
    return node == null ? 0L : totalCount;
  }
  
  private static int height(@Nullable AvlNode<?> node)
  {
    return node == null ? 0 : height;
  }
  
  @Nullable
  private AvlNode<E> ceiling(Comparator<? super E> comparator, E e)
  {
    int cmp = comparator.compare(e, elem);
    if (cmp < 0) {
      return left == null ? this : (AvlNode)MoreObjects.firstNonNull(left.ceiling(comparator, e), this);
    }
    if (cmp == 0) {
      return this;
    }
    return right == null ? null : right.ceiling(comparator, e);
  }
  
  @Nullable
  private AvlNode<E> floor(Comparator<? super E> comparator, E e)
  {
    int cmp = comparator.compare(e, elem);
    if (cmp > 0) {
      return right == null ? this : (AvlNode)MoreObjects.firstNonNull(right.floor(comparator, e), this);
    }
    if (cmp == 0) {
      return this;
    }
    return left == null ? null : left.floor(comparator, e);
  }
  
  public E getElement()
  {
    return (E)elem;
  }
  
  public int getCount()
  {
    return elemCount;
  }
  
  public String toString()
  {
    return Multisets.immutableEntry(getElement(), getCount()).toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeMultiset.AvlNode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */