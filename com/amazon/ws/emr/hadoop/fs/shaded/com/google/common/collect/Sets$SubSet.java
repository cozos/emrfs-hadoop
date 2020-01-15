package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

final class Sets$SubSet<E>
  extends AbstractSet<E>
{
  private final ImmutableMap<E, Integer> inputSet;
  private final int mask;
  
  Sets$SubSet(ImmutableMap<E, Integer> inputSet, int mask)
  {
    this.inputSet = inputSet;
    this.mask = mask;
  }
  
  public Iterator<E> iterator()
  {
    new UnmodifiableIterator()
    {
      final ImmutableList<E> elements = inputSet.keySet().asList();
      int remainingSetBits = mask;
      
      public boolean hasNext()
      {
        return remainingSetBits != 0;
      }
      
      public E next()
      {
        int index = Integer.numberOfTrailingZeros(remainingSetBits);
        if (index == 32) {
          throw new NoSuchElementException();
        }
        remainingSetBits &= (1 << index ^ 0xFFFFFFFF);
        return (E)elements.get(index);
      }
    };
  }
  
  public int size()
  {
    return Integer.bitCount(mask);
  }
  
  public boolean contains(@Nullable Object o)
  {
    Integer index = (Integer)inputSet.get(o);
    return (index != null) && ((mask & 1 << index.intValue()) != 0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.SubSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */