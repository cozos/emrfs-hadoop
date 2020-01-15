package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

class Synchronized$SynchronizedListMultimap<K, V>
  extends Synchronized.SynchronizedMultimap<K, V>
  implements ListMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedListMultimap(ListMultimap<K, V> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  ListMultimap<K, V> delegate()
  {
    return (ListMultimap)super.delegate();
  }
  
  /* Error */
  public java.util.List<V> get(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedListMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedListMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ListMultimap;
    //   11: aload_1
    //   12: invokeinterface 42 2 0
    //   17: aload_0
    //   18: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedListMultimap:mutex	Ljava/lang/Object;
    //   21: invokestatic 46	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$200	(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #709	-> byte code offset #0
    //   Java source line #710	-> byte code offset #7
    //   Java source line #711	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedListMultimap<K, V>
    //   0	32	1	key	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public java.util.List<V> removeAll(Object key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedListMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedListMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ListMultimap;
    //   11: aload_1
    //   12: invokeinterface 55 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #714	-> byte code offset #0
    //   Java source line #715	-> byte code offset #7
    //   Java source line #716	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedListMultimap<K, V>
    //   0	25	1	key	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public java.util.List<V> replaceValues(K key, Iterable<? extends V> values)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedListMultimap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedListMultimap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ListMultimap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 59 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: areturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #720	-> byte code offset #0
    //   Java source line #721	-> byte code offset #7
    //   Java source line #722	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedListMultimap<K, V>
    //   0	28	1	key	K
    //   0	28	2	values	Iterable<? extends V>
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedListMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */