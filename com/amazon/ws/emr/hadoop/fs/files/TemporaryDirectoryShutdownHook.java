package com.amazon.ws.emr.hadoop.fs.files;

import java.nio.file.Path;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class TemporaryDirectoryShutdownHook
{
  private static final TemporaryDirectoryTracker directoryTracker = new TemporaryDirectoryTracker();
  
  static
  {
    Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
    {
      public void run() {}
    }));
  }
  
  static boolean track(Path dir)
  {
    return directoryTracker.track(dir);
  }
  
  static boolean untrack(Path dir)
  {
    return directoryTracker.untrack(dir);
  }
  
  private static void runHook()
  {
    directoryTracker.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectoryShutdownHook
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */