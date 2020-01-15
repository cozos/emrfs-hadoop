package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map.Entry;

class AbstractBiMap$EntrySet$1$1
  extends ForwardingMapEntry<K, V>
{
  AbstractBiMap$EntrySet$1$1(AbstractBiMap.EntrySet.1 param1, Map.Entry paramEntry) {}
  
  protected Map.Entry<K, V> delegate()
  {
    return val$finalEntry;
  }
  
  public V setValue(V value)
  {
    Preconditions.checkState(this$2.this$1.contains(this), "entry no longer in map");
    if (Objects.equal(value, getValue())) {
      return value;
    }
    Preconditions.checkArgument(!this$2.this$1.this$0.containsValue(value), "value already present: %s", new Object[] { value });
    
    V oldValue = val$finalEntry.setValue(value);
    Preconditions.checkState(Objects.equal(value, this$2.this$1.this$0.get(getKey())), "entry no longer in map");
    
    AbstractBiMap.access$600(this$2.this$1.this$0, getKey(), true, oldValue, value);
    return oldValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractBiMap.EntrySet.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */