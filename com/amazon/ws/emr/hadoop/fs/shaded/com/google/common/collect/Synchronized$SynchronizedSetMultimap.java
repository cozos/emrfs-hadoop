package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSetMultimap<K, V>
  extends Synchronized.SynchronizedMultimap<K, V>
  implements SetMultimap<K, V>
{
  transient Set<Map.Entry<K, V>> entrySet;
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedSetMultimap(SetMultimap<K, V> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  SetMultimap<K, V> delegate()
  {
    return (SetMultimap)super.delegate();
  }
  
  /* Error */
  public Set<V> get(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSetMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSetMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/SetMultimap;
    //   11: aload_1
    //   12: invokeinterface 50 2 0
    //   17: aload_0
    //   18: getfield 46	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSetMultimap:mutex	Ljava/lang/Object;
    //   21: invokestatic 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:set	(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #748	-> byte code offset #0
    //   Java source line #749	-> byte code offset #7
    //   Java source line #750	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedSetMultimap<K, V>
    //   0	32	1	key	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public Set<V> removeAll(Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSetMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSetMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/SetMultimap;
    //   11: aload_1
    //   12: invokeinterface 63 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #753	-> byte code offset #0
    //   Java source line #754	-> byte code offset #7
    //   Java source line #755	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedSetMultimap<K, V>
    //   0	25	1	key	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public Set<V> replaceValues(K key, Iterable<? extends V> values)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSetMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSetMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/SetMultimap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 67 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: areturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #759	-> byte code offset #0
    //   Java source line #760	-> byte code offset #7
    //   Java source line #761	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedSetMultimap<K, V>
    //   0	28	1	key	K
    //   0	28	2	values	Iterable<? extends V>
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    synchronized (mutex)
    {
      if (entrySet == null) {
        entrySet = Synchronized.set(delegate().entries(), mutex);
      }
      return entrySet;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedSetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */