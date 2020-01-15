package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingMapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MutableTypeToInstanceMap$UnmodifiableEntry<K, V>
  extends ForwardingMapEntry<K, V>
{
  private final Map.Entry<K, V> delegate;
  
  static <K, V> Set<Map.Entry<K, V>> transformEntries(Set<Map.Entry<K, V>> entries)
  {
    new ForwardingSet()
    {
      protected Set<Map.Entry<K, V>> delegate()
      {
        return val$entries;
      }
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        return MutableTypeToInstanceMap.UnmodifiableEntry.transformEntries(super.iterator());
      }
      
      public Object[] toArray()
      {
        return standardToArray();
      }
      
      public <T> T[] toArray(T[] array)
      {
        return standardToArray(array);
      }
    };
  }
  
  private static <K, V> Iterator<Map.Entry<K, V>> transformEntries(Iterator<Map.Entry<K, V>> entries)
  {
    Iterators.transform(entries, new Function()
    {
      public Map.Entry<K, V> apply(Map.Entry<K, V> entry)
      {
        return new MutableTypeToInstanceMap.UnmodifiableEntry(entry, null);
      }
    });
  }
  
  private MutableTypeToInstanceMap$UnmodifiableEntry(Map.Entry<K, V> delegate)
  {
    this.delegate = ((Map.Entry)Preconditions.checkNotNull(delegate));
  }
  
  protected Map.Entry<K, V> delegate()
  {
    return delegate;
  }
  
  public V setValue(V value)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */