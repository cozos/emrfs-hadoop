package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.OnFileDelete;
import java.io.File;

public class PartCreationEvent
{
  private final File part;
  private final int partNumber;
  private final boolean isLastPart;
  private final OnFileDelete fileDeleteObserver;
  
  PartCreationEvent(File part, int partNumber, boolean isLastPart, OnFileDelete fileDeleteObserver)
  {
    if (part == null) {
      throw new IllegalArgumentException("part must not be specified");
    }
    this.part = part;
    this.partNumber = partNumber;
    this.isLastPart = isLastPart;
    this.fileDeleteObserver = fileDeleteObserver;
  }
  
  public File getPart()
  {
    return part;
  }
  
  public int getPartNumber()
  {
    return partNumber;
  }
  
  public boolean isLastPart()
  {
    return isLastPart;
  }
  
  public OnFileDelete getFileDeleteObserver()
  {
    return fileDeleteObserver;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.PartCreationEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */