package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Sets$PowerSet<E>
  extends AbstractSet<Set<E>>
{
  final ImmutableMap<E, Integer> inputSet;
  
  Sets$PowerSet(Set<E> input)
  {
    ImmutableMap.Builder<E, Integer> builder = ImmutableMap.builder();
    int i = 0;
    for (E e : (Set)Preconditions.checkNotNull(input)) {
      builder.put(e, Integer.valueOf(i++));
    }
    inputSet = builder.build();
    Preconditions.checkArgument(inputSet.size() <= 30, "Too many elements to create power set: %s > 30", new Object[] { Integer.valueOf(inputSet.size()) });
  }
  
  public int size()
  {
    return 1 << inputSet.size();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public Iterator<Set<E>> iterator()
  {
    new AbstractIndexedListIterator(size())
    {
      protected Set<E> get(int setBits)
      {
        return new Sets.SubSet(inputSet, setBits);
      }
    };
  }
  
  public boolean contains(@Nullable Object obj)
  {
    if ((obj instanceof Set))
    {
      Set<?> set = (Set)obj;
      return inputSet.keySet().containsAll(set);
    }
    return false;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    if ((obj instanceof PowerSet))
    {
      PowerSet<?> that = (PowerSet)obj;
      return inputSet.equals(inputSet);
    }
    return super.equals(obj);
  }
  
  public int hashCode()
  {
    return inputSet.keySet().hashCode() << inputSet.size() - 1;
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(inputSet));return 10 + str.length() + "powerSet(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.PowerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */