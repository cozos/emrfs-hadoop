package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;
import java.util.Map.Entry;

class $ImmutableMap$RegularImmutableMap$Values<V>
  extends .ImmutableCollection<V>
{
  final .ImmutableMap.RegularImmutableMap<?, V> map;
  
  $ImmutableMap$RegularImmutableMap$Values(.ImmutableMap.RegularImmutableMap<?, V> map)
  {
    this.map = map;
  }
  
  public int size()
  {
    return .ImmutableMap.RegularImmutableMap.access$500(map).length;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public .UnmodifiableIterator<V> iterator()
  {
    Iterator<V> iterator = new .AbstractIterator()
    {
      int index = 0;
      
      protected V computeNext()
      {
        return (V)(index < .ImmutableMap.RegularImmutableMap.access$500(map).length ? .ImmutableMap.RegularImmutableMap.access$500(map)[(index++)].getValue() : endOfData());
      }
    };
    return .Iterators.unmodifiableIterator(iterator);
  }
  
  public boolean contains(Object target)
  {
    return map.containsValue(target);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.RegularImmutableMap.Values
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */