package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io;

import java.io.File;
import java.io.IOException;

class FileDeleteStrategy$ForceFileDeleteStrategy
  extends FileDeleteStrategy
{
  FileDeleteStrategy$ForceFileDeleteStrategy()
  {
    super("Force");
  }
  
  protected boolean doDelete(File fileToDelete)
    throws IOException
  {
    FileUtils.forceDelete(fileToDelete);
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.FileDeleteStrategy.ForceFileDeleteStrategy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */