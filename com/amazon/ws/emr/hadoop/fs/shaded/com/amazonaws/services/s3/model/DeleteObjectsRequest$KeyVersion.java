package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class DeleteObjectsRequest$KeyVersion
  implements Serializable
{
  private final String key;
  private final String version;
  
  public DeleteObjectsRequest$KeyVersion(String key)
  {
    this(key, null);
  }
  
  public DeleteObjectsRequest$KeyVersion(String key, String version)
  {
    this.key = key;
    this.version = version;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public String getVersion()
  {
    return version;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.DeleteObjectsRequest.KeyVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */