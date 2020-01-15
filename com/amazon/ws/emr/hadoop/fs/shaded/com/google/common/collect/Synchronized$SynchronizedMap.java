package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMap<K, V>
  extends Synchronized.SynchronizedObject
  implements Map<K, V>
{
  transient Set<K> keySet;
  transient Collection<V> values;
  transient Set<Map.Entry<K, V>> entrySet;
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedMap(Map<K, V> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  Map<K, V> delegate()
  {
    return (Map)super.delegate();
  }
  
  public void clear()
  {
    synchronized (mutex)
    {
      delegate().clear();
    }
  }
  
  /* Error */
  public boolean containsKey(Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 61 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #946	-> byte code offset #0
    //   Java source line #947	-> byte code offset #7
    //   Java source line #948	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMap<K, V>
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
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 65 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #953	-> byte code offset #0
    //   Java source line #954	-> byte code offset #7
    //   Java source line #955	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMap<K, V>
    //   0	25	1	value	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    synchronized (mutex)
    {
      if (entrySet == null) {
        entrySet = Synchronized.set(delegate().entrySet(), mutex);
      }
      return entrySet;
    }
  }
  
  /* Error */
  public V get(Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 79 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #970	-> byte code offset #0
    //   Java source line #971	-> byte code offset #7
    //   Java source line #972	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMap<K, V>
    //   0	25	1	key	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: invokeinterface 83 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #977	-> byte code offset #0
    //   Java source line #978	-> byte code offset #7
    //   Java source line #979	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedMap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  public Set<K> keySet()
  {
    synchronized (mutex)
    {
      if (keySet == null) {
        keySet = Synchronized.set(delegate().keySet(), mutex);
      }
      return keySet;
    }
  }
  
  /* Error */
  public V put(K key, V value)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 91 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: areturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #994	-> byte code offset #0
    //   Java source line #995	-> byte code offset #7
    //   Java source line #996	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMap<K, V>
    //   0	28	1	key	K
    //   0	28	2	value	V
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  public void putAll(Map<? extends K, ? extends V> map)
  {
    synchronized (mutex)
    {
      delegate().putAll(map);
    }
  }
  
  /* Error */
  public V remove(Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 102 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1008	-> byte code offset #0
    //   Java source line #1009	-> byte code offset #7
    //   Java source line #1010	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMap<K, V>
    //   0	25	1	key	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public int size()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: invokeinterface 106 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1015	-> byte code offset #0
    //   Java source line #1016	-> byte code offset #7
    //   Java source line #1017	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedMap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  public Collection<V> values()
  {
    synchronized (mutex)
    {
      if (values == null) {
        values = Synchronized.access$500(delegate().values(), mutex);
      }
      return values;
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
    //   8: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   11: dup
    //   12: astore_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   18: aload_1
    //   19: invokeinterface 118 2 0
    //   24: aload_2
    //   25: monitorexit
    //   26: ireturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #1031	-> byte code offset #0
    //   Java source line #1032	-> byte code offset #5
    //   Java source line #1034	-> byte code offset #7
    //   Java source line #1035	-> byte code offset #14
    //   Java source line #1036	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedMap<K, V>
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
    //   1: getfield 49	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 51	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMap:delegate	()Ljava/util/Map;
    //   11: invokeinterface 122 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1040	-> byte code offset #0
    //   Java source line #1041	-> byte code offset #7
    //   Java source line #1042	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedMap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */