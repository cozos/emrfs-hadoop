package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingMap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingMapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingSet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterators;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class MutableTypeToInstanceMap<B>
  extends ForwardingMap<TypeToken<? extends B>, B>
  implements TypeToInstanceMap<B>
{
  private final Map<TypeToken<? extends B>, B> backingMap;
  
  public MutableTypeToInstanceMap()
  {
    backingMap = Maps.newHashMap();
  }
  
  @Nullable
  public <T extends B> T getInstance(Class<T> type)
  {
    return (T)trustedGet(TypeToken.of(type));
  }
  
  @Nullable
  public <T extends B> T putInstance(Class<T> type, @Nullable T value)
  {
    return (T)trustedPut(TypeToken.of(type), value);
  }
  
  @Nullable
  public <T extends B> T getInstance(TypeToken<T> type)
  {
    return (T)trustedGet(type.rejectTypeVariables());
  }
  
  @Nullable
  public <T extends B> T putInstance(TypeToken<T> type, @Nullable T value)
  {
    return (T)trustedPut(type.rejectTypeVariables(), value);
  }
  
  public B put(TypeToken<? extends B> key, B value)
  {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map)
  {
    throw new UnsupportedOperationException("Please use putInstance() instead.");
  }
  
  public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet()
  {
    return UnmodifiableEntry.transformEntries(super.entrySet());
  }
  
  protected Map<TypeToken<? extends B>, B> delegate()
  {
    return backingMap;
  }
  
  @Nullable
  private <T extends B> T trustedPut(TypeToken<T> type, @Nullable T value)
  {
    return (T)backingMap.put(type, value);
  }
  
  @Nullable
  private <T extends B> T trustedGet(TypeToken<T> type)
  {
    return (T)backingMap.get(type);
  }
  
  private static final class UnmodifiableEntry<K, V>
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
    
    private UnmodifiableEntry(Map.Entry<K, V> delegate)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.MutableTypeToInstanceMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */