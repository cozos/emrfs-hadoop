package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.annotation.Nullable;

class Synchronized$SynchronizedObject
  implements Serializable
{
  final Object delegate;
  final Object mutex;
  @GwtIncompatible("not needed in emulated source")
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedObject(Object delegate, @Nullable Object mutex)
  {
    this.delegate = Preconditions.checkNotNull(delegate);
    this.mutex = (mutex == null ? this : mutex);
  }
  
  Object delegate()
  {
    return delegate;
  }
  
  /* Error */
  public String toString()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 36	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedObject:mutex	Ljava/lang/Object;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 34	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/collect/Synchronized$SynchronizedObject:delegate	Ljava/lang/Object;
    //   11: invokevirtual 43	java/lang/Object:toString	()Ljava/lang/String;
    //   14: aload_1
    //   15: monitorexit
    //   16: areturn
    //   17: astore_2
    //   18: aload_1
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    // Line number table:
    //   Java source line #79	-> byte code offset #0
    //   Java source line #80	-> byte code offset #7
    //   Java source line #81	-> byte code offset #17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	SynchronizedObject
    //   5	14	1	Ljava/lang/Object;	Object
    //   17	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	17	finally
    //   17	20	17	finally
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream stream)
    throws IOException
  {
    synchronized (mutex)
    {
      stream.defaultWriteObject();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */