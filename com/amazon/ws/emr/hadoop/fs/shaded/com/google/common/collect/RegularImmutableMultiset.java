package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
class RegularImmutableMultiset<E>
  extends ImmutableMultiset<E>
{
  private final transient ImmutableMap<E, Integer> map;
  private final transient int size;
  
  RegularImmutableMultiset(ImmutableMap<E, Integer> map, int size)
  {
    this.map = map;
    this.size = size;
  }
  
  boolean isPartialView()
  {
    return map.isPartialView();
  }
  
  public int count(@Nullable Object element)
  {
    Integer value = (Integer)map.get(element);
    return value == null ? 0 : value.intValue();
  }
  
  public int size()
  {
    return size;
  }
  
  public boolean contains(@Nullable Object element)
  {
    return map.containsKey(element);
  }
  
  public ImmutableSet<E> elementSet()
  {
    return map.keySet();
  }
  
  Multiset.Entry<E> getEntry(int index)
  {
    Map.Entry<E, Integer> mapEntry = (Map.Entry)map.entrySet().asList().get(index);
    return Multisets.immutableEntry(mapEntry.getKey(), ((Integer)mapEntry.getValue()).intValue());
  }
  
  public int hashCode()
  {
    return map.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */