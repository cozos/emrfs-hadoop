package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedSet
  extends AbstractMapBasedMultimap<K, V>.WrappedCollection
  implements Set<V>
{
  AbstractMapBasedMultimap$WrappedSet(@Nullable K arg1, Set<V> key)
  {
    super(???, key, delegate, null);
  }
  
  public boolean removeAll(Collection<?> c)
  {
    if (c.isEmpty()) {
      return false;
    }
    int oldSize = size();
    
    boolean changed = Sets.removeAllImpl((Set)delegate, c);
    if (changed)
    {
      int newSize = delegate.size();
      AbstractMapBasedMultimap.access$212(this$0, newSize - oldSize);
      removeIfEmpty();
    }
    return changed;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.WrappedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */