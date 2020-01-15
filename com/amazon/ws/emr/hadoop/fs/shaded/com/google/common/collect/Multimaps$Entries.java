package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractCollection;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class Multimaps$Entries<K, V>
  extends AbstractCollection<Map.Entry<K, V>>
{
  abstract Multimap<K, V> multimap();
  
  public int size()
  {
    return multimap().size();
  }
  
  public boolean contains(@Nullable Object o)
  {
    if ((o instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)o;
      return multimap().containsEntry(entry.getKey(), entry.getValue());
    }
    return false;
  }
  
  public boolean remove(@Nullable Object o)
  {
    if ((o instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)o;
      return multimap().remove(entry.getKey(), entry.getValue());
    }
    return false;
  }
  
  public void clear()
  {
    multimap().clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.Entries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */