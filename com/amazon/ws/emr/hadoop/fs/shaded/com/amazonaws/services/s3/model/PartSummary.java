package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class PartSummary
  implements Serializable
{
  private int partNumber;
  private Date lastModified;
  private String eTag;
  private long size;
  
  public int getPartNumber()
  {
    return partNumber;
  }
  
  public void setPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public Date getLastModified()
  {
    return lastModified;
  }
  
  public void setLastModified(Date lastModified)
  {
    this.lastModified = lastModified;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  public void setETag(String eTag)
  {
    this.eTag = eTag;
  }
  
  public long getSize()
  {
    return size;
  }
  
  public void setSize(long size)
  {
    this.size = size;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartSummary
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */