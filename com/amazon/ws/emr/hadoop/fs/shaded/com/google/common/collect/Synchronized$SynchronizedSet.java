package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSet<E>
  extends Synchronized.SynchronizedCollection<E>
  implements Set<E>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedSet(Set<E> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex, null);
  }
  
  Set<E> delegate()
  {
    return (Set)super.delegate();
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
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSet:mutex	Ljava/lang/Object;
    //   11: dup
    //   12: astore_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSet:delegate	()Ljava/util/Set;
    //   18: aload_1
    //   19: invokeinterface 44 2 0
    //   24: aload_2
    //   25: monitorexit
    //   26: ireturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #225	-> byte code offset #0
    //   Java source line #226	-> byte code offset #5
    //   Java source line #228	-> byte code offset #7
    //   Java source line #229	-> byte code offset #14
    //   Java source line #230	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedSet<E>
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
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedSet:delegate	()Ljava/util/Set;
    //   11: invokeinterface 53 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #234	-> byte code offset #0
    //   Java source line #235	-> byte code offset #7
    //   Java source line #236	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedSet<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */