package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

abstract class AbstractFileComparator
  implements Comparator<File>
{
  public File[] sort(File... files)
  {
    if (files != null) {
      Arrays.sort(files, this);
    }
    return files;
  }
  
  public List<File> sort(List<File> files)
  {
    if (files != null) {
      Collections.sort(files, this);
    }
    return files;
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator.AbstractFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */