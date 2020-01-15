package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class BucketPolicy
  implements Serializable
{
  private String policyText;
  
  public String getPolicyText()
  {
    return policyText;
  }
  
  public void setPolicyText(String policyText)
  {
    this.policyText = policyText;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */