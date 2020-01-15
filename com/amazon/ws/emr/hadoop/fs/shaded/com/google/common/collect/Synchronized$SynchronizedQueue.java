package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Queue;
import javax.annotation.Nullable;

class Synchronized$SynchronizedQueue<E>
  extends Synchronized.SynchronizedCollection<E>
  implements Queue<E>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedQueue(Queue<E> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex, null);
  }
  
  Queue<E> delegate()
  {
    return (Queue)super.delegate();
  }
  
  /* Error */
  public E element()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:delegate	()Ljava/util/Queue;
    //   11: invokeinterface 44 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1587	-> byte code offset #0
    //   Java source line #1588	-> byte code offset #7
    //   Java source line #1589	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedQueue<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public boolean offer(E e)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:delegate	()Ljava/util/Queue;
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
    //   Java source line #1594	-> byte code offset #0
    //   Java source line #1595	-> byte code offset #7
    //   Java source line #1596	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedQueue<E>
    //   0	25	1	e	E
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public E peek()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:delegate	()Ljava/util/Queue;
    //   11: invokeinterface 57 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1601	-> byte code offset #0
    //   Java source line #1602	-> byte code offset #7
    //   Java source line #1603	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedQueue<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E poll()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:delegate	()Ljava/util/Queue;
    //   11: invokeinterface 60 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #1608	-> byte code offset #0
    //   Java source line #1609	-> byte code offset #7
    //   Java source line #1610	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedQueue<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  /* Error */
  public E remove()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedQueue:delegate	()Ljava/util/Queue;
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
    //   Java source line #1615	-> byte code offset #0
    //   Java source line #1616	-> byte code offset #7
    //   Java source line #1617	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedQueue<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */