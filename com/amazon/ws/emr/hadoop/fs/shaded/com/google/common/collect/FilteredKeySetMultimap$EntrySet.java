package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class FilteredKeySetMultimap$EntrySet
  extends FilteredKeyMultimap<K, V>.Entries
  implements Set<Map.Entry<K, V>>
{
  FilteredKeySetMultimap$EntrySet(FilteredKeySetMultimap paramFilteredKeySetMultimap)
  {
    super(paramFilteredKeySetMultimap);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  public boolean equals(@Nullable Object o)
  {
    return Sets.equalsImpl(this, o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredKeySetMultimap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */