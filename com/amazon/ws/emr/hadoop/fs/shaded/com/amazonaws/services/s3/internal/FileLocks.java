package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.FileLockException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Map;
import java.util.TreeMap;

@ThreadSafe
public enum FileLocks
{
  private static final boolean EXTERNAL_LOCK = false;
  private static final Log log = LogFactory.getLog(FileLocks.class);
  private static final Map<File, RandomAccessFile> lockedFiles = new TreeMap();
  
  private FileLocks() {}
  
  public static boolean lock(File file)
  {
    synchronized (lockedFiles)
    {
      if (lockedFiles.containsKey(file)) {
        return false;
      }
    }
    FileLock lock = null;
    RandomAccessFile raf = null;
    try
    {
      raf = new RandomAccessFile(file, "rw");
      FileChannel localFileChannel = raf.getChannel();
    }
    catch (Exception e)
    {
      IOUtils.closeQuietly(raf, log);
      throw new FileLockException(e);
    }
    synchronized (lockedFiles)
    {
      RandomAccessFile prev = (RandomAccessFile)lockedFiles.put(file, raf);
      boolean locked;
      if (prev == null)
      {
        locked = true;
      }
      else
      {
        boolean locked = false;
        lockedFiles.put(file, prev);
      }
    }
    boolean locked;
    if (locked)
    {
      if (log.isDebugEnabled()) {
        log.debug("Locked file " + file + " with " + lock);
      }
    }
    else {
      IOUtils.closeQuietly(raf, log);
    }
    return locked;
  }
  
  /* Error */
  public static boolean isFileLocked(File file)
  {
    // Byte code:
    //   0: getstatic 45	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/internal/FileLocks:lockedFiles	Ljava/util/Map;
    //   3: dup
    //   4: astore_1
    //   5: monitorenter
    //   6: getstatic 45	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/services/s3/internal/FileLocks:lockedFiles	Ljava/util/Map;
    //   9: aload_0
    //   10: invokeinterface 51 2 0
    //   15: aload_1
    //   16: monitorexit
    //   17: ireturn
    //   18: astore_2
    //   19: aload_1
    //   20: monitorexit
    //   21: aload_2
    //   22: athrow
    // Line number table:
    //   Java source line #102	-> byte code offset #0
    //   Java source line #103	-> byte code offset #6
    //   Java source line #104	-> byte code offset #18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	23	0	file	File
    //   4	16	1	Ljava/lang/Object;	Object
    //   18	4	2	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   6	17	18	finally
    //   18	21	18	finally
  }
  
  public static boolean unlock(File file)
  {
    synchronized (lockedFiles)
    {
      RandomAccessFile raf = (RandomAccessFile)lockedFiles.get(file);
      if (raf == null) {
        return false;
      }
      IOUtils.closeQuietly(raf, log);
      lockedFiles.remove(file);
    }
    if (log.isDebugEnabled()) {
      log.debug("Unlocked file " + file);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.FileLocks
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */