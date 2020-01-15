package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

public class AgeFileFilter
  extends AbstractFileFilter
  implements Serializable
{
  private final long cutoff;
  private final boolean acceptOlder;
  
  public AgeFileFilter(long cutoff)
  {
    this(cutoff, true);
  }
  
  public AgeFileFilter(long cutoff, boolean acceptOlder)
  {
    this.acceptOlder = acceptOlder;
    this.cutoff = cutoff;
  }
  
  public AgeFileFilter(Date cutoffDate)
  {
    this(cutoffDate, true);
  }
  
  public AgeFileFilter(Date cutoffDate, boolean acceptOlder)
  {
    this(cutoffDate.getTime(), acceptOlder);
  }
  
  public AgeFileFilter(File cutoffReference)
  {
    this(cutoffReference, true);
  }
  
  public AgeFileFilter(File cutoffReference, boolean acceptOlder)
  {
    this(cutoffReference.lastModified(), acceptOlder);
  }
  
  public boolean accept(File file)
  {
    boolean newer = FileUtils.isFileNewer(file, cutoff);
    return acceptOlder ? false : !newer ? true : newer;
  }
  
  public String toString()
  {
    String condition = acceptOlder ? "<=" : ">";
    return super.toString() + "(" + condition + cutoff + ")";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.io.filefilter.AgeFileFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */