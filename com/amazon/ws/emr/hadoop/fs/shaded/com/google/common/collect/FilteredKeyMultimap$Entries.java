package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

class FilteredKeyMultimap$Entries
  extends ForwardingCollection<Map.Entry<K, V>>
{
  FilteredKeyMultimap$Entries(FilteredKeyMultimap paramFilteredKeyMultimap) {}
  
  protected Collection<Map.Entry<K, V>> delegate()
  {
    return Collections2.filter(this$0.unfiltered.entries(), this$0.entryPredicate());
  }
  
  public boolean remove(@Nullable Object o)
  {
    if ((o instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)o;
      if ((this$0.unfiltered.containsKey(entry.getKey())) && (this$0.keyPredicate.apply(entry.getKey()))) {
        return this$0.unfiltered.remove(entry.getKey(), entry.getValue());
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredKeyMultimap.Entries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */