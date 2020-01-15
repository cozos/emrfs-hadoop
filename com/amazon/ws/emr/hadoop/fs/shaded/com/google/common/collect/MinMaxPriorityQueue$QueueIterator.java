package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

class MinMaxPriorityQueue$QueueIterator
  implements Iterator<E>
{
  private int cursor = -1;
  private int expectedModCount = MinMaxPriorityQueue.access$700(this$0);
  private Queue<E> forgetMeNot;
  private List<E> skipMe;
  private E lastFromForgetMeNot;
  private boolean canRemove;
  
  private MinMaxPriorityQueue$QueueIterator(MinMaxPriorityQueue paramMinMaxPriorityQueue) {}
  
  public boolean hasNext()
  {
    checkModCount();
    return (nextNotInSkipMe(cursor + 1) < this$0.size()) || ((forgetMeNot != null) && (!forgetMeNot.isEmpty()));
  }
  
  public E next()
  {
    checkModCount();
    int tempCursor = nextNotInSkipMe(cursor + 1);
    if (tempCursor < this$0.size())
    {
      cursor = tempCursor;
      canRemove = true;
      return (E)this$0.elementData(cursor);
    }
    if (forgetMeNot != null)
    {
      cursor = this$0.size();
      lastFromForgetMeNot = forgetMeNot.poll();
      if (lastFromForgetMeNot != null)
      {
        canRemove = true;
        return (E)lastFromForgetMeNot;
      }
    }
    throw new NoSuchElementException("iterator moved past last element in queue.");
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(canRemove);
    checkModCount();
    canRemove = false;
    expectedModCount += 1;
    if (cursor < this$0.size())
    {
      MinMaxPriorityQueue.MoveDesc<E> moved = this$0.removeAt(cursor);
      if (moved != null)
      {
        if (forgetMeNot == null)
        {
          forgetMeNot = new ArrayDeque();
          skipMe = new ArrayList(3);
        }
        forgetMeNot.add(toTrickle);
        skipMe.add(replaced);
      }
      cursor -= 1;
    }
    else
    {
      Preconditions.checkState(removeExact(lastFromForgetMeNot));
      lastFromForgetMeNot = null;
    }
  }
  
  private boolean containsExact(Iterable<E> elements, E target)
  {
    for (E element : elements) {
      if (element == target) {
        return true;
      }
    }
    return false;
  }
  
  boolean removeExact(Object target)
  {
    for (int i = 0; i < MinMaxPriorityQueue.access$600(this$0); i++) {
      if (MinMaxPriorityQueue.access$500(this$0)[i] == target)
      {
        this$0.removeAt(i);
        return true;
      }
    }
    return false;
  }
  
  void checkModCount()
  {
    if (MinMaxPriorityQueue.access$700(this$0) != expectedModCount) {
      throw new ConcurrentModificationException();
    }
  }
  
  private int nextNotInSkipMe(int c)
  {
    if (skipMe != null) {
      while ((c < this$0.size()) && (containsExact(skipMe, this$0.elementData(c)))) {
        c++;
      }
    }
    return c;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MinMaxPriorityQueue.QueueIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */