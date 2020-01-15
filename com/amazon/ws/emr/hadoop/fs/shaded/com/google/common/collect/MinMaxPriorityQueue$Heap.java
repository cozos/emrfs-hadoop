package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class MinMaxPriorityQueue$Heap
{
  final Ordering<E> ordering;
  MinMaxPriorityQueue<E>.Heap otherHeap;
  
  MinMaxPriorityQueue$Heap(Ordering<E> arg1)
  {
    this.ordering = ordering;
  }
  
  int compareElements(int a, int b)
  {
    return ordering.compare(this$0.elementData(a), this$0.elementData(b));
  }
  
  MinMaxPriorityQueue.MoveDesc<E> tryCrossOverAndBubbleUp(int removeIndex, int vacated, E toTrickle)
  {
    int crossOver = crossOver(vacated, toTrickle);
    if (crossOver == vacated) {
      return null;
    }
    E parent;
    E parent;
    if (crossOver < removeIndex) {
      parent = this$0.elementData(removeIndex);
    } else {
      parent = this$0.elementData(getParentIndex(removeIndex));
    }
    if (otherHeap.bubbleUpAlternatingLevels(crossOver, toTrickle) < removeIndex) {
      return new MinMaxPriorityQueue.MoveDesc(toTrickle, parent);
    }
    return null;
  }
  
  void bubbleUp(int index, E x)
  {
    int crossOver = crossOverUp(index, x);
    MinMaxPriorityQueue<E>.Heap heap;
    MinMaxPriorityQueue<E>.Heap heap;
    if (crossOver == index)
    {
      heap = this;
    }
    else
    {
      index = crossOver;
      heap = otherHeap;
    }
    heap.bubbleUpAlternatingLevels(index, x);
  }
  
  int bubbleUpAlternatingLevels(int index, E x)
  {
    while (index > 2)
    {
      int grandParentIndex = getGrandparentIndex(index);
      E e = this$0.elementData(grandParentIndex);
      if (ordering.compare(e, x) <= 0) {
        break;
      }
      MinMaxPriorityQueue.access$500(this$0)[index] = e;
      index = grandParentIndex;
    }
    MinMaxPriorityQueue.access$500(this$0)[index] = x;
    return index;
  }
  
  int findMin(int index, int len)
  {
    if (index >= MinMaxPriorityQueue.access$600(this$0)) {
      return -1;
    }
    Preconditions.checkState(index > 0);
    int limit = Math.min(index, MinMaxPriorityQueue.access$600(this$0) - len) + len;
    int minIndex = index;
    for (int i = index + 1; i < limit; i++) {
      if (compareElements(i, minIndex) < 0) {
        minIndex = i;
      }
    }
    return minIndex;
  }
  
  int findMinChild(int index)
  {
    return findMin(getLeftChildIndex(index), 2);
  }
  
  int findMinGrandChild(int index)
  {
    int leftChildIndex = getLeftChildIndex(index);
    if (leftChildIndex < 0) {
      return -1;
    }
    return findMin(getLeftChildIndex(leftChildIndex), 4);
  }
  
  int crossOverUp(int index, E x)
  {
    if (index == 0)
    {
      MinMaxPriorityQueue.access$500(this$0)[0] = x;
      return 0;
    }
    int parentIndex = getParentIndex(index);
    E parentElement = this$0.elementData(parentIndex);
    if (parentIndex != 0)
    {
      int grandparentIndex = getParentIndex(parentIndex);
      int uncleIndex = getRightChildIndex(grandparentIndex);
      if ((uncleIndex != parentIndex) && (getLeftChildIndex(uncleIndex) >= MinMaxPriorityQueue.access$600(this$0)))
      {
        E uncleElement = this$0.elementData(uncleIndex);
        if (ordering.compare(uncleElement, parentElement) < 0)
        {
          parentIndex = uncleIndex;
          parentElement = uncleElement;
        }
      }
    }
    if (ordering.compare(parentElement, x) < 0)
    {
      MinMaxPriorityQueue.access$500(this$0)[index] = parentElement;
      MinMaxPriorityQueue.access$500(this$0)[parentIndex] = x;
      return parentIndex;
    }
    MinMaxPriorityQueue.access$500(this$0)[index] = x;
    return index;
  }
  
  int getCorrectLastElement(E actualLastElement)
  {
    int parentIndex = getParentIndex(MinMaxPriorityQueue.access$600(this$0));
    if (parentIndex != 0)
    {
      int grandparentIndex = getParentIndex(parentIndex);
      int uncleIndex = getRightChildIndex(grandparentIndex);
      if ((uncleIndex != parentIndex) && (getLeftChildIndex(uncleIndex) >= MinMaxPriorityQueue.access$600(this$0)))
      {
        E uncleElement = this$0.elementData(uncleIndex);
        if (ordering.compare(uncleElement, actualLastElement) < 0)
        {
          MinMaxPriorityQueue.access$500(this$0)[uncleIndex] = actualLastElement;
          MinMaxPriorityQueue.access$500(this$0)[MinMaxPriorityQueue.access$600(this$0)] = uncleElement;
          return uncleIndex;
        }
      }
    }
    return MinMaxPriorityQueue.access$600(this$0);
  }
  
  int crossOver(int index, E x)
  {
    int minChildIndex = findMinChild(index);
    if ((minChildIndex > 0) && (ordering.compare(this$0.elementData(minChildIndex), x) < 0))
    {
      MinMaxPriorityQueue.access$500(this$0)[index] = this$0.elementData(minChildIndex);
      MinMaxPriorityQueue.access$500(this$0)[minChildIndex] = x;
      return minChildIndex;
    }
    return crossOverUp(index, x);
  }
  
  int fillHoleAt(int index)
  {
    int minGrandchildIndex;
    while ((minGrandchildIndex = findMinGrandChild(index)) > 0)
    {
      MinMaxPriorityQueue.access$500(this$0)[index] = this$0.elementData(minGrandchildIndex);
      index = minGrandchildIndex;
    }
    return index;
  }
  
  private boolean verifyIndex(int i)
  {
    if ((getLeftChildIndex(i) < MinMaxPriorityQueue.access$600(this$0)) && (compareElements(i, getLeftChildIndex(i)) > 0)) {
      return false;
    }
    if ((getRightChildIndex(i) < MinMaxPriorityQueue.access$600(this$0)) && (compareElements(i, getRightChildIndex(i)) > 0)) {
      return false;
    }
    if ((i > 0) && (compareElements(i, getParentIndex(i)) > 0)) {
      return false;
    }
    if ((i > 2) && (compareElements(getGrandparentIndex(i), i) > 0)) {
      return false;
    }
    return true;
  }
  
  private int getLeftChildIndex(int i)
  {
    return i * 2 + 1;
  }
  
  private int getRightChildIndex(int i)
  {
    return i * 2 + 2;
  }
  
  private int getParentIndex(int i)
  {
    return (i - 1) / 2;
  }
  
  private int getGrandparentIndex(int i)
  {
    return getParentIndex(getParentIndex(i));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MinMaxPriorityQueue.Heap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */