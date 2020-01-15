package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.SortedSet;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedSet<E>
  extends Synchronized.SynchronizedSet<E>
  implements SortedSet<E>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedSortedSet(SortedSet<E> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  SortedSet<E> delegate()
  {
    return (SortedSet)super.delegate();
  }
  
  /* Error */
  public java.util.Comparator<? super E> comparator()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:delegate	()Ljava/util/SortedSet;
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
    //   Java source line #259	-> byte code offset #0
    //   Java source line #260	-> byte code offset #7
    //   Java source line #261	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedSortedSet<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:delegate	()Ljava/util/SortedSet;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 50 3 0
    //   18: aload_0
    //   19: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   22: invokestatic 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$100	(Ljava/util/SortedSet;Ljava/lang/Object;)Ljava/util/SortedSet;
    //   25: aload_3
    //   26: monitorexit
    //   27: areturn
    //   28: astore 4
    //   30: aload_3
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Line number table:
    //   Java source line #266	-> byte code offset #0
    //   Java source line #267	-> byte code offset #7
    //   Java source line #268	-> byte code offset #28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SynchronizedSortedSet<E>
    //   0	35	1	fromElement	E
    //   0	35	2	toElement	E
    //   5	26	3	Ljava/lang/Object;	Object
    //   28	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	28	finally
    //   28	32	28	finally
  }
  
  /* Error */
  public SortedSet<E> headSet(E toElement)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:delegate	()Ljava/util/SortedSet;
    //   11: aload_1
    //   12: invokeinterface 61 2 0
    //   17: aload_0
    //   18: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   21: invokestatic 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$100	(Ljava/util/SortedSet;Ljava/lang/Object;)Ljava/util/SortedSet;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #273	-> byte code offset #0
    //   Java source line #274	-> byte code offset #7
    //   Java source line #275	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedSortedSet<E>
    //   0	32	1	toElement	E
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public SortedSet<E> tailSet(E fromElement)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:delegate	()Ljava/util/SortedSet;
    //   11: aload_1
    //   12: invokeinterface 64 2 0
    //   17: aload_0
    //   18: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   21: invokestatic 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$100	(Ljava/util/SortedSet;Ljava/lang/Object;)Ljava/util/SortedSet;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #280	-> byte code offset #0
    //   Java source line #281	-> byte code offset #7
    //   Java source line #282	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedSortedSet<E>
    //   0	32	1	fromElement	E
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public E first()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:delegate	()Ljava/util/SortedSet;
    //   11: invokeinterface 68 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #287	-> byte code offset #0
    //   Java source line #288	-> byte code offset #7
    //   Java source line #289	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedSortedSet<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E last()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSortedSet:delegate	()Ljava/util/SortedSet;
    //   11: invokeinterface 71 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #294	-> byte code offset #0
    //   Java source line #295	-> byte code offset #7
    //   Java source line #296	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedSortedSet<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */