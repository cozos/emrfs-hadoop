package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
@VisibleForTesting
class Synchronized$SynchronizedNavigableMap<K, V>
  extends Synchronized.SynchronizedSortedMap<K, V>
  implements NavigableMap<K, V>
{
  transient NavigableSet<K> descendingKeySet;
  transient NavigableMap<K, V> descendingMap;
  transient NavigableSet<K> navigableKeySet;
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedNavigableMap(NavigableMap<K, V> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  NavigableMap<K, V> delegate()
  {
    return (NavigableMap)super.delegate();
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> ceilingEntry(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 56 2 0
    //   17: aload_0
    //   18: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   21: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #1364	-> byte code offset #0
    //   Java source line #1365	-> byte code offset #7
    //   Java source line #1366	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedNavigableMap<K, V>
    //   0	32	1	key	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public K ceilingKey(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 70 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1370	-> byte code offset #0
    //   Java source line #1371	-> byte code offset #7
    //   Java source line #1372	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableMap<K, V>
    //   0	25	1	key	K
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  public NavigableSet<K> descendingKeySet()
  {
    synchronized (mutex)
    {
      if (descendingKeySet == null) {
        return descendingKeySet = Synchronized.navigableSet(delegate().descendingKeySet(), mutex);
      }
      return descendingKeySet;
    }
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    synchronized (mutex)
    {
      if (descendingMap == null) {
        return descendingMap = Synchronized.navigableMap(delegate().descendingMap(), mutex);
      }
      return descendingMap;
    }
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> firstEntry()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: invokeinterface 91 1 0
    //   16: aload_0
    //   17: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   20: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   23: aload_1
    //   24: monitorexit
    //   25: areturn
    //   26: astore_2
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Line number table:
    //   Java source line #1400	-> byte code offset #0
    //   Java source line #1401	-> byte code offset #7
    //   Java source line #1402	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SynchronizedNavigableMap<K, V>
    //   5	23	1	Ljava/lang/Object;	Object
    //   26	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	25	26	finally
    //   26	29	26	finally
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> floorEntry(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 94 2 0
    //   17: aload_0
    //   18: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   21: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #1406	-> byte code offset #0
    //   Java source line #1407	-> byte code offset #7
    //   Java source line #1408	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedNavigableMap<K, V>
    //   0	32	1	key	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public K floorKey(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 97 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1412	-> byte code offset #0
    //   Java source line #1413	-> byte code offset #7
    //   Java source line #1414	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableMap<K, V>
    //   0	25	1	key	K
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: iload_2
    //   13: invokeinterface 101 3 0
    //   18: aload_0
    //   19: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   22: invokestatic 87	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:navigableMap	(Ljava/util/NavigableMap;Ljava/lang/Object;)Ljava/util/NavigableMap;
    //   25: aload_3
    //   26: monitorexit
    //   27: areturn
    //   28: astore 4
    //   30: aload_3
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Line number table:
    //   Java source line #1418	-> byte code offset #0
    //   Java source line #1419	-> byte code offset #7
    //   Java source line #1421	-> byte code offset #28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SynchronizedNavigableMap<K, V>
    //   0	35	1	toKey	K
    //   0	35	2	inclusive	boolean
    //   5	26	3	Ljava/lang/Object;	Object
    //   28	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	28	finally
    //   28	32	28	finally
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> higherEntry(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 107 2 0
    //   17: aload_0
    //   18: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   21: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #1425	-> byte code offset #0
    //   Java source line #1426	-> byte code offset #7
    //   Java source line #1427	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedNavigableMap<K, V>
    //   0	32	1	key	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public K higherKey(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 110 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1431	-> byte code offset #0
    //   Java source line #1432	-> byte code offset #7
    //   Java source line #1433	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableMap<K, V>
    //   0	25	1	key	K
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> lastEntry()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: invokeinterface 113 1 0
    //   16: aload_0
    //   17: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   20: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   23: aload_1
    //   24: monitorexit
    //   25: areturn
    //   26: astore_2
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Line number table:
    //   Java source line #1437	-> byte code offset #0
    //   Java source line #1438	-> byte code offset #7
    //   Java source line #1439	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SynchronizedNavigableMap<K, V>
    //   5	23	1	Ljava/lang/Object;	Object
    //   26	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	25	26	finally
    //   26	29	26	finally
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> lowerEntry(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 116 2 0
    //   17: aload_0
    //   18: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   21: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   24: aload_2
    //   25: monitorexit
    //   26: areturn
    //   27: astore_3
    //   28: aload_2
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Line number table:
    //   Java source line #1443	-> byte code offset #0
    //   Java source line #1444	-> byte code offset #7
    //   Java source line #1445	-> byte code offset #27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	SynchronizedNavigableMap<K, V>
    //   0	32	1	key	K
    //   5	24	2	Ljava/lang/Object;	Object
    //   27	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	27	finally
    //   27	30	27	finally
  }
  
  /* Error */
  public K lowerKey(K key)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_2
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: invokeinterface 119 2 0
    //   17: aload_2
    //   18: monitorexit
    //   19: areturn
    //   20: astore_3
    //   21: aload_2
    //   22: monitorexit
    //   23: aload_3
    //   24: athrow
    // Line number table:
    //   Java source line #1449	-> byte code offset #0
    //   Java source line #1450	-> byte code offset #7
    //   Java source line #1451	-> byte code offset #20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	SynchronizedNavigableMap<K, V>
    //   0	25	1	key	K
    //   5	17	2	Ljava/lang/Object;	Object
    //   20	4	3	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	19	20	finally
    //   20	23	20	finally
  }
  
  public Set<K> keySet()
  {
    return navigableKeySet();
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    synchronized (mutex)
    {
      if (navigableKeySet == null) {
        return navigableKeySet = Synchronized.navigableSet(delegate().navigableKeySet(), mutex);
      }
      return navigableKeySet;
    }
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> pollFirstEntry()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: invokeinterface 129 1 0
    //   16: aload_0
    //   17: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   20: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   23: aload_1
    //   24: monitorexit
    //   25: areturn
    //   26: astore_2
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Line number table:
    //   Java source line #1471	-> byte code offset #0
    //   Java source line #1472	-> byte code offset #7
    //   Java source line #1473	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SynchronizedNavigableMap<K, V>
    //   5	23	1	Ljava/lang/Object;	Object
    //   26	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	25	26	finally
    //   26	29	26	finally
  }
  
  /* Error */
  public java.util.Map.Entry<K, V> pollLastEntry()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: invokeinterface 132 1 0
    //   16: aload_0
    //   17: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   20: invokestatic 60	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:access$700	(Ljava/util/Map$Entry;Ljava/lang/Object;)Ljava/util/Map$Entry;
    //   23: aload_1
    //   24: monitorexit
    //   25: areturn
    //   26: astore_2
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Line number table:
    //   Java source line #1477	-> byte code offset #0
    //   Java source line #1478	-> byte code offset #7
    //   Java source line #1479	-> byte code offset #26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	SynchronizedNavigableMap<K, V>
    //   5	23	1	Ljava/lang/Object;	Object
    //   26	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	25	26	finally
    //   26	29	26	finally
  }
  
  /* Error */
  public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore 5
    //   7: monitorenter
    //   8: aload_0
    //   9: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   12: aload_1
    //   13: iload_2
    //   14: aload_3
    //   15: iload 4
    //   17: invokeinterface 136 5 0
    //   22: aload_0
    //   23: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   26: invokestatic 87	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:navigableMap	(Ljava/util/NavigableMap;Ljava/lang/Object;)Ljava/util/NavigableMap;
    //   29: aload 5
    //   31: monitorexit
    //   32: areturn
    //   33: astore 6
    //   35: aload 5
    //   37: monitorexit
    //   38: aload 6
    //   40: athrow
    // Line number table:
    //   Java source line #1484	-> byte code offset #0
    //   Java source line #1485	-> byte code offset #8
    //   Java source line #1488	-> byte code offset #33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	SynchronizedNavigableMap<K, V>
    //   0	41	1	fromKey	K
    //   0	41	2	fromInclusive	boolean
    //   0	41	3	toKey	K
    //   0	41	4	toInclusive	boolean
    //   5	31	5	Ljava/lang/Object;	Object
    //   33	6	6	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   8	32	33	finally
    //   33	38	33	finally
  }
  
  /* Error */
  public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_3
    //   6: monitorenter
    //   7: aload_0
    //   8: invokevirtual 54	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:delegate	()Ljava/util/NavigableMap;
    //   11: aload_1
    //   12: iload_2
    //   13: invokeinterface 142 3 0
    //   18: aload_0
    //   19: getfield 52	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedNavigableMap:mutex	Ljava/lang/Object;
    //   22: invokestatic 87	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized:navigableMap	(Ljava/util/NavigableMap;Ljava/lang/Object;)Ljava/util/NavigableMap;
    //   25: aload_3
    //   26: monitorexit
    //   27: areturn
    //   28: astore 4
    //   30: aload_3
    //   31: monitorexit
    //   32: aload 4
    //   34: athrow
    // Line number table:
    //   Java source line #1492	-> byte code offset #0
    //   Java source line #1493	-> byte code offset #7
    //   Java source line #1495	-> byte code offset #28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	SynchronizedNavigableMap<K, V>
    //   0	35	1	fromKey	K
    //   0	35	2	inclusive	boolean
    //   5	26	3	Ljava/lang/Object;	Object
    //   28	5	4	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	28	finally
    //   28	32	28	finally
  }
  
  public SortedMap<K, V> headMap(K toKey)
  {
    return headMap(toKey, false);
  }
  
  public SortedMap<K, V> subMap(K fromKey, K toKey)
  {
    return subMap(fromKey, true, toKey, false);
  }
  
  public SortedMap<K, V> tailMap(K fromKey)
  {
    return tailMap(fromKey, true);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedNavigableMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */