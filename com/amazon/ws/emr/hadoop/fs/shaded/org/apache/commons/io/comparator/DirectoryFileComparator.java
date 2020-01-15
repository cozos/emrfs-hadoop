package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

public class DirectoryFileComparator
  extends AbstractFileComparator
  implements Serializable
{
  public static final Comparator<File> DIRECTORY_COMPARATOR = new DirectoryFileComparator();
  public static final Comparator<File> DIRECTORY_REVERSE = new ReverseComparator(DIRECTORY_COMPARATOR);
  
  public int compare(File file1, File file2)
  {
    return getType(file1) - getType(file2);
  }
  
  private int getType(File file)
  {
    if (file.isDirectory()) {
      return 1;
    }
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator.DirectoryFileComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */