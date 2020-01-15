package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.Set;
import javax.annotation.Nullable;

@VisibleForTesting
class Synchronized$SynchronizedBiMap<K, V>
  extends Synchronized.SynchronizedMap<K, V>
  implements BiMap<K, V>, Serializable
{
  private transient Set<V> valueSet;
  private transient BiMap<V, K> inverse;
  private static final long serialVersionUID = 0L;
  
  private Synchronized$SynchronizedBiMap(BiMap<K, V> delegate, @Nullable Object mutex, @Nullable BiMap<V, K> inverse)
  {
    super(delegate, mutex);
    this.inverse = inverse;
  }
  
  BiMap<K, V> delegate()
  {
    return (BiMap)super.delegate();
  }
  
  public Set<V> values()
  {
    synchronized (mutex)
    {
      if (valueSet == null) {
        valueSet = Synchronized.set(delegate().values(), mutex);
      }
      return valueSet;
    }
  }
  
  /* Error */
  public V forcePut(K key, V value)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedBiMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedBiMap:delegate	()Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/BiMap;
    //   11: aload_1
    //   12: aload_2
    //   13: invokeinterface 68 3 0
    //   18: aload_3
    //   19: monitorexit
    //   20: areturn
    //   21: astore 4
    //   23: aload_3
    //   24: monitorexit
    //   25: aload 4
    //   27: athrow
    // Line number table:
    //   Java source line #1137	-> byte code offset #0
    //   Java source line #1138	-> byte code offset #7
    //   Java source line #1139	-> byte code offset #21
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	28	0	this	SynchronizedBiMap<K, V>
    //   0	28	1	key	K
    //   0	28	2	value	V
    //   5	19	3	Ljava/lang/Object;	Object
    //   21	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	20	21	finally
    //   21	25	21	finally
  }
  
  public BiMap<V, K> inverse()
  {
    synchronized (mutex)
    {
      if (inverse == null) {
        inverse = new SynchronizedBiMap(delegate().inverse(), mutex, this);
      }
      return inverse;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */