package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class FileFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  public static final IOFileFilter FILE = new FileFileFilter();
  
  public boolean accept(File file)
  {
    return file.isFile();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.FileFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */