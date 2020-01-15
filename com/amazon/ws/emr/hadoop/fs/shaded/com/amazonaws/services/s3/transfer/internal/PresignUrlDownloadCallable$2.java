package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import java.io.File;
import java.util.concurrent.Callable;

class PresignUrlDownloadCallable$2
  implements Callable<File>
{
  PresignUrlDownloadCallable$2(PresignUrlDownloadCallable this$0) {}
  
  /* Error */
  public File call()
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
    //   4: getfield 37	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:futures	Ljava/util/List;
    //   7: invokeinterface 43 1 0
    //   12: astore_1
    //   13: aload_1
    //   14: invokeinterface 49 1 0
    //   19: ifeq +23 -> 42
    //   22: aload_1
    //   23: invokeinterface 53 1 0
    //   28: checkcast 55	java/util/concurrent/Future
    //   31: astore_2
    //   32: aload_2
    //   33: invokeinterface 58 1 0
    //   38: pop
    //   39: goto -26 -> 13
    //   42: aload_0
    //   43: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
    //   46: invokestatic 62	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:access$100	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;)Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignedUrlDownloadImpl;
    //   49: getstatic 66	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/Transfer$TransferState:Completed	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/Transfer$TransferState;
    //   52: invokevirtual 72	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignedUrlDownloadImpl:setState	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/Transfer$TransferState;)V
    //   55: aload_0
    //   56: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
    //   59: getfield 76	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:dstfile	Ljava/io/File;
    //   62: invokestatic 82	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/internal/FileLocks:unlock	(Ljava/io/File;)Z
    //   65: pop
    //   66: goto +17 -> 83
    //   69: astore_3
    //   70: aload_0
    //   71: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
    //   74: getfield 76	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:dstfile	Ljava/io/File;
    //   77: invokestatic 82	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/internal/FileLocks:unlock	(Ljava/io/File;)Z
    //   80: pop
    //   81: aload_3
    //   82: athrow
    //   83: aload_0
    //   84: getfield 24	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable$2:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable;
    //   87: getfield 76	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/transfer/internal/PresignUrlDownloadCallable:dstfile	Ljava/io/File;
    //   90: areturn
    // Line number table:
    //   Java source line #265	-> byte code offset #0
    //   Java source line #266	-> byte code offset #32
    //   Java source line #267	-> byte code offset #39
    //   Java source line #269	-> byte code offset #42
    //   Java source line #271	-> byte code offset #55
    //   Java source line #272	-> byte code offset #66
    //   Java source line #271	-> byte code offset #69
    //   Java source line #272	-> byte code offset #81
    //   Java source line #274	-> byte code offset #83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	2
    //   12	11	1	localIterator	java.util.Iterator
    //   31	2	2	future	java.util.concurrent.Future<Long>
    //   69	13	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	55	69	finally
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PresignUrlDownloadCallable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */