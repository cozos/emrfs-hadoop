package com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory;

import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagedFileHandle;
import com.amazon.ws.emr.hadoop.fs.staging.metadata.StagingStatus;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import lombok.NonNull;

public final class SynchronizedStagingDirectory
  implements StagingDirectory
{
  public SynchronizedStagingDirectory(@NonNull StagingDirectory directory)
  {
    if (directory == null) {
      throw new NullPointerException("directory");
    }
    this.directory = directory;
  }
  
  private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
  @NonNull
  private final StagingDirectory directory;
  
  public StagedFileHandle createFile(List<String> pathComponents, boolean overwrite)
    throws IOException
  {
    lock.writeLock().lock();
    try
    {
      return new SynchronizedStagedFileHandle(directory.createFile(pathComponents, overwrite));
    }
    finally
    {
      lock.writeLock().unlock();
    }
  }
  
  public StagingStatus getStatus(List<String> pathComponents)
    throws IOException
  {
    lock.readLock().lock();
    try
    {
      return directory.getStatus(pathComponents);
    }
    finally
    {
      lock.readLock().unlock();
    }
  }
  
  /* Error */
  public void publish()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 36	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: aload_0
    //   11: getfield 38	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:directory	Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/StagingDirectory;
    //   14: invokeinterface 69 1 0
    //   19: aload_0
    //   20: getfield 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   23: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   26: invokevirtual 47	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   29: goto +16 -> 45
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   37: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   40: invokevirtual 47	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   43: aload_1
    //   44: athrow
    //   45: return
    // Line number table:
    //   Java source line #48	-> byte code offset #0
    //   Java source line #50	-> byte code offset #10
    //   Java source line #52	-> byte code offset #19
    //   Java source line #53	-> byte code offset #29
    //   Java source line #52	-> byte code offset #32
    //   Java source line #53	-> byte code offset #43
    //   Java source line #54	-> byte code offset #45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	SynchronizedStagingDirectory
    //   32	12	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	32	finally
  }
  
  /* Error */
  public void delete()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   4: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   7: invokevirtual 36	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   10: aload_0
    //   11: getfield 38	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:directory	Lcom/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/StagingDirectory;
    //   14: invokeinterface 72 1 0
    //   19: aload_0
    //   20: getfield 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   23: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   26: invokevirtual 47	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   29: goto +16 -> 45
    //   32: astore_1
    //   33: aload_0
    //   34: getfield 29	com/amazon/ws/emr/hadoop/fs/staging/metadata/inmemory/SynchronizedStagingDirectory:lock	Ljava/util/concurrent/locks/ReentrantReadWriteLock;
    //   37: invokevirtual 33	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   40: invokevirtual 47	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   43: aload_1
    //   44: athrow
    //   45: return
    // Line number table:
    //   Java source line #58	-> byte code offset #0
    //   Java source line #60	-> byte code offset #10
    //   Java source line #62	-> byte code offset #19
    //   Java source line #63	-> byte code offset #29
    //   Java source line #62	-> byte code offset #32
    //   Java source line #63	-> byte code offset #43
    //   Java source line #64	-> byte code offset #45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	SynchronizedStagingDirectory
    //   32	12	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   10	19	32	finally
  }
  
  private final class SynchronizedStagedFileHandle
    implements StagedFileHandle
  {
    private final StagedFileHandle handle;
    
    /* Error */
    public void complete(com.amazon.ws.emr.hadoop.fs.staging.metadata.UploadMetadata uploadMetadata)
      throws IOException
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
    
    public SynchronizedStagedFileHandle(StagedFileHandle handle)
    {
      this.handle = handle;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.staging.metadata.inmemory.SynchronizedStagingDirectory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */