package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

abstract class Multisets$ElementSet<E>
  extends Sets.ImprovedAbstractSet<E>
{
  abstract Multiset<E> multiset();
  
  public void clear()
  {
    multiset().clear();
  }
  
  public boolean contains(Object o)
  {
    return multiset().contains(o);
  }
  
  public boolean containsAll(Collection<?> c)
  {
    return multiset().containsAll(c);
  }
  
  public boolean isEmpty()
  {
    return multiset().isEmpty();
  }
  
  public Iterator<E> iterator()
  {
    new TransformedIterator(multiset().entrySet().iterator())
    {
      E transform(Multiset.Entry<E> entry)
      {
        return (E)entry.getElement();
      }
    };
  }
  
  public boolean remove(Object o)
  {
    int count = multiset().count(o);
    if (count > 0)
    {
      multiset().remove(o, count);
      return true;
    }
    return false;
  }
  
  public int size()
  {
    return multiset().entrySet().size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.ElementSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */