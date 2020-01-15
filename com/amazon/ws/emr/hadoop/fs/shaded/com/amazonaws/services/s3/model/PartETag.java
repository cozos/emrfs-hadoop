package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class PartETag
  implements Serializable
{
  private int partNumber;
  private String eTag;
  
  public PartETag(int partNumber, String eTag)
  {
    this.partNumber = partNumber;
    this.eTag = eTag;
  }
  
  public int getPartNumber()
  {
    return partNumber;
  }
  
  public void setPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public PartETag withPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
    return this;
  }
  
  public String getETag()
  {
    return eTag;
  }
  
  public void setETag(String eTag)
  {
    this.eTag = eTag;
  }
  
  public PartETag withETag(String eTag)
  {
    this.eTag = eTag;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */