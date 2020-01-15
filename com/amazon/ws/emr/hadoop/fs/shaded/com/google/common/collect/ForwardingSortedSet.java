package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSet<E>
  extends ForwardingSet<E>
  implements SortedSet<E>
{
  protected abstract SortedSet<E> delegate();
  
  public Comparator<? super E> comparator()
  {
    return delegate().comparator();
  }
  
  public E first()
  {
    return (E)delegate().first();
  }
  
  public SortedSet<E> headSet(E toElement)
  {
    return delegate().headSet(toElement);
  }
  
  public E last()
  {
    return (E)delegate().last();
  }
  
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    return delegate().subSet(fromElement, toElement);
  }
  
  public SortedSet<E> tailSet(E fromElement)
  {
    return delegate().tailSet(fromElement);
  }
  
  private int unsafeCompare(Object o1, Object o2)
  {
    Comparator<? super E> comparator = comparator();
    return comparator == null ? ((Comparable)o1).compareTo(o2) : comparator.compare(o1, o2);
  }
  
  @Beta
  protected boolean standardContains(@Nullable Object object)
  {
    try
    {
      SortedSet<Object> self = this;
      Object ceiling = self.tailSet(object).first();
      return unsafeCompare(ceiling, object) == 0;
    }
    catch (ClassCastException e)
    {
      return false;
    }
    catch (NoSuchElementException e)
    {
      return false;
    }
    catch (NullPointerException e) {}
    return false;
  }
  
  @Beta
  protected boolean standardRemove(@Nullable Object object)
  {
    try
    {
      SortedSet<Object> self = this;
      Iterator<Object> iterator = self.tailSet(object).iterator();
      if (iterator.hasNext())
      {
        Object ceiling = iterator.next();
        if (unsafeCompare(ceiling, object) == 0)
        {
          iterator.remove();
          return true;
        }
      }
    }
    catch (ClassCastException e)
    {
      return false;
    }
    catch (NullPointerException e)
    {
      return false;
    }
    return false;
  }
  
  @Beta
  protected SortedSet<E> standardSubSet(E fromElement, E toElement)
  {
    return tailSet(fromElement).headSet(toElement);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */