package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingListMultimap<K, V>
  extends ForwardingMultimap<K, V>
  implements ListMultimap<K, V>
{
  protected abstract ListMultimap<K, V> delegate();
  
  public List<V> get(@Nullable K key)
  {
    return delegate().get(key);
  }
  
  public List<V> removeAll(@Nullable Object key)
  {
    return delegate().removeAll(key);
  }
  
  public List<V> replaceValues(K key, Iterable<? extends V> values)
  {
    return delegate().replaceValues(key, values);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingListMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */