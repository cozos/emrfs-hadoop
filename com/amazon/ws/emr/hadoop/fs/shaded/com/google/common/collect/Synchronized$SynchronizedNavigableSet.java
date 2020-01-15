package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
@VisibleForTesting
class Synchronized$SynchronizedNavigableSet<E>
  extends Synchronized.SynchronizedSortedSet<E>
  implements NavigableSet<E>
{
  transient NavigableSet<E> descendingSet;
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedNavigableSet(NavigableSet<E> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  NavigableSet<E> delegate()
  {
    return (NavigableSet)super.delegate();
  }
  
  /* Error */
  public E ceiling(E e)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   11: aload_1
    //   12: invokeinterface 47 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1237	-> byte code offset #0
    //   Java source line #1238	-> byte code offset #7
    //   Java source line #1239	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableSet<E>
    //   0	25	1	e	E
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  public Iterator<E> descendingIterator()
  {
    return delegate().descendingIterator();
  }
  
  public NavigableSet<E> descendingSet()
  {
    synchronized (mutex)
    {
      if (descendingSet == null)
      {
        NavigableSet<E> dS = Synchronized.navigableSet(delegate().descendingSet(), mutex);
        
        descendingSet = dS;
        return dS;
      }
      return descendingSet;
    }
  }
  
  /* Error */
  public E floor(E e)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   11: aload_1
    //   12: invokeinterface 69 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1261	-> byte code offset #0
    //   Java source line #1262	-> byte code offset #7
    //   Java source line #1263	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableSet<E>
    //   0	25	1	e	E
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public NavigableSet<E> headSet(E toElement, boolean inclusive)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   11: aload_1
    //   12: iload_2
    //   13: invokeinterface 73 3 0
    //   18: aload_0
    //   19: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   22: invokestatic 65	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:navigableSet	(Ljava/util/NavigableSet;Ljava/lang/Object;)Ljava/util/NavigableSet;
    //   25: aload_3
    //   26: monitorexit
    //   27: areturn
    //   28: astore 4
    //   30: aload_3
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Line number table:
    //   Java source line #1267	-> byte code offset #0
    //   Java source line #1268	-> byte code offset #7
    //   Java source line #1270	-> byte code offset #28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SynchronizedNavigableSet<E>
    //   0	35	1	toElement	E
    //   0	35	2	inclusive	boolean
    //   5	26	3	Ljava/lang/Object;	Object
    //   28	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	28	finally
    //   28	32	28	finally
  }
  
  /* Error */
  public E higher(E e)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
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
    //   Java source line #1274	-> byte code offset #0
    //   Java source line #1275	-> byte code offset #7
    //   Java source line #1276	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableSet<E>
    //   0	25	1	e	E
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public E lower(E e)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   11: aload_1
    //   12: invokeinterface 82 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1280	-> byte code offset #0
    //   Java source line #1281	-> byte code offset #7
    //   Java source line #1282	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableSet<E>
    //   0	25	1	e	E
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public E pollFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   11: invokeinterface 86 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1286	-> byte code offset #0
    //   Java source line #1287	-> byte code offset #7
    //   Java source line #1288	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedNavigableSet<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E pollLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   11: invokeinterface 89 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1292	-> byte code offset #0
    //   Java source line #1293	-> byte code offset #7
    //   Java source line #1294	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedNavigableSet<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore 5
    //   7: monitorenter
    //   8: aload_0
    //   9: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   12: aload_1
    //   13: iload_2
    //   14: aload_3
    //   15: iload 4
    //   17: invokeinterface 93 5 0
    //   22: aload_0
    //   23: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   26: invokestatic 65	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:navigableSet	(Ljava/util/NavigableSet;Ljava/lang/Object;)Ljava/util/NavigableSet;
    //   29: aload 5
    //   31: monitorexit
    //   32: areturn
    //   33: astore 6
    //   35: aload 5
    //   37: monitorexit
    //   38: aload 6
    //   40: athrow
    // Line number table:
    //   Java source line #1299	-> byte code offset #0
    //   Java source line #1300	-> byte code offset #8
    //   Java source line #1302	-> byte code offset #33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	SynchronizedNavigableSet<E>
    //   0	41	1	fromElement	E
    //   0	41	2	fromInclusive	boolean
    //   0	41	3	toElement	E
    //   0	41	4	toInclusive	boolean
    //   5	31	5	Ljava/lang/Object;	Object
    //   33	6	6	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   8	32	33	finally
    //   33	38	33	finally
  }
  
  /* Error */
  public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 45	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:delegate	()Ljava/util/NavigableSet;
    //   11: aload_1
    //   12: iload_2
    //   13: invokeinterface 99 3 0
    //   18: aload_0
    //   19: getfield 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableSet:mutex	Ljava/lang/Object;
    //   22: invokestatic 65	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:navigableSet	(Ljava/util/NavigableSet;Ljava/lang/Object;)Ljava/util/NavigableSet;
    //   25: aload_3
    //   26: monitorexit
    //   27: areturn
    //   28: astore 4
    //   30: aload_3
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Line number table:
    //   Java source line #1306	-> byte code offset #0
    //   Java source line #1307	-> byte code offset #7
    //   Java source line #1309	-> byte code offset #28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SynchronizedNavigableSet<E>
    //   0	35	1	fromElement	E
    //   0	35	2	inclusive	boolean
    //   5	26	3	Ljava/lang/Object;	Object
    //   28	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	28	finally
    //   28	32	28	finally
  }
  
  public SortedSet<E> headSet(E toElement)
  {
    return headSet(toElement, false);
  }
  
  public SortedSet<E> subSet(E fromElement, E toElement)
  {
    return subSet(fromElement, true, toElement, false);
  }
  
  public SortedSet<E> tailSet(E fromElement)
  {
    return tailSet(fromElement, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedNavigableSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */