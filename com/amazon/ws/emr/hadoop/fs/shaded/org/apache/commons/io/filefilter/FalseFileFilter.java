package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class FalseFileFilter
  implements IOFileFilter, Serializable
{
  public static final IOFileFilter FALSE = new FalseFileFilter();
  public static final IOFileFilter INSTANCE = FALSE;
  
  public boolean accept(File file)
  {
    return false;
  }
  
  public boolean accept(File dir, String name)
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.FalseFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */