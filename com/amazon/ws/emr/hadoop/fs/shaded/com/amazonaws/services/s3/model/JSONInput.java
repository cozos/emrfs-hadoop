package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class JSONInput
  implements Serializable
{
  private String type;
  
  public String getType()
  {
    return type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public JSONInput withType(String type)
  {
    setType(type);
    return this;
  }
  
  public void setType(JSONType type)
  {
    setType(type == null ? null : type.toString());
  }
  
  public JSONInput withType(JSONType type)
  {
    setType(type);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.JSONInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */