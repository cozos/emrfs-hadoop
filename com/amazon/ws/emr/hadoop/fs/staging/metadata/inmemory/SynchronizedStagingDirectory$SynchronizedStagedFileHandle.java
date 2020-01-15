package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;

final class SynchronizedStagingDirectory$SynchronizedStagedFileHandle
  implements StagedFileHandle
{
  private final StagedFileHandle handle;
  
  /* Error */
  public void complete(com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata uploadMetadata)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory$SynchronizedStagedFileHandle:this$0	Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory;
    //   4: invokestatic 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:access$000	(Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   7: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   10: invokevirtual 37	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   13: aload_0
    //   14: getfield 39	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory$SynchronizedStagedFileHandle:handle	Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/StagedFileHandle;
    //   17: aload_1
    //   18: invokeinterface 41 2 0
    //   23: aload_0
    //   24: getfield 25	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory$SynchronizedStagedFileHandle:this$0	Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory;
    //   27: invokestatic 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:access$000	(Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   30: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   33: invokevirtual 44	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   36: goto +19 -> 55
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 25	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory$SynchronizedStagedFileHandle:this$0	Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory;
    //   44: invokestatic 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:access$000	(Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory;)Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   47: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   50: invokevirtual 44	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   53: aload_2
    //   54: athrow
    //   55: return
    // Line number table:
    //   Java source line #73	-> byte code offset #0
    //   Java source line #75	-> byte code offset #13
    //   Java source line #77	-> byte code offset #23
    //   Java source line #78	-> byte code offset #36
    //   Java source line #77	-> byte code offset #39
    //   Java source line #78	-> byte code offset #53
    //   Java source line #79	-> byte code offset #55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	SynchronizedStagedFileHandle
    //   0	56	1	uploadMetadata	com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata
    //   39	15	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	23	39	finally
  }
  
  public SynchronizedStagingDirectory$SynchronizedStagedFileHandle(SynchronizedStagingDirectory paramSynchronizedStagingDirectory, StagedFileHandle handle)
  {
    this.handle = handle;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.SynchronizedStagingDirectory.SynchronizedStagedFileHandle
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */