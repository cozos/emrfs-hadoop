package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class DirectoryFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter DIRECTORY = new DirectoryFileFilter();
  public static final IOFileFilter INSTANCE = DIRECTORY;
  
  public boolean accept(File file)
  {
    return file.isDirectory();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.DirectoryFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */