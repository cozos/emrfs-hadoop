package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class RoutingRuleCondition
  implements Serializable
{
  String keyPrefixEquals;
  String httpErrorCodeReturnedEquals;
  
  public void setKeyPrefixEquals(String keyPrefixEquals)
  {
    this.keyPrefixEquals = keyPrefixEquals;
  }
  
  public String getKeyPrefixEquals()
  {
    return keyPrefixEquals;
  }
  
  public RoutingRuleCondition withKeyPrefixEquals(String keyPrefixEquals)
  {
    setKeyPrefixEquals(keyPrefixEquals);
    return this;
  }
  
  public void setHttpErrorCodeReturnedEquals(String httpErrorCodeReturnedEquals)
  {
    this.httpErrorCodeReturnedEquals = httpErrorCodeReturnedEquals;
  }
  
  public String getHttpErrorCodeReturnedEquals()
  {
    return httpErrorCodeReturnedEquals;
  }
  
  public RoutingRuleCondition withHttpErrorCodeReturnedEquals(String httpErrorCodeReturnedEquals)
  {
    setHttpErrorCodeReturnedEquals(httpErrorCodeReturnedEquals);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RoutingRuleCondition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */