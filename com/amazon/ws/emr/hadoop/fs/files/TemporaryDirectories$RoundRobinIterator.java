package com.amazon.ws.emr.hadoop.fs.files;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.LongMath;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class TemporaryDirectories$RoundRobinIterator
  implements Iterator<Path>
{
  private final AtomicLong cursorIndex;
  
  TemporaryDirectories$RoundRobinIterator(TemporaryDirectories paramTemporaryDirectories, int initialPosition)
  {
    cursorIndex = new AtomicLong(initialPosition);
  }
  
  public boolean hasNext()
  {
    return true;
  }
  
  public Path next()
  {
    return (Path)TemporaryDirectories.access$000(this$0).get(LongMath.mod(cursorIndex.getAndIncrement(), TemporaryDirectories.access$000(this$0).size()));
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.files.TemporaryDirectories.RoundRobinIterator
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */