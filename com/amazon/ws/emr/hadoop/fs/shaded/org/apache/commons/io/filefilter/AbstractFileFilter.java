package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import java.io.File;

public abstract class AbstractFileFilter
  implements IOFileFilter
{
  public boolean accept(File file)
  {
    return accept(file.getParentFile(), file.getName());
  }
  
  public boolean accept(File dir, String name)
  {
    return accept(new File(dir, name));
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.AbstractFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */