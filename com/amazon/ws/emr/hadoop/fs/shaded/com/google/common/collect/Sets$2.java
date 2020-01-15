package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

final class Sets$2
  extends Sets.SetView<E>
{
  Sets$2(Set paramSet1, Predicate paramPredicate, Set paramSet2)
  {
    super(null);
  }
  
  public Iterator<E> iterator()
  {
    return Iterators.filter(val$set1.iterator(), val$inSet2);
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
  
  public boolean isEmpty()
  {
    return !iterator().hasNext();
  }
  
  public boolean contains(Object object)
  {
    return (val$set1.contains(object)) && (val$set2.contains(object));
  }
  
  public boolean containsAll(Collection<?> collection)
  {
    return (val$set1.containsAll(collection)) && (val$set2.containsAll(collection));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */