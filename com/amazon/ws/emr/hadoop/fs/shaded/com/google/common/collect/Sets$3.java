package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Set;

final class Sets$3
  extends Sets.SetView<E>
{
  Sets$3(Set paramSet1, Predicate paramPredicate, Set paramSet2)
  {
    super(null);
  }
  
  public Iterator<E> iterator()
  {
    return Iterators.filter(val$set1.iterator(), val$notInSet2);
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
  
  public boolean isEmpty()
  {
    return val$set2.containsAll(val$set1);
  }
  
  public boolean contains(Object element)
  {
    return (val$set1.contains(element)) && (!val$set2.contains(element));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */