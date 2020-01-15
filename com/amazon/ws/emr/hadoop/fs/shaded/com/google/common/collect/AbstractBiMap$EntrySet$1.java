package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet$1
  implements Iterator<Map.Entry<K, V>>
{
  Map.Entry<K, V> entry;
  
  AbstractBiMap$EntrySet$1(AbstractBiMap.EntrySet paramEntrySet, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public Map.Entry<K, V> next()
  {
    entry = ((Map.Entry)val$iterator.next());
    final Map.Entry<K, V> finalEntry = entry;
    
    new ForwardingMapEntry()
    {
      protected Map.Entry<K, V> delegate()
      {
        return finalEntry;
      }
      
      public V setValue(V value)
      {
        Preconditions.checkState(this$1.contains(this), "entry no longer in map");
        if (Objects.equal(value, getValue())) {
          return value;
        }
        Preconditions.checkArgument(!this$1.this$0.containsValue(value), "value already present: %s", new Object[] { value });
        
        V oldValue = finalEntry.setValue(value);
        Preconditions.checkState(Objects.equal(value, this$1.this$0.get(getKey())), "entry no longer in map");
        
        AbstractBiMap.access$600(this$1.this$0, getKey(), true, oldValue, value);
        return oldValue;
      }
    };
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(entry != null);
    V value = entry.getValue();
    val$iterator.remove();
    AbstractBiMap.access$700(this$1.this$0, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractBiMap.EntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */