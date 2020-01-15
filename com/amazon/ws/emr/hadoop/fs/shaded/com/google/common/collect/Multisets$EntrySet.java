package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

abstract class Multisets$EntrySet<E>
  extends Sets.ImprovedAbstractSet<Multiset.Entry<E>>
{
  abstract Multiset<E> multiset();
  
  public boolean contains(@Nullable Object o)
  {
    if ((o instanceof Multiset.Entry))
    {
      Multiset.Entry<?> entry = (Multiset.Entry)o;
      if (entry.getCount() <= 0) {
        return false;
      }
      int count = multiset().count(entry.getElement());
      return count == entry.getCount();
    }
    return false;
  }
  
  public boolean remove(Object object)
  {
    if ((object instanceof Multiset.Entry))
    {
      Multiset.Entry<?> entry = (Multiset.Entry)object;
      Object element = entry.getElement();
      int entryCount = entry.getCount();
      if (entryCount != 0)
      {
        Multiset<Object> multiset = multiset();
        return multiset.setCount(element, entryCount, 0);
      }
    }
    return false;
  }
  
  public void clear()
  {
    multiset().clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */