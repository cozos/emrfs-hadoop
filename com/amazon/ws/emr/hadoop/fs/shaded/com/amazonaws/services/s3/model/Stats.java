package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class Stats
  implements Serializable
{
  private Long bytesScanned;
  private Long bytesProcessed;
  private Long bytesReturned;
  
  public Long getBytesScanned()
  {
    return bytesScanned;
  }
  
  public void setBytesScanned(Long bytesScanned)
  {
    this.bytesScanned = bytesScanned;
  }
  
  public Stats withBytesScanned(Long readBytes)
  {
    setBytesScanned(readBytes);
    return this;
  }
  
  public Long getBytesReturned()
  {
    return bytesReturned;
  }
  
  public void setBytesReturned(Long bytesReturned)
  {
    this.bytesReturned = bytesReturned;
  }
  
  public Stats withBytesReturned(Long bytesReturned)
  {
    setBytesReturned(bytesReturned);
    return this;
  }
  
  public Long getBytesProcessed()
  {
    return bytesProcessed;
  }
  
  public void setBytesProcessed(Long bytesProcessed)
  {
    this.bytesProcessed = bytesProcessed;
  }
  
  public Stats withBytesProcessed(Long processedBytes)
  {
    setBytesProcessed(processedBytes);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Stats
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */