package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

final class ImmutableMap$MapViewOfValuesAsSingletonSets<K, V>
  extends ImmutableMap<K, ImmutableSet<V>>
{
  private final ImmutableMap<K, V> delegate;
  
  ImmutableMap$MapViewOfValuesAsSingletonSets(ImmutableMap<K, V> delegate)
  {
    this.delegate = ((ImmutableMap)Preconditions.checkNotNull(delegate));
  }
  
  public int size()
  {
    return delegate.size();
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return delegate.containsKey(key);
  }
  
  public ImmutableSet<V> get(@Nullable Object key)
  {
    V outerValue = delegate.get(key);
    return outerValue == null ? null : ImmutableSet.of(outerValue);
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  ImmutableSet<Map.Entry<K, ImmutableSet<V>>> createEntrySet()
  {
    new ImmutableMapEntrySet()
    {
      ImmutableMap<K, ImmutableSet<V>> map()
      {
        return ImmutableMap.MapViewOfValuesAsSingletonSets.this;
      }
      
      public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> iterator()
      {
        final Iterator<Map.Entry<K, V>> backingIterator = delegate.entrySet().iterator();
        new UnmodifiableIterator()
        {
          public boolean hasNext()
          {
            return backingIterator.hasNext();
          }
          
          public Map.Entry<K, ImmutableSet<V>> next()
          {
            final Map.Entry<K, V> backingEntry = (Map.Entry)backingIterator.next();
            new AbstractMapEntry()
            {
              public K getKey()
              {
                return (K)backingEntry.getKey();
              }
              
              public ImmutableSet<V> getValue()
              {
                return ImmutableSet.of(backingEntry.getValue());
              }
            };
          }
        };
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */