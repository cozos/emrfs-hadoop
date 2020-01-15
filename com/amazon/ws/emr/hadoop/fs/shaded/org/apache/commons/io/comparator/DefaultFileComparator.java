package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class DefaultFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> DEFAULT_COMPARATOR = new DefaultFileComparator();
  public static final Comparator<File> DEFAULT_REVERSE = new ReverseComparator(DEFAULT_COMPARATOR);
  
  public int compare(File file1, File file2)
  {
    return file1.compareTo(file2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator.DefaultFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */