package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultimap<K, V>
  extends Synchronized.SynchronizedObject
  implements Multimap<K, V>
{
  transient Set<K> keySet;
  transient Collection<V> valuesCollection;
  transient Collection<Map.Entry<K, V>> entries;
  transient Map<K, Collection<V>> asMap;
  transient Multiset<K> keys;
  private static final long serialVersionUID = 0L;
  
  Multimap<K, V> delegate()
  {
    return (Multimap)super.delegate();
  }
  
  Synchronized$SynchronizedMultimap(Multimap<K, V> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  /* Error */
  public int size()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: invokeinterface 64 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #533	-> byte code offset #0
    //   Java source line #534	-> byte code offset #7
    //   Java source line #535	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedMultimap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: invokeinterface 72 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #540	-> byte code offset #0
    //   Java source line #541	-> byte code offset #7
    //   Java source line #542	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedMultimap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public boolean containsKey(Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: invokeinterface 76 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #547	-> byte code offset #0
    //   Java source line #548	-> byte code offset #7
    //   Java source line #549	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMultimap<K, V>
    //   0	25	1	key	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public boolean containsValue(Object value)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: invokeinterface 80 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #554	-> byte code offset #0
    //   Java source line #555	-> byte code offset #7
    //   Java source line #556	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMultimap<K, V>
    //   0	25	1	value	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public boolean containsEntry(Object key, Object value)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 85 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #561	-> byte code offset #0
    //   Java source line #562	-> byte code offset #7
    //   Java source line #563	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultimap<K, V>
    //   0	28	1	key	Object
    //   0	28	2	value	Object
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public Collection<V> get(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: invokeinterface 89 2 0
    //   17: aload_0
    //   18: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   21: invokestatic 93	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$400	(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/Collection;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #568	-> byte code offset #0
    //   Java source line #569	-> byte code offset #7
    //   Java source line #570	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedMultimap<K, V>
    //   0	32	1	key	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public boolean put(K key, V value)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 97 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #575	-> byte code offset #0
    //   Java source line #576	-> byte code offset #7
    //   Java source line #577	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultimap<K, V>
    //   0	28	1	key	K
    //   0	28	2	value	V
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public boolean putAll(K key, Iterable<? extends V> values)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 102 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #582	-> byte code offset #0
    //   Java source line #583	-> byte code offset #7
    //   Java source line #584	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultimap<K, V>
    //   0	28	1	key	K
    //   0	28	2	values	Iterable<? extends V>
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public boolean putAll(Multimap<? extends K, ? extends V> multimap)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: invokeinterface 110 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #589	-> byte code offset #0
    //   Java source line #590	-> byte code offset #7
    //   Java source line #591	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMultimap<K, V>
    //   0	25	1	multimap	Multimap<? extends K, ? extends V>
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public Collection<V> replaceValues(K key, Iterable<? extends V> values)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 116 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: areturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #596	-> byte code offset #0
    //   Java source line #597	-> byte code offset #7
    //   Java source line #598	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultimap<K, V>
    //   0	28	1	key	K
    //   0	28	2	values	Iterable<? extends V>
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public boolean remove(Object key, Object value)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 119 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #603	-> byte code offset #0
    //   Java source line #604	-> byte code offset #7
    //   Java source line #605	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultimap<K, V>
    //   0	28	1	key	Object
    //   0	28	2	value	Object
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public Collection<V> removeAll(Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: aload_1
    //   12: invokeinterface 122 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #610	-> byte code offset #0
    //   Java source line #611	-> byte code offset #7
    //   Java source line #612	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMultimap<K, V>
    //   0	25	1	key	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  public void clear()
  {
    synchronized (mutex)
    {
      delegate().clear();
    }
  }
  
  public Set<K> keySet()
  {
    synchronized (mutex)
    {
      if (keySet == null) {
        keySet = Synchronized.access$300(delegate().keySet(), mutex);
      }
      return keySet;
    }
  }
  
  public Collection<V> values()
  {
    synchronized (mutex)
    {
      if (valuesCollection == null) {
        valuesCollection = Synchronized.access$500(delegate().values(), mutex);
      }
      return valuesCollection;
    }
  }
  
  public Collection<Map.Entry<K, V>> entries()
  {
    synchronized (mutex)
    {
      if (entries == null) {
        entries = Synchronized.access$400(delegate().entries(), mutex);
      }
      return entries;
    }
  }
  
  public Map<K, Collection<V>> asMap()
  {
    synchronized (mutex)
    {
      if (asMap == null) {
        asMap = new Synchronized.SynchronizedAsMap(delegate().asMap(), mutex);
      }
      return asMap;
    }
  }
  
  public Multiset<K> keys()
  {
    synchronized (mutex)
    {
      if (keys == null) {
        keys = Synchronized.multiset(delegate().keys(), mutex);
      }
      return keys;
    }
  }
  
  /* Error */
  public boolean equals(Object o)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_0
    //   2: if_acmpne +5 -> 7
    //   5: iconst_1
    //   6: ireturn
    //   7: aload_0
    //   8: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   11: dup
    //   12: astore_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   18: aload_1
    //   19: invokeinterface 167 2 0
    //   24: aload_2
    //   25: monitorexit
    //   26: ireturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #673	-> byte code offset #0
    //   Java source line #674	-> byte code offset #5
    //   Java source line #676	-> byte code offset #7
    //   Java source line #677	-> byte code offset #14
    //   Java source line #678	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedMultimap<K, V>
    //   0	32	1	o	Object
    //   12	17	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   14	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public int hashCode()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 62	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multimap;
    //   11: invokeinterface 171 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #682	-> byte code offset #0
    //   Java source line #683	-> byte code offset #7
    //   Java source line #684	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedMultimap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */