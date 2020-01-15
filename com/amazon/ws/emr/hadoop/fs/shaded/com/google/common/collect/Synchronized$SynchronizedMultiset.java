package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultiset<E>
  extends Synchronized.SynchronizedCollection<E>
  implements Multiset<E>
{
  transient Set<E> elementSet;
  transient Set<Multiset.Entry<E>> entrySet;
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedMultiset(Multiset<E> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex, null);
  }
  
  Multiset<E> delegate()
  {
    return (Multiset)super.delegate();
  }
  
  /* Error */
  public int count(Object o)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multiset;
    //   11: aload_1
    //   12: invokeinterface 52 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #434	-> byte code offset #0
    //   Java source line #435	-> byte code offset #7
    //   Java source line #436	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedMultiset<E>
    //   0	25	1	o	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public int add(E e, int n)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multiset;
    //   11: aload_1
    //   12: iload_2
    //   13: invokeinterface 61 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #441	-> byte code offset #0
    //   Java source line #442	-> byte code offset #7
    //   Java source line #443	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultiset<E>
    //   0	28	1	e	E
    //   0	28	2	n	int
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public int remove(Object o, int n)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multiset;
    //   11: aload_1
    //   12: iload_2
    //   13: invokeinterface 68 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #448	-> byte code offset #0
    //   Java source line #449	-> byte code offset #7
    //   Java source line #450	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultiset<E>
    //   0	28	1	o	Object
    //   0	28	2	n	int
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public int setCount(E element, int count)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multiset;
    //   11: aload_1
    //   12: iload_2
    //   13: invokeinterface 71 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #455	-> byte code offset #0
    //   Java source line #456	-> byte code offset #7
    //   Java source line #457	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedMultiset<E>
    //   0	28	1	element	E
    //   0	28	2	count	int
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public boolean setCount(E element, int oldCount, int newCount)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore 4
    //   7: monitorenter
    //   8: aload_0
    //   9: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multiset;
    //   12: aload_1
    //   13: iload_2
    //   14: iload_3
    //   15: invokeinterface 75 4 0
    //   20: aload 4
    //   22: monitorexit
    //   23: ireturn
    //   24: astore 5
    //   26: aload 4
    //   28: monitorexit
    //   29: aload 5
    //   31: athrow
    // Line number table:
    //   Java source line #462	-> byte code offset #0
    //   Java source line #463	-> byte code offset #8
    //   Java source line #464	-> byte code offset #24
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedMultiset<E>
    //   0	32	1	element	E
    //   0	32	2	oldCount	int
    //   0	32	3	newCount	int
    //   5	22	4	Ljava/lang/Object;	Object
    //   24	6	5	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   8	23	24	finally
    //   24	29	24	finally
  }
  
  public Set<E> elementSet()
  {
    synchronized (mutex)
    {
      if (elementSet == null) {
        elementSet = Synchronized.access$300(delegate().elementSet(), mutex);
      }
      return elementSet;
    }
  }
  
  public Set<Multiset.Entry<E>> entrySet()
  {
    synchronized (mutex)
    {
      if (entrySet == null) {
        entrySet = Synchronized.access$300(delegate().entrySet(), mutex);
      }
      return entrySet;
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
    //   8: getfield 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:mutex	Ljava/lang/Object;
    //   11: dup
    //   12: astore_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multiset;
    //   18: aload_1
    //   19: invokeinterface 94 2 0
    //   24: aload_2
    //   25: monitorexit
    //   26: ireturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #488	-> byte code offset #0
    //   Java source line #489	-> byte code offset #5
    //   Java source line #491	-> byte code offset #7
    //   Java source line #492	-> byte code offset #14
    //   Java source line #493	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedMultiset<E>
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
    //   1: getfield 48	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedMultiset:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Multiset;
    //   11: invokeinterface 98 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #497	-> byte code offset #0
    //   Java source line #498	-> byte code offset #7
    //   Java source line #499	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedMultiset<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */