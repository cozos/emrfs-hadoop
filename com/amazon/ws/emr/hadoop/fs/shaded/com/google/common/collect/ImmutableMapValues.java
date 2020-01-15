package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class ImmutableMapValues<K, V>
  extends ImmutableCollection<V>
{
  private final ImmutableMap<K, V> map;
  
  ImmutableMapValues(ImmutableMap<K, V> map)
  {
    this.map = map;
  }
  
  public int size()
  {
    return map.size();
  }
  
  public UnmodifiableIterator<V> iterator()
  {
    return Maps.valueIterator(map.entrySet().iterator());
  }
  
  public boolean contains(@Nullable Object object)
  {
    return (object != null) && (Iterators.contains(iterator(), object));
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  ImmutableList<V> createAsList()
  {
    final ImmutableList<Map.Entry<K, V>> entryList = map.entrySet().asList();
    new ImmutableAsList()
    {
      public V get(int index)
      {
        return (V)((Map.Entry)entryList.get(index)).getValue();
      }
      
      ImmutableCollection<V> delegateCollection()
      {
        return ImmutableMapValues.this;
      }
    };
  }
  
  @GwtIncompatible("serialization")
  Object writeReplace()
  {
    return new SerializedForm(map);
  }
  
  @GwtIncompatible("serialization")
  private static class SerializedForm<V>
    implements Serializable
  {
    final ImmutableMap<?, V> map;
    private static final long serialVersionUID = 0L;
    
    SerializedForm(ImmutableMap<?, V> map)
    {
      this.map = map;
    }
    
    Object readResolve()
    {
      return map.values();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMapValues
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */