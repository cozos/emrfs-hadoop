package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.SSEResultBase;
import java.io.Serializable;
import java.util.Date;

public class CopyPartResult
  extends SSEResultBase
  implements Serializable
{
  private String etag;
  private Date lastModifiedDate;
  private String versionId;
  private int partNumber;
  
  public int getPartNumber()
  {
    return partNumber;
  }
  
  public void setPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public String getETag()
  {
    return etag;
  }
  
  public void setETag(String etag)
  {
    this.etag = etag;
  }
  
  public PartETag getPartETag()
  {
    return new PartETag(partNumber, etag);
  }
  
  public Date getLastModifiedDate()
  {
    return lastModifiedDate;
  }
  
  public void setLastModifiedDate(Date lastModifiedDate)
  {
    this.lastModifiedDate = lastModifiedDate;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */