package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class Iterators$6
  extends UnmodifiableIterator<List<T>>
{
  Iterators$6(Iterator paramIterator, int paramInt, boolean paramBoolean) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public List<T> next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Object[] array = new Object[val$size];
    for (int count = 0; (count < val$size) && (val$iterator.hasNext()); count++) {
      array[count] = val$iterator.next();
    }
    for (int i = count; i < val$size; i++) {
      array[i] = null;
    }
    List<T> list = Collections.unmodifiableList(Arrays.asList(array));
    
    return (val$pad) || (count == val$size) ? list : list.subList(0, count);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */