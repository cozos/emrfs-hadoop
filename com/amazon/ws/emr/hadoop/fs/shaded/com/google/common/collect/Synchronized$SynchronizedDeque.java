package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Deque;
import javax.annotation.Nullable;

@GwtIncompatible("Deque")
final class Synchronized$SynchronizedDeque<E>
  extends Synchronized.SynchronizedQueue<E>
  implements Deque<E>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedDeque(Deque<E> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  Deque<E> delegate()
  {
    return (Deque)super.delegate();
  }
  
  public void addFirst(E e)
  {
    synchronized (mutex)
    {
      delegate().addFirst(e);
    }
  }
  
  public void addLast(E e)
  {
    synchronized (mutex)
    {
      delegate().addLast(e);
    }
  }
  
  /* Error */
  public boolean offerFirst(E e)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: aload_1
    //   12: invokeinterface 58 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1656	-> byte code offset #0
    //   Java source line #1657	-> byte code offset #7
    //   Java source line #1658	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedDeque<E>
    //   0	25	1	e	E
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public boolean offerLast(E e)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
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
    //   Java source line #1663	-> byte code offset #0
    //   Java source line #1664	-> byte code offset #7
    //   Java source line #1665	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedDeque<E>
    //   0	25	1	e	E
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public E removeFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: invokeinterface 65 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1670	-> byte code offset #0
    //   Java source line #1671	-> byte code offset #7
    //   Java source line #1672	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E removeLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
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
    //   Java source line #1677	-> byte code offset #0
    //   Java source line #1678	-> byte code offset #7
    //   Java source line #1679	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E pollFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
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
    //   Java source line #1684	-> byte code offset #0
    //   Java source line #1685	-> byte code offset #7
    //   Java source line #1686	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
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
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: invokeinterface 74 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1691	-> byte code offset #0
    //   Java source line #1692	-> byte code offset #7
    //   Java source line #1693	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E getFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: invokeinterface 77 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1698	-> byte code offset #0
    //   Java source line #1699	-> byte code offset #7
    //   Java source line #1700	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E getLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: invokeinterface 80 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1705	-> byte code offset #0
    //   Java source line #1706	-> byte code offset #7
    //   Java source line #1707	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E peekFirst()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: invokeinterface 83 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1712	-> byte code offset #0
    //   Java source line #1713	-> byte code offset #7
    //   Java source line #1714	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E peekLast()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
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
    //   Java source line #1719	-> byte code offset #0
    //   Java source line #1720	-> byte code offset #7
    //   Java source line #1721	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public boolean removeFirstOccurrence(Object o)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: aload_1
    //   12: invokeinterface 89 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1726	-> byte code offset #0
    //   Java source line #1727	-> byte code offset #7
    //   Java source line #1728	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedDeque<E>
    //   0	25	1	o	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public boolean removeLastOccurrence(Object o)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: aload_1
    //   12: invokeinterface 93 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1733	-> byte code offset #0
    //   Java source line #1734	-> byte code offset #7
    //   Java source line #1735	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedDeque<E>
    //   0	25	1	o	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  public void push(E e)
  {
    synchronized (mutex)
    {
      delegate().push(e);
    }
  }
  
  /* Error */
  public E pop()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: invokeinterface 99 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1747	-> byte code offset #0
    //   Java source line #1748	-> byte code offset #7
    //   Java source line #1749	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public java.util.Iterator<E> descendingIterator()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 43	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedDeque:delegate	()Ljava/util/Deque;
    //   11: invokeinterface 103 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1754	-> byte code offset #0
    //   Java source line #1755	-> byte code offset #7
    //   Java source line #1756	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedDeque<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedDeque
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */