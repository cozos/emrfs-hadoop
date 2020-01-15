package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ImmutableMultimap$Builder<K, V>
{
  Multimap<K, V> builderMultimap = new ImmutableMultimap.BuilderMultimap();
  Comparator<? super K> keyComparator;
  Comparator<? super V> valueComparator;
  
  public Builder<K, V> put(K key, V value)
  {
    CollectPreconditions.checkEntryNotNull(key, value);
    builderMultimap.put(key, value);
    return this;
  }
  
  public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry)
  {
    return put(entry.getKey(), entry.getValue());
  }
  
  /* Error */
  public Builder<K, V> putAll(K key, Iterable<? extends V> values)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +42 -> 43
    //   4: new 70	java/lang/NullPointerException
    //   7: dup
    //   8: ldc 72
    //   10: aload_2
    //   11: invokestatic 78	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Iterables:toString	(Ljava/lang/Iterable;)Ljava/lang/String;
    //   14: invokestatic 84	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: dup
    //   18: invokevirtual 88	java/lang/String:length	()I
    //   21: ifeq +9 -> 30
    //   24: invokevirtual 92	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   27: goto +12 -> 39
    //   30: pop
    //   31: new 80	java/lang/String
    //   34: dup_x1
    //   35: swap
    //   36: invokespecial 97	java/lang/String:<init>	(Ljava/lang/String;)V
    //   39: invokespecial 98	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   42: athrow
    //   43: aload_0
    //   44: getfield 32	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ImmutableMultimap$Builder:builderMultimap	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   47: aload_1
    //   48: invokeinterface 102 2 0
    //   53: astore_3
    //   54: aload_2
    //   55: invokeinterface 106 1 0
    //   60: astore 4
    //   62: aload 4
    //   64: invokeinterface 114 1 0
    //   69: ifeq +30 -> 99
    //   72: aload 4
    //   74: invokeinterface 117 1 0
    //   79: astore 5
    //   81: aload_1
    //   82: aload 5
    //   84: invokestatic 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/CollectPreconditions:checkEntryNotNull	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   87: aload_3
    //   88: aload 5
    //   90: invokeinterface 121 2 0
    //   95: pop
    //   96: goto -34 -> 62
    //   99: aload_0
    //   100: areturn
    // Line number table:
    //   Java source line #191	-> byte code offset #0
    //   Java source line #192	-> byte code offset #4
    //   Java source line #195	-> byte code offset #43
    //   Java source line #196	-> byte code offset #54
    //   Java source line #197	-> byte code offset #81
    //   Java source line #198	-> byte code offset #87
    //   Java source line #199	-> byte code offset #96
    //   Java source line #200	-> byte code offset #99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	Builder<K, V>
    //   0	101	1	key	K
    //   0	101	2	values	Iterable<? extends V>
    //   54	47	3	valueList	Collection<V>
    //   62	37	4	i$	java.util.Iterator
    //   81	15	5	value	V
  }
  
  public Builder<K, V> putAll(K key, V... values)
  {
    return putAll(key, Arrays.asList(values));
  }
  
  public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap)
  {
    for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : multimap.asMap().entrySet()) {
      putAll(entry.getKey(), (Iterable)entry.getValue());
    }
    return this;
  }
  
  public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator)
  {
    this.keyComparator = ((Comparator)Preconditions.checkNotNull(keyComparator));
    return this;
  }
  
  public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator)
  {
    this.valueComparator = ((Comparator)Preconditions.checkNotNull(valueComparator));
    return this;
  }
  
  public ImmutableMultimap<K, V> build()
  {
    if (valueComparator != null) {
      for (Collection<V> values : builderMultimap.asMap().values())
      {
        List<V> list = (List)values;
        Collections.sort(list, valueComparator);
      }
    }
    if (keyComparator != null)
    {
      Multimap<K, V> sortedCopy = new ImmutableMultimap.BuilderMultimap();
      List<Map.Entry<K, Collection<V>>> entries = Lists.newArrayList(builderMultimap.asMap().entrySet());
      
      Collections.sort(entries, Ordering.from(keyComparator).onKeys());
      for (Map.Entry<K, Collection<V>> entry : entries) {
        sortedCopy.putAll(entry.getKey(), (Iterable)entry.getValue());
      }
      builderMultimap = sortedCopy;
    }
    return ImmutableMultimap.copyOf(builderMultimap);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultimap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */