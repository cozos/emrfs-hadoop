package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import java.io.File;
import java.io.Serializable;

public class TrueFileFilter
  implements IOFileFilter, Serializable
{
  public static final IOFileFilter TRUE = new TrueFileFilter();
  public static final IOFileFilter INSTANCE = TRUE;
  
  public boolean accept(File file)
  {
    return true;
  }
  
  public boolean accept(File dir, String name)
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.TrueFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */