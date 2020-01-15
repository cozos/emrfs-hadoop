package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator;

import java.io.File;
import java.io.Serializable;
import java.util.Comparator;

class ReverseComparator
  extends AbstractFileComparator
  implements Serializable
{
  private final Comparator<File> delegate;
  
  public ReverseComparator(Comparator<File> delegate)
  {
    if (delegate == null) {
      throw new IllegalArgumentException("Delegate comparator is missing");
    }
    this.delegate = delegate;
  }
  
  public int compare(File file1, File file2)
  {
    return delegate.compare(file2, file1);
  }
  
  public String toString()
  {
    return super.toString() + "[" + delegate.toString() + "]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.comparator.ReverseComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */