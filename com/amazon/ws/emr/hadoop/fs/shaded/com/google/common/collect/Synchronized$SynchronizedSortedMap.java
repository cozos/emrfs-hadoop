package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.SortedMap;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedMap<K, V>
  extends Synchronized.SynchronizedMap<K, V>
  implements SortedMap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedSortedMap(SortedMap<K, V> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  SortedMap<K, V> delegate()
  {
    return (SortedMap)super.delegate();
  }
  
  /* Error */
  public java.util.Comparator<? super K> comparator()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:delegate	()Ljava/util/SortedMap;
    //   11: invokeinterface 42 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1065	-> byte code offset #0
    //   Java source line #1066	-> byte code offset #7
    //   Java source line #1067	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedSortedMap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public K firstKey()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:delegate	()Ljava/util/SortedMap;
    //   11: invokeinterface 50 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1071	-> byte code offset #0
    //   Java source line #1072	-> byte code offset #7
    //   Java source line #1073	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedSortedMap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public SortedMap<K, V> headMap(K toKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:delegate	()Ljava/util/SortedMap;
    //   11: aload_1
    //   12: invokeinterface 54 2 0
    //   17: aload_0
    //   18: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   21: invokestatic 58	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:sortedMap	(Ljava/util/SortedMap;Ljava/lang/Object;)Ljava/util/SortedMap;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #1077	-> byte code offset #0
    //   Java source line #1078	-> byte code offset #7
    //   Java source line #1079	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedSortedMap<K, V>
    //   0	32	1	toKey	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public K lastKey()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:delegate	()Ljava/util/SortedMap;
    //   11: invokeinterface 63 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1083	-> byte code offset #0
    //   Java source line #1084	-> byte code offset #7
    //   Java source line #1085	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedSortedMap<K, V>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public SortedMap<K, V> subMap(K fromKey, K toKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:delegate	()Ljava/util/SortedMap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 67 3 0
    //   18: aload_0
    //   19: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   22: invokestatic 58	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:sortedMap	(Ljava/util/SortedMap;Ljava/lang/Object;)Ljava/util/SortedMap;
    //   25: aload_3
    //   26: monitorexit
    //   27: areturn
    //   28: astore 4
    //   30: aload_3
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Line number table:
    //   Java source line #1089	-> byte code offset #0
    //   Java source line #1090	-> byte code offset #7
    //   Java source line #1091	-> byte code offset #28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SynchronizedSortedMap<K, V>
    //   0	35	1	fromKey	K
    //   0	35	2	toKey	K
    //   5	26	3	Ljava/lang/Object;	Object
    //   28	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	28	finally
    //   28	32	28	finally
  }
  
  /* Error */
  public SortedMap<K, V> tailMap(K fromKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:delegate	()Ljava/util/SortedMap;
    //   11: aload_1
    //   12: invokeinterface 71 2 0
    //   17: aload_0
    //   18: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedMap:mutex	Ljava/lang/Object;
    //   21: invokestatic 58	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:sortedMap	(Ljava/util/SortedMap;Ljava/lang/Object;)Ljava/util/SortedMap;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #1095	-> byte code offset #0
    //   Java source line #1096	-> byte code offset #7
    //   Java source line #1097	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedSortedMap<K, V>
    //   0	32	1	fromKey	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedSortedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */