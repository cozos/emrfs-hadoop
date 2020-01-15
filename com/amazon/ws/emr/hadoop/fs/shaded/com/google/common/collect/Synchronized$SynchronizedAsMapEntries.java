package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapEntries<K, V>
  extends Synchronized.SynchronizedSet<Map.Entry<K, Collection<V>>>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    final Iterator<Map.Entry<K, Collection<V>>> iterator = super.iterator();
    new ForwardingIterator()
    {
      protected Iterator<Map.Entry<K, Collection<V>>> delegate()
      {
        return iterator;
      }
      
      public Map.Entry<K, Collection<V>> next()
      {
        final Map.Entry<K, Collection<V>> entry = (Map.Entry)super.next();
        new ForwardingMapEntry()
        {
          protected Map.Entry<K, Collection<V>> delegate()
          {
            return entry;
          }
          
          public Collection<V> getValue()
          {
            return Synchronized.access$400((Collection)entry.getValue(), mutex);
          }
        };
      }
    };
  }
  
  /* Error */
  public Object[] toArray()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   11: invokestatic 56	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ObjectArrays:toArrayImpl	(Ljava/util/Collection;)[Ljava/lang/Object;
    //   14: aload_1
    //   15: monitorexit
    //   16: areturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #871	-> byte code offset #0
    //   Java source line #872	-> byte code offset #7
    //   Java source line #873	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	SynchronizedAsMapEntries<K, V>
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  /* Error */
  public <T> T[] toArray(T[] array)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   11: aload_1
    //   12: invokestatic 64	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/ObjectArrays:toArrayImpl	(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;
    //   15: aload_2
    //   16: monitorexit
    //   17: areturn
    //   18: astore_3
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_3
    //   22: athrow
    // Line number table:
    //   Java source line #876	-> byte code offset #0
    //   Java source line #877	-> byte code offset #7
    //   Java source line #878	-> byte code offset #18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	23	0	this	SynchronizedAsMapEntries<K, V>
    //   0	23	1	array	T[]
    //   5	15	2	Ljava/lang/Object;	Object
    //   18	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	17	18	finally
    //   18	21	18	finally
  }
  
  /* Error */
  public boolean contains(Object o)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   11: aload_1
    //   12: invokestatic 76	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Maps:containsEntryImpl	(Ljava/util/Collection;Ljava/lang/Object;)Z
    //   15: aload_2
    //   16: monitorexit
    //   17: ireturn
    //   18: astore_3
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_3
    //   22: athrow
    // Line number table:
    //   Java source line #881	-> byte code offset #0
    //   Java source line #882	-> byte code offset #7
    //   Java source line #883	-> byte code offset #18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	23	0	this	SynchronizedAsMapEntries<K, V>
    //   0	23	1	o	Object
    //   5	15	2	Ljava/lang/Object;	Object
    //   18	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	17	18	finally
    //   18	21	18	finally
  }
  
  /* Error */
  public boolean containsAll(Collection<?> c)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   11: aload_1
    //   12: invokestatic 85	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Collections2:containsAllImpl	(Ljava/util/Collection;Ljava/util/Collection;)Z
    //   15: aload_2
    //   16: monitorexit
    //   17: ireturn
    //   18: astore_3
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_3
    //   22: athrow
    // Line number table:
    //   Java source line #886	-> byte code offset #0
    //   Java source line #887	-> byte code offset #7
    //   Java source line #888	-> byte code offset #18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	23	0	this	SynchronizedAsMapEntries<K, V>
    //   0	23	1	c	Collection<?>
    //   5	15	2	Ljava/lang/Object;	Object
    //   18	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	17	18	finally
    //   18	21	18	finally
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
    //   8: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   11: dup
    //   12: astore_2
    //   13: monitorenter
    //   14: aload_0
    //   15: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   18: aload_1
    //   19: invokestatic 97	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Sets:equalsImpl	(Ljava/util/Set;Ljava/lang/Object;)Z
    //   22: aload_2
    //   23: monitorexit
    //   24: ireturn
    //   25: astore_3
    //   26: aload_2
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    // Line number table:
    //   Java source line #891	-> byte code offset #0
    //   Java source line #892	-> byte code offset #5
    //   Java source line #894	-> byte code offset #7
    //   Java source line #895	-> byte code offset #14
    //   Java source line #896	-> byte code offset #25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	30	0	this	SynchronizedAsMapEntries<K, V>
    //   0	30	1	o	Object
    //   12	15	2	Ljava/lang/Object;	Object
    //   25	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   14	24	25	finally
    //   25	28	25	finally
  }
  
  /* Error */
  public boolean remove(Object o)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   11: aload_1
    //   12: invokestatic 101	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Maps:removeEntryImpl	(Ljava/util/Collection;Ljava/lang/Object;)Z
    //   15: aload_2
    //   16: monitorexit
    //   17: ireturn
    //   18: astore_3
    //   19: aload_2
    //   20: monitorexit
    //   21: aload_3
    //   22: athrow
    // Line number table:
    //   Java source line #899	-> byte code offset #0
    //   Java source line #900	-> byte code offset #7
    //   Java source line #901	-> byte code offset #18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	23	0	this	SynchronizedAsMapEntries<K, V>
    //   0	23	1	o	Object
    //   5	15	2	Ljava/lang/Object;	Object
    //   18	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	17	18	finally
    //   18	21	18	finally
  }
  
  /* Error */
  public boolean removeAll(Collection<?> c)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   11: invokeinterface 105 1 0
    //   16: aload_1
    //   17: invokestatic 110	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Iterators:removeAll	(Ljava/util/Iterator;Ljava/util/Collection;)Z
    //   20: aload_2
    //   21: monitorexit
    //   22: ireturn
    //   23: astore_3
    //   24: aload_2
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Line number table:
    //   Java source line #904	-> byte code offset #0
    //   Java source line #905	-> byte code offset #7
    //   Java source line #906	-> byte code offset #23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedAsMapEntries<K, V>
    //   0	28	1	c	Collection<?>
    //   5	20	2	Ljava/lang/Object;	Object
    //   23	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	22	23	finally
    //   23	26	23	finally
  }
  
  /* Error */
  public boolean retainAll(Collection<?> c)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedAsMapEntries:delegate	()Ljava/util/Set;
    //   11: invokeinterface 105 1 0
    //   16: aload_1
    //   17: invokestatic 113	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Iterators:retainAll	(Ljava/util/Iterator;Ljava/util/Collection;)Z
    //   20: aload_2
    //   21: monitorexit
    //   22: ireturn
    //   23: astore_3
    //   24: aload_2
    //   25: monitorexit
    //   26: aload_3
    //   27: athrow
    // Line number table:
    //   Java source line #909	-> byte code offset #0
    //   Java source line #910	-> byte code offset #7
    //   Java source line #911	-> byte code offset #23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedAsMapEntries<K, V>
    //   0	28	1	c	Collection<?>
    //   5	20	2	Ljava/lang/Object;	Object
    //   23	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	22	23	finally
    //   23	26	23	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedAsMapEntries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */