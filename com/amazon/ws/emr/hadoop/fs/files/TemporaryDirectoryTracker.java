package com.amazon.ws.emr.hadoop.fs.files;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets;
import java.io.Closeable;
import java.nio.file.Path;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class TemporaryDirectoryTracker
  implements Closeable
{
  private final AtomicReference<Set<Path>> trackedDirectories = new AtomicReference(
    Sets.newConcurrentHashSet());
  
  public boolean track(Path dir)
  {
    Set<Path> localTrackedDirectories = (Set)trackedDirectories.get();
    if (localTrackedDirectories == null) {
      return false;
    }
    localTrackedDirectories.add(dir);
    return true;
  }
  
  public boolean untrack(Path dir)
  {
    Set<Path> localTrackedDirectories = (Set)trackedDirectories.get();
    if (localTrackedDirectories == null) {
      return false;
    }
    localTrackedDirectories.remove(dir);
    return true;
  }
  
  public void close()
  {
    Set<Path> localTrackedDirectories = (Set)trackedDirectories.getAndSet(null);
    if (localTrackedDirectories == null) {
      return;
    }
    for (Path directory : localTrackedDirectories) {
      DeleteUtil.recursiveDeleteIfExistsOrLog(directory);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectoryTracker
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */