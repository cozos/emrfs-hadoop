package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collections;
import java.util.List;

class Multimaps$UnmodifiableListMultimap<K, V>
  extends Multimaps.UnmodifiableMultimap<K, V>
  implements ListMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  Multimaps$UnmodifiableListMultimap(ListMultimap<K, V> delegate)
  {
    super(delegate);
  }
  
  public ListMultimap<K, V> delegate()
  {
    return (ListMultimap)super.delegate();
  }
  
  public List<V> get(K key)
  {
    return Collections.unmodifiableList(delegate().get(key));
  }
  
  public List<V> removeAll(Object key)
  {
    throw new UnsupportedOperationException();
  }
  
  public List<V> replaceValues(K key, Iterable<? extends V> values)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.UnmodifiableListMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */