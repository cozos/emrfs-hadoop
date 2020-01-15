package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

final class Sets$1
  extends Sets.SetView<E>
{
  Sets$1(Set paramSet1, Set paramSet2, Set paramSet3)
  {
    super(null);
  }
  
  public int size()
  {
    return val$set1.size() + val$set2minus1.size();
  }
  
  public boolean isEmpty()
  {
    return (val$set1.isEmpty()) && (val$set2.isEmpty());
  }
  
  public Iterator<E> iterator()
  {
    return Iterators.unmodifiableIterator(Iterators.concat(val$set1.iterator(), val$set2minus1.iterator()));
  }
  
  public boolean contains(Object object)
  {
    return (val$set1.contains(object)) || (val$set2.contains(object));
  }
  
  public <S extends Set<E>> S copyInto(S set)
  {
    set.addAll(val$set1);
    set.addAll(val$set2);
    return set;
  }
  
  public ImmutableSet<E> immutableCopy()
  {
    return new ImmutableSet.Builder().addAll(val$set1).addAll(val$set2).build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */