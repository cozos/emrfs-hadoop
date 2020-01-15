package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import javax.annotation.Nullable;

final class FilteredEntryMultimap$ValuePredicate
  implements Predicate<V>
{
  private final K key;
  
  FilteredEntryMultimap$ValuePredicate(K arg1)
  {
    this.key = key;
  }
  
  public boolean apply(@Nullable V value)
  {
    return FilteredEntryMultimap.access$000(this$0, key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredEntryMultimap.ValuePredicate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */