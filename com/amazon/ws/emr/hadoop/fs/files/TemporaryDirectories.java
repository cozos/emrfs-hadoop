package com.amazon.ws.emr.hadoop.fs.files;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.LongMath;
import java.io.Closeable;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ThreadSafe
public final class TemporaryDirectories
  implements Closeable
{
  private static final Logger LOG = LoggerFactory.getLogger(TemporaryDirectories.class);
  private final List<Path> tempDirectoryPaths;
  private final AtomicBoolean closed = new AtomicBoolean(false);
  private final int initialPosition;
  
  TemporaryDirectories(List<Path> tempDirectoryPaths)
  {
    this(tempDirectoryPaths, 0);
  }
  
  TemporaryDirectories(List<Path> tempDirectoryPaths, int initialPosition)
  {
    Preconditions.checkArgument((0 <= initialPosition) && (initialPosition < tempDirectoryPaths.size()), "initialPosition must be a valid index");
    
    this.tempDirectoryPaths = ImmutableList.copyOf(tempDirectoryPaths);
    this.initialPosition = initialPosition;
  }
  
  @ThreadSafe
  private final class RoundRobinIterator
    implements Iterator<Path>
  {
    private final AtomicLong cursorIndex;
    
    RoundRobinIterator(int initialPosition)
    {
      cursorIndex = new AtomicLong(initialPosition);
    }
    
    public boolean hasNext()
    {
      return true;
    }
    
    public Path next()
    {
      return (Path)tempDirectoryPaths.get(LongMath.mod(cursorIndex.getAndIncrement(), tempDirectoryPaths.size()));
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public int size()
  {
    return tempDirectoryPaths.size();
  }
  
  public Iterator<Path> cyclingIterator()
  {
    return new RoundRobinIterator(initialPosition);
  }
  
  public void close()
  {
    if (!closed.compareAndSet(false, true)) {
      return;
    }
    moveTrackAndDeleteTempDirectories();
  }
  
  private void moveTrackAndDeleteTempDirectories()
  {
    List<Path> pathsToDelete = new ArrayList(tempDirectoryPaths.size());
    for (Path tempDirectory : tempDirectoryPaths)
    {
      Path tempDirectoryToDelete = tempDirectory.resolveSibling(tempDirectory.getFileName() + ".todelete");
      try
      {
        TemporaryDirectoryShutdownHook.track(tempDirectoryToDelete);
        Files.move(tempDirectory, tempDirectoryToDelete, new CopyOption[] { StandardCopyOption.ATOMIC_MOVE });
        TemporaryDirectoryShutdownHook.untrack(tempDirectory);
        pathsToDelete.add(tempDirectoryToDelete);
      }
      catch (Exception e)
      {
        if (LOG.isDebugEnabled()) {
          LOG.debug(String.format("Could not move temporary directory: %s to %s for deletion. Falling back to non-atomic recursive delete for %s", new Object[] { tempDirectory, tempDirectoryToDelete, tempDirectory }), e);
        }
        TemporaryDirectoryShutdownHook.untrack(tempDirectoryToDelete);
        
        pathsToDelete.add(tempDirectory);
      }
    }
    deletePathsRecursively(pathsToDelete);
  }
  
  private static void deletePathsRecursively(List<Path> pathsToDelete)
  {
    for (Path toDeleteDir : pathsToDelete) {
      if (DeleteUtil.recursiveDeleteIfExistsOrLog(toDeleteDir)) {
        TemporaryDirectoryShutdownHook.untrack(toDeleteDir);
      } else if (LOG.isDebugEnabled()) {
        LOG.debug("Failed to recursively delete " + toDeleteDir + ".  Will attempt to delete this directory on exit.");
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectories
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */