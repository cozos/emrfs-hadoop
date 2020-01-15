package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedList<E>
  extends Synchronized.SynchronizedCollection<E>
  implements List<E>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedList(List<E> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex, null);
  }
  
  List<E> delegate()
  {
    return (List)super.delegate();
  }
  
  public void add(int index, E element)
  {
    synchronized (mutex)
    {
      delegate().add(index, element);
    }
  }
  
  /* Error */
  public boolean addAll(int index, java.util.Collection<? extends E> c)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: iload_1
    //   12: aload_2
    //   13: invokeinterface 56 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: ireturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #327	-> byte code offset #0
    //   Java source line #328	-> byte code offset #7
    //   Java source line #329	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedList<E>
    //   0	28	1	index	int
    //   0	28	2	c	java.util.Collection<? extends E>
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public E get(int index)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: iload_1
    //   12: invokeinterface 65 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #334	-> byte code offset #0
    //   Java source line #335	-> byte code offset #7
    //   Java source line #336	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedList<E>
    //   0	25	1	index	int
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public int indexOf(Object o)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: aload_1
    //   12: invokeinterface 69 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #341	-> byte code offset #0
    //   Java source line #342	-> byte code offset #7
    //   Java source line #343	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedList<E>
    //   0	25	1	o	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public int lastIndexOf(Object o)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: aload_1
    //   12: invokeinterface 73 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: ireturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #348	-> byte code offset #0
    //   Java source line #349	-> byte code offset #7
    //   Java source line #350	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedList<E>
    //   0	25	1	o	Object
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  public ListIterator<E> listIterator()
  {
    return delegate().listIterator();
  }
  
  public ListIterator<E> listIterator(int index)
  {
    return delegate().listIterator(index);
  }
  
  /* Error */
  public E remove(int index)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: iload_1
    //   12: invokeinterface 83 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #365	-> byte code offset #0
    //   Java source line #366	-> byte code offset #7
    //   Java source line #367	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedList<E>
    //   0	25	1	index	int
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public E set(int index, E element)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: iload_1
    //   12: aload_2
    //   13: invokeinterface 87 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: areturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #372	-> byte code offset #0
    //   Java source line #373	-> byte code offset #7
    //   Java source line #374	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedList<E>
    //   0	28	1	index	int
    //   0	28	2	element	E
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  /* Error */
  public List<E> subList(int fromIndex, int toIndex)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: iload_1
    //   12: iload_2
    //   13: invokeinterface 91 3 0
    //   18: aload_0
    //   19: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   22: invokestatic 95	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$200	(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;
    //   25: aload_3
    //   26: monitorexit
    //   27: areturn
    //   28: astore 4
    //   30: aload_3
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Line number table:
    //   Java source line #379	-> byte code offset #0
    //   Java source line #380	-> byte code offset #7
    //   Java source line #381	-> byte code offset #28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SynchronizedList<E>
    //   0	35	1	fromIndex	int
    //   0	35	2	toIndex	int
    //   5	26	3	Ljava/lang/Object;	Object
    //   28	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	28	finally
    //   28	32	28	finally
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
    //   8: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   11: dup
    //   12: astore_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   18: aload_1
    //   19: invokeinterface 101 2 0
    //   24: aload_2
    //   25: monitorexit
    //   26: ireturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #385	-> byte code offset #0
    //   Java source line #386	-> byte code offset #5
    //   Java source line #388	-> byte code offset #7
    //   Java source line #389	-> byte code offset #14
    //   Java source line #390	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedList<E>
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
    //   1: getfield 40	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 42	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedList:delegate	()Ljava/util/List;
    //   11: invokeinterface 105 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: ireturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #394	-> byte code offset #0
    //   Java source line #395	-> byte code offset #7
    //   Java source line #396	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	SynchronizedList<E>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */