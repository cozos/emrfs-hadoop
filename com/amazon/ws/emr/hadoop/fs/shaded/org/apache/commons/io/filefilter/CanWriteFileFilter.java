package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class CanWriteFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter CAN_WRITE = new CanWriteFileFilter();
  public static final IOFileFilter CANNOT_WRITE = new NotFileFilter(CAN_WRITE);
  
  public boolean accept(File file)
  {
    return file.canWrite();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.CanWriteFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */