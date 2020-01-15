package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class WellBehavedMap$EntrySet$1$1
  extends AbstractMapEntry<K, V>
{
  WellBehavedMap$EntrySet$1$1(WellBehavedMap.EntrySet.1 param1, Object paramObject) {}
  
  public K getKey()
  {
    return (K)val$key;
  }
  
  public V getValue()
  {
    return (V)this$2.this$1.this$0.get(val$key);
  }
  
  public V setValue(V value)
  {
    return (V)this$2.this$1.this$0.put(val$key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.WellBehavedMap.EntrySet.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */