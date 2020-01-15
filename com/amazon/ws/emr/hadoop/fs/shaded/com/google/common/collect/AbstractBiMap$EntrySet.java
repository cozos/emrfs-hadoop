package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractBiMap$EntrySet
  extends ForwardingSet<Map.Entry<K, V>>
{
  final Set<Map.Entry<K, V>> esDelegate = AbstractBiMap.access$200(this$0).entrySet();
  
  private AbstractBiMap$EntrySet(AbstractBiMap paramAbstractBiMap) {}
  
  protected Set<Map.Entry<K, V>> delegate()
  {
    return esDelegate;
  }
  
  public void clear()
  {
    this$0.clear();
  }
  
  public boolean remove(Object object)
  {
    if (!esDelegate.contains(object)) {
      return false;
    }
    Map.Entry<?, ?> entry = (Map.Entry)object;
    AbstractBiMap.access$200(this$0.inverse).remove(entry.getValue());
    
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
            Preconditions.checkArgument(!this$0.containsValue(value), "value already present: %s", new Object[] { value });
            
            V oldValue = finalEntry.setValue(value);
            Preconditions.checkState(Objects.equal(value, this$0.get(getKey())), "entry no longer in map");
            
            AbstractBiMap.access$600(this$0, getKey(), true, oldValue, value);
            return oldValue;
          }
        };
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(entry != null);
        V value = entry.getValue();
        iterator.remove();
        AbstractBiMap.access$700(this$0, value);
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractBiMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */