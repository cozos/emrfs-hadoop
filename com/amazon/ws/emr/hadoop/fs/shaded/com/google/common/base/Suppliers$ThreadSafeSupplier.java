package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base;

import java.io.Serializable;

class Suppliers$ThreadSafeSupplier<T>
  implements Supplier<T>, Serializable
{
  final Supplier<T> delegate;
  private static final long serialVersionUID = 0L;
  
  Suppliers$ThreadSafeSupplier(Supplier<T> delegate)
  {
    this.delegate = delegate;
  }
  
  /* Error */
  public T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Suppliers$ThreadSafeSupplier:delegate	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Supplier;
    //   4: dup
    //   5: astore_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 27	com/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Suppliers$ThreadSafeSupplier:delegate	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/google/common/base/Supplier;
    //   11: invokeinterface 34 1 0
    //   16: aload_1
    //   17: monitorexit
    //   18: areturn
    //   19: astore_2
    //   20: aload_1
    //   21: monitorexit
    //   22: aload_2
    //   23: athrow
    // Line number table:
    //   Java source line #270	-> byte code offset #0
    //   Java source line #271	-> byte code offset #7
    //   Java source line #272	-> byte code offset #19
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	24	0	this	ThreadSafeSupplier<T>
    //   5	16	1	Ljava/lang/Object;	Object
    //   19	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   7	18	19	finally
    //   19	22	19	finally
  }
  
  public String toString()
  {
    String str = String.valueOf(String.valueOf(delegate));return 32 + str.length() + "Suppliers.synchronizedSupplier(" + str + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Suppliers.ThreadSafeSupplier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */