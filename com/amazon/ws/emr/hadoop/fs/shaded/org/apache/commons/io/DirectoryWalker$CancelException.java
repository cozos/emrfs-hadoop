package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io;

import java.io.File;
import java.io.IOException;

public class DirectoryWalker$CancelException
  extends IOException
{
  private static final long serialVersionUID = 1347339620135041008L;
  private final File file;
  private final int depth;
  
  public DirectoryWalker$CancelException(File file, int depth)
  {
    this("Operation Cancelled", file, depth);
  }
  
  public DirectoryWalker$CancelException(String message, File file, int depth)
  {
    super(message);
    this.file = file;
    this.depth = depth;
  }
  
  public File getFile()
  {
    return file;
  }
  
  public int getDepth()
  {
    return depth;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.DirectoryWalker.CancelException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */