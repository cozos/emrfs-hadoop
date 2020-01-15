package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

final class FileCleaningTracker$Tracker
  extends PhantomReference<Object>
{
  private final String path;
  private final FileDeleteStrategy deleteStrategy;
  
  FileCleaningTracker$Tracker(String path, FileDeleteStrategy deleteStrategy, Object marker, ReferenceQueue<? super Object> queue)
  {
    super(marker, queue);
    this.path = path;
    this.deleteStrategy = (deleteStrategy == null ? FileDeleteStrategy.NORMAL : deleteStrategy);
  }
  
  public String getPath()
  {
    return path;
  }
  
  public boolean delete()
  {
    return deleteStrategy.deleteQuietly(new File(path));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.FileCleaningTracker.Tracker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */