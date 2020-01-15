package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class MultiObjectDeleteException$DeleteError
  implements Serializable
{
  private String key;
  private String versionId;
  private String code;
  private String message;
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public String getCode()
  {
    return code;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getMessage()
  {
    return message;
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultiObjectDeleteException.DeleteError
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */