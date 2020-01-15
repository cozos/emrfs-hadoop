package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

class RefreshableTask$1
  implements Runnable
{
  RefreshableTask$1(RefreshableTask this$0) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask$1:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;
    //   4: invokestatic 26	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask:access$100	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;)V
    //   7: aload_0
    //   8: getfield 18	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask$1:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;
    //   11: invokestatic 30	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask:access$200	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   14: iconst_0
    //   15: invokevirtual 36	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   18: goto +17 -> 35
    //   21: astore_1
    //   22: aload_0
    //   23: getfield 18	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask$1:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;
    //   26: invokestatic 30	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask:access$200	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;)Ljava/util/concurrent/atomic/AtomicBoolean;
    //   29: iconst_0
    //   30: invokevirtual 36	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   33: aload_1
    //   34: athrow
    //   35: return
    // Line number table:
    //   Java source line #238	-> byte code offset #0
    //   Java source line #240	-> byte code offset #7
    //   Java source line #241	-> byte code offset #18
    //   Java source line #240	-> byte code offset #21
    //   Java source line #241	-> byte code offset #33
    //   Java source line #242	-> byte code offset #35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	1
    //   21	13	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	7	21	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.RefreshableTask.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */