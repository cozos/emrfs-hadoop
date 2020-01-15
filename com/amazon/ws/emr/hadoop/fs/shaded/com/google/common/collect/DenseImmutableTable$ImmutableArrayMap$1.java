package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class DenseImmutableTable$ImmutableArrayMap$1
  extends ImmutableMapEntrySet<K, V>
{
  DenseImmutableTable$ImmutableArrayMap$1(DenseImmutableTable.ImmutableArrayMap paramImmutableArrayMap) {}
  
  ImmutableMap<K, V> map()
  {
    return this$0;
  }
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    new AbstractIterator()
    {
      private int index = -1;
      private final int maxIndex = this$0.keyToIndex().size();
      
      protected Map.Entry<K, V> computeNext()
      {
        for (index += 1; index < maxIndex; index += 1)
        {
          V value = this$0.getValue(index);
          if (value != null) {
            return Maps.immutableEntry(this$0.getKey(index), value);
          }
        }
        return (Map.Entry)endOfData();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */