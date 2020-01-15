package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractBiMap<K, V>
  extends ForwardingMap<K, V>
  implements BiMap<K, V>, Serializable
{
  private transient Map<K, V> delegate;
  transient AbstractBiMap<V, K> inverse;
  private transient Set<K> keySet;
  private transient Set<V> valueSet;
  private transient Set<Map.Entry<K, V>> entrySet;
  @GwtIncompatible("Not needed in emulated source.")
  private static final long serialVersionUID = 0L;
  
  AbstractBiMap(Map<K, V> forward, Map<V, K> backward)
  {
    setDelegates(forward, backward);
  }
  
  private AbstractBiMap(Map<K, V> backward, AbstractBiMap<V, K> forward)
  {
    delegate = backward;
    inverse = forward;
  }
  
  protected Map<K, V> delegate()
  {
    return delegate;
  }
  
  K checkKey(@Nullable K key)
  {
    return key;
  }
  
  V checkValue(@Nullable V value)
  {
    return value;
  }
  
  void setDelegates(Map<K, V> forward, Map<V, K> backward)
  {
    Preconditions.checkState(delegate == null);
    Preconditions.checkState(inverse == null);
    Preconditions.checkArgument(forward.isEmpty());
    Preconditions.checkArgument(backward.isEmpty());
    Preconditions.checkArgument(forward != backward);
    delegate = forward;
    inverse = new Inverse(backward, this, null);
  }
  
  void setInverse(AbstractBiMap<V, K> inverse)
  {
    this.inverse = inverse;
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return inverse.containsKey(value);
  }
  
  public V put(@Nullable K key, @Nullable V value)
  {
    return (V)putInBothMaps(key, value, false);
  }
  
  public V forcePut(@Nullable K key, @Nullable V value)
  {
    return (V)putInBothMaps(key, value, true);
  }
  
  private V putInBothMaps(@Nullable K key, @Nullable V value, boolean force)
  {
    checkKey(key);
    checkValue(value);
    boolean containedKey = containsKey(key);
    if ((containedKey) && (Objects.equal(value, get(key)))) {
      return value;
    }
    if (force) {
      inverse().remove(value);
    } else {
      Preconditions.checkArgument(!containsValue(value), "value already present: %s", new Object[] { value });
    }
    V oldValue = delegate.put(key, value);
    updateInverseMap(key, containedKey, oldValue, value);
    return oldValue;
  }
  
  private void updateInverseMap(K key, boolean containedKey, V oldValue, V newValue)
  {
    if (containedKey) {
      removeFromInverseMap(oldValue);
    }
    inverse.delegate.put(newValue, key);
  }
  
  public V remove(@Nullable Object key)
  {
    return (V)(containsKey(key) ? removeFromBothMaps(key) : null);
  }
  
  private V removeFromBothMaps(Object key)
  {
    V oldValue = delegate.remove(key);
    removeFromInverseMap(oldValue);
    return oldValue;
  }
  
  private void removeFromInverseMap(V oldValue)
  {
    inverse.delegate.remove(oldValue);
  }
  
  public void putAll(Map<? extends K, ? extends V> map)
  {
    for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
      put(entry.getKey(), entry.getValue());
    }
  }
  
  public void clear()
  {
    delegate.clear();
    inverse.delegate.clear();
  }
  
  public BiMap<V, K> inverse()
  {
    return inverse;
  }
  
  public Set<K> keySet()
  {
    Set<K> result = keySet;
    return result == null ? (keySet = new KeySet(null)) : result;
  }
  
  private class KeySet
    extends ForwardingSet<K>
  {
    private KeySet() {}
    
    protected Set<K> delegate()
    {
      return delegate.keySet();
    }
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    public boolean remove(Object key)
    {
      if (!contains(key)) {
        return false;
      }
      AbstractBiMap.this.removeFromBothMaps(key);
      return true;
    }
    
    public boolean removeAll(Collection<?> keysToRemove)
    {
      return standardRemoveAll(keysToRemove);
    }
    
    public boolean retainAll(Collection<?> keysToRetain)
    {
      return standardRetainAll(keysToRetain);
    }
    
    public Iterator<K> iterator()
    {
      return Maps.keyIterator(entrySet().iterator());
    }
  }
  
  public Set<V> values()
  {
    Set<V> result = valueSet;
    return result == null ? (valueSet = new ValueSet(null)) : result;
  }
  
  private class ValueSet
    extends ForwardingSet<V>
  {
    final Set<V> valuesDelegate = inverse.keySet();
    
    private ValueSet() {}
    
    protected Set<V> delegate()
    {
      return valuesDelegate;
    }
    
    public Iterator<V> iterator()
    {
      return Maps.valueIterator(entrySet().iterator());
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return standardToArray(array);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set<Map.Entry<K, V>> result = entrySet;
    return result == null ? (entrySet = new EntrySet(null)) : result;
  }
  
  private class EntrySet
    extends ForwardingSet<Map.Entry<K, V>>
  {
    final Set<Map.Entry<K, V>> esDelegate = delegate.entrySet();
    
    private EntrySet() {}
    
    protected Set<Map.Entry<K, V>> delegate()
    {
      return esDelegate;
    }
    
    public void clear()
    {
      AbstractBiMap.this.clear();
    }
    
    public boolean remove(Object object)
    {
      if (!esDelegate.contains(object)) {
        return false;
      }
      Map.Entry<?, ?> entry = (Map.Entry)object;
      inverse.delegate.remove(entry.getValue());
      
      esDelegate.remove(entry);
      return true;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      final Iterator<Map.Entry<K, V>> iterator = esDelegate.iterator();
      new Iterator()
      {
        Map.Entry<K, V> entry;
        
        public boolean hasNext()
        {
          return iterator.hasNext();
        }
        
        public Map.Entry<K, V> next()
        {
          entry = ((Map.Entry)iterator.next());
          final Map.Entry<K, V> finalEntry = entry;
          
          new ForwardingMapEntry()
          {
            protected Map.Entry<K, V> delegate()
            {
              return finalEntry;
            }
            
            public V setValue(V value)
            {
              Preconditions.checkState(contains(this), "entry no longer in map");
              if (Objects.equal(value, getValue())) {
                return value;
              }
              Preconditions.checkArgument(!containsValue(value), "value already present: %s", new Object[] { value });
              
              V oldValue = finalEntry.setValue(value);
              Preconditions.checkState(Objects.equal(value, get(getKey())), "entry no longer in map");
              
              AbstractBiMap.this.updateInverseMap(getKey(), true, oldValue, value);
              return oldValue;
            }
          };
        }
        
        public void remove()
        {
          CollectPreconditions.checkRemove(entry != null);
          V value = entry.getValue();
          iterator.remove();
          AbstractBiMap.this.removeFromInverseMap(value);
        }
      };
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return standardToArray(array);
    }
    
    public boolean contains(Object o)
    {
      return Maps.containsEntryImpl(delegate(), o);
    }
    
    public boolean containsAll(Collection<?> c)
    {
      return standardContainsAll(c);
    }
    
    public boolean removeAll(Collection<?> c)
    {
      return standardRemoveAll(c);
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return standardRetainAll(c);
    }
  }
  
  private static class Inverse<K, V>
    extends AbstractBiMap<K, V>
  {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0L;
    
    private Inverse(Map<K, V> backward, AbstractBiMap<V, K> forward)
    {
      super(forward, null);
    }
    
    K checkKey(K key)
    {
      return (K)inverse.checkValue(key);
    }
    
    V checkValue(V value)
    {
      return (V)inverse.checkKey(value);
    }
    
    @GwtIncompatible("java.io.ObjectOuputStream")
    private void writeObject(ObjectOutputStream stream)
      throws IOException
    {
      stream.defaultWriteObject();
      stream.writeObject(inverse());
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException
    {
      stream.defaultReadObject();
      setInverse((AbstractBiMap)stream.readObject());
    }
    
    @GwtIncompatible("Not needed in the emulated source.")
    Object readResolve()
    {
      return inverse().inverse();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */