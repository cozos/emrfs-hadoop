package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;

class ImmutableSortedMap$SerializedForm
  extends ImmutableMap.SerializedForm
{
  private final Comparator<Object> comparator;
  private static final long serialVersionUID = 0L;
  
  ImmutableSortedMap$SerializedForm(ImmutableSortedMap<?, ?> sortedMap)
  {
    super(sortedMap);
    comparator = sortedMap.comparator();
  }
  
  Object readResolve()
  {
    ImmutableSortedMap.Builder<Object, Object> builder = new ImmutableSortedMap.Builder(comparator);
    return createMap(builder);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedMap.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */